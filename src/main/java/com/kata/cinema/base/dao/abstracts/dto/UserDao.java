package com.kata.cinema.base.dao.abstracts.dto;


import com.kata.cinema.base.models.entitys.User;

public interface UserDao extends AbstractDao<Long, User> {

    User findUserByEmail(String email);
}
