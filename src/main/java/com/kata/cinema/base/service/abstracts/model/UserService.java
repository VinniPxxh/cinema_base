package com.kata.cinema.base.service.abstracts.model;

import com.kata.cinema.base.models.entitys.User;


public interface UserService {

    User findByEmail(String email);


}
