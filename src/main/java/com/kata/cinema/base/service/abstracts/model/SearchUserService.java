package com.kata.cinema.base.service.abstracts.model;

import com.kata.cinema.base.models.dto.SearchUserResponseDto;

import java.util.Optional;

public interface SearchUserService {

    Optional<SearchUserResponseDto> findSearchUserByEmail(String email);
}
