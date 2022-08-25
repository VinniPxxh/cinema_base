package com.kata.cinema.base.security.jwt;

import com.kata.cinema.base.models.entitys.User;


public class JwtUserFactory {

    public JwtUserFactory() {
    }

    public static User create(User user) {
        return new User(
                user.getId(),
                user.getEmail(),
                user.getFirstName(),
                user.getLastName(),
                user.getPassword(),
                user.getBirthday(),
                user.getAvatarUrl()
        );
    }
}
