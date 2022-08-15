package com.kata.cinema.base.dao.abstracts.dto;


public interface RoleDao<Role, Long> {

    Role findByName(String name);
}
