package com.kata.cinema.base.dao.impl.dto;

import com.kata.cinema.base.dao.abstracts.model.MoviesDao;
import com.kata.cinema.base.models.entitys.Movies;
import org.springframework.stereotype.Repository;


@Repository
public class MoviesDaoImpl extends AbstractDaoImpl<Long, Movies> implements MoviesDao {
}
