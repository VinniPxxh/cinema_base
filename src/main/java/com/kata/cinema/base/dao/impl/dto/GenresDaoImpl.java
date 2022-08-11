package com.kata.cinema.base.dao.impl.dto;

import com.kata.cinema.base.dao.abstracts.dto.GenresDao;
import com.kata.cinema.base.models.dto.GenreResponseDto;
import com.kata.cinema.base.models.dto.MovieReleaseResponseDto;
import com.kata.cinema.base.models.entitys.Genres;
import com.kata.cinema.base.models.enums.Type;

import java.time.LocalDate;
import java.util.List;

public class GenresDaoImpl extends AbstractDaoImpl<Long, Genres> implements GenresDao {
    @Override
    public List<GenreResponseDto> getListOfGenres() {
        return (List<GenreResponseDto>) entityManager.createQuery("select new com.kata.cinema.base.models.dto.GenreResponseDto" +
                "(g.id, g.name) from Genres g where g.id =: id and g.name =: name");

    }
}
