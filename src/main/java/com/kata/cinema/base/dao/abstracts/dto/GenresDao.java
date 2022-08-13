package com.kata.cinema.base.dao.abstracts.dto;

import com.kata.cinema.base.models.dto.GenreResponseDto;
import com.kata.cinema.base.models.entitys.Genres;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenresDao extends AbstractDao<Long, Genres> {
    List<GenreResponseDto> getListOfGenres(Long id, String name);
}
