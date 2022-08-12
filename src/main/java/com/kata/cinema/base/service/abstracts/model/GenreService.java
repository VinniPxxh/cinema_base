package com.kata.cinema.base.service.abstracts.model;

import com.kata.cinema.base.models.dto.GenreResponseDto;
import com.kata.cinema.base.models.entitys.Genres;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GenreService {
    List<GenreResponseDto> findGenres(Long id, String name);

    void save(Genres genres);

    void deleteById(Long id);

    void update(Genres genres);

    Genres getGenreById(Long id);
}
