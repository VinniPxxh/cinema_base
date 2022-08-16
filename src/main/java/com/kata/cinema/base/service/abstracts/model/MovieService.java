package com.kata.cinema.base.service.abstracts.model;

import com.kata.cinema.base.models.dto.response.MovieReleaseResponseDto;

import java.util.List;

public interface MovieService {

    public List<MovieReleaseResponseDto> getReleaseFilms();
}
