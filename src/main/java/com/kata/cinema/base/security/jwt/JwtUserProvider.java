package com.kata.cinema.base.security.jwt;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUserProvider {

    @Value("${jwt.token.time.valid}")
    private long validityTime;

    public String createToken(String username) {

        Date now = new Date();
        Date valid = new Date((now.getTime()) + validityTime);
        Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);


        Claims claims = Jwts.claims().setSubject(username);
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(valid)
                .signWith(key)
                .compact();
    }

}
