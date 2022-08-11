package com.kata.cinema.base.dao.abstracts.dto;


public interface UserRepositoryDto<User, Long> {

    User findUserByEmail(String email);
}
