package com.kata.cinema.base.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class TopMoviesResponseDto {
    Long id;
    String name;
    String originalName;
    String countries;
    List<String> genres;
    List<String> actorsName;
    Integer time;
    String contentUrl;
    Integer countScore;
    Double avgScore;

    public TopMoviesResponseDto(Long id, String name, String originalName, String countries, Integer time, String contentUrl, Integer countScore, Double avgScore) {
        this.id = id;
        this.name = name;
        this.originalName = originalName;
        this.countries = countries;
        this.time = time;
        this.contentUrl = contentUrl;
        this.countScore = countScore;
        this.avgScore = avgScore;
    }
}
