package com.kata.cinema.base.models.dto;

import com.kata.cinema.base.models.enums.Rubric;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class NewsResponseDto {
    @Id
    Long id;
    Rubric rubric;
    LocalDate date;
    String title;
    String description;
}
