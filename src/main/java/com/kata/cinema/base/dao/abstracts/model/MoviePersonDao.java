package com.kata.cinema.base.dao.abstracts.model;

import com.kata.cinema.base.dao.abstracts.dto.AbstractDao;
import com.kata.cinema.base.models.entitys.MoviePerson;

import java.util.List;

public interface MoviePersonDao extends AbstractDao<Long, MoviePerson> {
    public List<MoviePerson> getAllFetch();
}
