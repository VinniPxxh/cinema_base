package com.kata.cinema.base.dao.impl.dto;

import com.kata.cinema.base.dao.abstracts.dto.FolderMoviesDao;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class FolderMoviesDaoImpl extends AbstractDaoImpl<Long, FolderMoviesDao> implements FolderMoviesDao {

    private EntityManager entityManager;

    public FolderMoviesDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public FolderMoviesDao findByUserId(long id) {

        return (FolderMoviesDao) entityManager.createQuery("SELECT f from FolderMovies f where f.user=:id").setParameter("id", id).getSingleResult();
    }
}
