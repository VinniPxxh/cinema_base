package com.kata.cinema.base.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class SearchUserResponseDto {

    @Id
    Long id;

    String email;
    String fullName;
    String birthday;
    String avatarUrl;

}
