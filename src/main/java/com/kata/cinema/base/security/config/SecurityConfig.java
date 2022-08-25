package com.kata.cinema.base.security.config;

import com.kata.cinema.base.security.filter.TokenAuthenticationFilter;
import com.kata.cinema.base.security.service.JwtUserDetailService;
import com.kata.cinema.base.security.jwt.JwtUserProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    private final JwtUserDetailService userDetailService;

    private final JwtUserProvider jwtUserProvider;


    @Autowired
    public SecurityConfig(JwtUserDetailService userDetailService, JwtUserProvider jwtUserProvider) {
        this.userDetailService = userDetailService;
        this.jwtUserProvider = jwtUserProvider;
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailService).passwordEncoder(passwordEncoder());
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .httpBasic().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/api/admin/**").hasRole("ADMIN")
                .antMatchers("/api/publicist/**").hasRole("PUBLICIST")
                .antMatchers("/api/user/**").hasRole("USER")
                .antMatchers("/token").permitAll()
                .anyRequest().authenticated()
                .and().formLogin()
                .usernameParameter("email")
                .passwordParameter("password")
                .permitAll();
        http.addFilter(new TokenAuthenticationFilter(authenticationManagerBean(), jwtUserProvider));
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
