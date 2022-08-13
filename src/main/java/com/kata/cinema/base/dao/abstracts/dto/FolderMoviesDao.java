package com.kata.cinema.base.dao.abstracts.dto;

public interface FolderMoviesDao extends AbstractDao<Long, FolderMoviesDao> {

    FolderMoviesDao findByUserId(long id);
}
