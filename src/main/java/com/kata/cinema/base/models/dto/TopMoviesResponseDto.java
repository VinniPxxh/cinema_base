package com.kata.cinema.base.models.dto;

import java.util.List;

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
}
