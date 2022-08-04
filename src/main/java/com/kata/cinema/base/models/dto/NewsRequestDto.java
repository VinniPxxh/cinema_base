package com.kata.cinema.base.models.dto;

import com.kata.cinema.base.models.enums.Rubric;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class NewsRequestDto {
    Rubric rubric;
    String title;
    String htmlBody;
}
