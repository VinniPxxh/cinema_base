package com.kata.cinema.base.security.config;

import com.kata.cinema.base.security.filter.TokenAuthenticationFilter;
import com.kata.cinema.base.security.jwt.JwtUserProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class JwtConfigurer extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {
    private final AuthenticationManager authenticationManager;
    private final JwtUserProvider jwtUserProvider;
    @Autowired
    public JwtConfigurer(AuthenticationManager authenticationManager, JwtUserProvider jwtUserProvider) {
        this.authenticationManager = authenticationManager;
        this.jwtUserProvider = jwtUserProvider;
    }

    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {
        TokenAuthenticationFilter tokenAuthenticationFilter = new TokenAuthenticationFilter(authenticationManager, jwtUserProvider);
        httpSecurity.addFilterBefore(tokenAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
