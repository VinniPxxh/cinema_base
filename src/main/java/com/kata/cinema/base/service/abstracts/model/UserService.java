package com.kata.cinema.base.service.abstracts.model;

import com.kata.cinema.base.models.entitys.User;

import java.util.List;

public interface UserService {

    User register(User user);

    List<User> getAll();

    User findByEmail(String email);

    User findById(Long id);

    void deleteById(Long id);

}
