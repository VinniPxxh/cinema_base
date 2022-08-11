package com.kata.cinema.base.dao.abstracts.dto;

import com.kata.cinema.base.models.dto.GenreResponseDto;
import com.kata.cinema.base.models.dto.MovieReleaseResponseDto;
import com.kata.cinema.base.models.entitys.Genres;

import java.util.List;

public interface GenresDao extends AbstractDao<Long, Genres> {
    List<GenreResponseDto> getListOfGenres();
}
