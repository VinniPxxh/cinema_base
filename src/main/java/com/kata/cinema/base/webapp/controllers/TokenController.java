package com.kata.cinema.base.webapp.controllers;

import com.kata.cinema.base.models.dto.request.AuthDto;
import com.kata.cinema.base.models.dto.response.ResponseTokenDto;
import com.kata.cinema.base.models.entitys.User;
import com.kata.cinema.base.security.jwt.JwtUserProvider;
import com.kata.cinema.base.service.abstracts.model.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
public class TokenController {

    private final AuthenticationManager authenticationManager;
    private final JwtUserProvider jwtUserProvider;
    private final UserService userService;

    public TokenController(AuthenticationManager authenticationManager, JwtUserProvider jwtUserProvider, UserService userService) {
        this.authenticationManager = authenticationManager;
        this.jwtUserProvider = jwtUserProvider;
        this.userService = userService;
    }

    @PostMapping(value = "/token")
    public ResponseEntity<ResponseTokenDto> getToken(@RequestBody AuthDto authDto) {
        try {
            String username = authDto.getUsername();
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, authDto.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            User user = userService.findByEmail(authDto.getUsername());
            if (user == null) {
                throw new UsernameNotFoundException("User with email: " + username + " not found");
            }
            ResponseTokenDto responseTokenDto = new ResponseTokenDto(jwtUserProvider.createToken(authDto.getUsername()), authDto.getUsername());
            Map<String, Object> response = new HashMap<>();
            response.put("username", username);
            response.put("token", responseTokenDto);
            return ResponseEntity.ok(responseTokenDto);
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid email or password");
        }
    }
}
