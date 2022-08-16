package com.kata.cinema.base.dao.abstracts.dto;


public interface UserDao<User, Long> {

    User findUserByEmail(String email);
}
