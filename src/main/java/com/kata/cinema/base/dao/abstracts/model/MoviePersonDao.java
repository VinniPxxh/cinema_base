package com.kata.cinema.base.dao.abstracts.model;

import com.kata.cinema.base.dao.abstracts.dto.AbstractDao;
import com.kata.cinema.base.models.entitys.MoviePerson;

import java.util.List;
import java.util.Map;

public interface MoviePersonDao extends AbstractDao<Long, MoviePerson> {
    Map<Long, List<String>> getTwoMoviePersonMap();
}
