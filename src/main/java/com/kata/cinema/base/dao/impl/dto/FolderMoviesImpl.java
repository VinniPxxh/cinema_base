package com.kata.cinema.base.dao.impl.dto;

import com.kata.cinema.base.dao.abstracts.dto.FolderMovies;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class FolderMoviesImpl extends AbstractDaoImpl<Long, FolderMovies> implements FolderMovies {

    private EntityManager entityManager;

    public FolderMoviesImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public FolderMovies findByUserId(long id) {

        return (FolderMovies) entityManager.createQuery("SELECT f from FolderMovies f where f.user=:id").setParameter("id", id).getSingleResult();
    }
}
