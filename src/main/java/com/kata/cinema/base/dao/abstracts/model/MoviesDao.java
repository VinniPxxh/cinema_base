package com.kata.cinema.base.dao.abstracts.model;

import com.kata.cinema.base.dao.abstracts.dto.AbstractDao;
import com.kata.cinema.base.models.entitys.Movies;
import org.springframework.stereotype.Repository;

//TODO уже есть MoviesDao, удалить один из
@Repository
public interface MoviesDao extends AbstractDao<Long, Movies> {

}
