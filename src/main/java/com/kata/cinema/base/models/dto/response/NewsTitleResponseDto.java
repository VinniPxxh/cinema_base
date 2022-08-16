package com.kata.cinema.base.models.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class NewsTitleResponseDto {
    @NotNull
    private Long id;

    @NotBlank
    private String title;

}
