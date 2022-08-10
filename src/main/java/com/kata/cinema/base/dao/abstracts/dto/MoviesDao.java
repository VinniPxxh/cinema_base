package com.kata.cinema.base.dao.abstracts.dto;

import com.kata.cinema.base.models.entitys.Movies;
import org.springframework.stereotype.Repository;

@Repository
public interface MoviesDao extends AbstractDao<Long, Movies> {

}
