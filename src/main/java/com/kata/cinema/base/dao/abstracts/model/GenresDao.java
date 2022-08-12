package com.kata.cinema.base.dao.abstracts.model;

import com.kata.cinema.base.dao.abstracts.dto.AbstractDao;
import com.kata.cinema.base.models.entitys.Genres;

import java.util.List;

public interface GenresDao extends AbstractDao<Long, Genres> {
    List<Genres> getAllFetch();
}
