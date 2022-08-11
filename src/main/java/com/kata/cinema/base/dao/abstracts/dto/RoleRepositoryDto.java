package com.kata.cinema.base.dao.abstracts.dto;


public interface RoleRepositoryDto<Role, Long> {

    Role findByName(String name);
}
