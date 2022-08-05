package com.kata.cinema.base.webapp.controllers;
import com.kata.cinema.base.models.dto.RequestDto;
import com.kata.cinema.base.security.jwt.JwtUserProvider;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@Controller
public class TokenController {

    private AuthenticationManager authenticationManager;
    private JwtUserProvider jwtUserProvider;

    public TokenController(AuthenticationManager authenticationManager, JwtUserProvider jwtUserProvider) {
        this.authenticationManager = authenticationManager;
        this.jwtUserProvider = jwtUserProvider;
    }

    @RequestMapping(value = "/token", method = RequestMethod.POST)
    public ResponseEntity getToken (RequestDto requestDto){
        String username = requestDto.getUsername();
        String password = requestDto.getPassword();
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        String token = jwtUserProvider.createToken(username);
        Map<Object, Object> response = new HashMap<>();
        response.put("username", username);
        response.put("token", token);
        return ResponseEntity.ok(response);
    }


}
