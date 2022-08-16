package com.kata.cinema.base.dao.impl.dto;

import com.kata.cinema.base.dao.abstracts.dto.GenresDao;
import com.kata.cinema.base.models.dto.GenreResponseDto;
import com.kata.cinema.base.models.entitys.Genres;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class GenresDaoImpl extends AbstractDaoImpl<Long, Genres> implements GenresDao {
    @Override
    public List<GenreResponseDto> getListOfGenres(Long id, String name) {
        return entityManager.createQuery("select new com.kata.cinema.base.models.dto.GenreResponseDto(g.id, g.name)" +
                        " from Genres g where g.id =:id and g.name =: name", GenreResponseDto.class)
                .setParameter("id", id)
                .setParameter("name", name)
                .getResultList();

    }
}