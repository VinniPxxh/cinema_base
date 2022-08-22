package com.kata.cinema.base.webapp.controllers;

import com.kata.cinema.base.models.dto.request.AuthDto;
import com.kata.cinema.base.models.dto.response.ResponseTokenDto;
import com.kata.cinema.base.security.jwt.JwtUserProvider;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Api(tags = "Токен")
public class TokenController {

    private AuthenticationManager authenticationManager;
    private JwtUserProvider jwtUserProvider;

    public TokenController(AuthenticationManager authenticationManager, JwtUserProvider jwtUserProvider) {
        this.authenticationManager = authenticationManager;
        this.jwtUserProvider = jwtUserProvider;
    }

    @PostMapping(value = "/token")
    @ApiOperation(value = "Получение токена")
    public ResponseEntity<ResponseTokenDto> getToken(AuthDto authDto) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authDto.getUsername(), authDto.getPassword()));
        ResponseTokenDto responseTokenDto = new ResponseTokenDto(jwtUserProvider.createToken(authDto.getUsername()), authDto.getUsername());
        return ResponseEntity.ok(responseTokenDto);
    }


}
