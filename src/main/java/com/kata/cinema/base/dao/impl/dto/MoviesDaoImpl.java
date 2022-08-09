package com.kata.cinema.base.dao.impl.dto;

import com.kata.cinema.base.dao.abstracts.dto.MoviesDao;
import com.kata.cinema.base.models.entitys.Movies;
import org.springframework.stereotype.Repository;


@Repository
public class MoviesDaoImpl extends AbstractDaoImpl<Movies, Long> implements MoviesDao {
    @Override
    public Movies findMovieById(Long id) {
        return entityManager.find(Movies.class, id);
    }

}
