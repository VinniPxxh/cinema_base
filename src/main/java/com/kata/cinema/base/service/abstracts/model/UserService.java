package com.kata.cinema.base.service.abstracts.model;

import com.kata.cinema.base.models.entitys.User;

import java.util.List;

public interface UserService {

    User findByEmail(String email);


}
