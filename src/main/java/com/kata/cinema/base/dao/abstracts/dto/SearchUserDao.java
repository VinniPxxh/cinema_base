package com.kata.cinema.base.dao.abstracts.dto;

import com.kata.cinema.base.models.dto.SearchUserResponseDto;
import com.kata.cinema.base.models.entitys.User;

import java.util.Optional;

public interface SearchUserDao extends AbstractDao<Long, User> {


    Optional<SearchUserResponseDto> findSearchUserByEmail(String email);
}
