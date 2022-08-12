package com.kata.cinema.base.dao.impl.model;

import com.kata.cinema.base.dao.abstracts.model.GenresDao;
import com.kata.cinema.base.dao.impl.dto.AbstractDaoImpl;
import com.kata.cinema.base.models.entitys.Genres;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GenresDaoImpl extends AbstractDaoImpl<Long, Genres> implements GenresDao {
    @Override
    public List<Genres> getAllFetch() {
        return entityManager.createQuery("select distinct g from Genres g left join fetch g.movies", Genres.class).getResultList();
    }
}
