package com.kata.cinema.base.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.Valid;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SearchUserResponseDto {

    private Long id;

    private String email;
    private String fullName;
    private String birthday;
    private String avatarUrl;

}
