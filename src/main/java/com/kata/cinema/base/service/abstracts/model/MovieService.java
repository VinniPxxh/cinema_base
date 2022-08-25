package com.kata.cinema.base.service.abstracts.model;

import com.kata.cinema.base.models.dto.response.MovieReleaseResponseDto;
import com.kata.cinema.base.models.entitys.Movies;

import java.util.List;

public interface MovieService {


    List<MovieReleaseResponseDto> getReleaseFilms();

    Movies getById(Long id);


}
