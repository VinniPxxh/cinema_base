package com.kata.cinema.base.dao.impl.dto;

import com.kata.cinema.base.dao.abstracts.dto.MovieDao;
import com.kata.cinema.base.models.entitys.Movies;
import org.springframework.stereotype.Repository;


@Repository
public class MovieDaoImpl extends AbstractDaoImpl<Movies, Long> implements MovieDao {
    @Override
    public Movies findMovieById(Long id) {
        return entityManager.find(Movies.class, id);
    }

}
