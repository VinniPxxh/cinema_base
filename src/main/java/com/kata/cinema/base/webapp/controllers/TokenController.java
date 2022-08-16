package com.kata.cinema.base.webapp.controllers;
import com.kata.cinema.base.models.dto.RequestDto;
import com.kata.cinema.base.models.dto.ResponseTokenDto;
import com.kata.cinema.base.security.jwt.JwtUserProvider;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class TokenController {

    private AuthenticationManager authenticationManager;
    private JwtUserProvider jwtUserProvider;

    public TokenController(AuthenticationManager authenticationManager, JwtUserProvider jwtUserProvider) {
        this.authenticationManager = authenticationManager;
        this.jwtUserProvider = jwtUserProvider;
    }

    @RequestMapping(value = "/token", method = RequestMethod.POST)
    public ResponseEntity<ResponseTokenDto> getToken (RequestDto requestDto){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(requestDto.getUsername(),requestDto.getPassword()));
        ResponseTokenDto responseTokenDto = new ResponseTokenDto(jwtUserProvider.createToken(requestDto.getUsername()), requestDto.getUsername());
        return ResponseEntity.ok(responseTokenDto);
    }


}
