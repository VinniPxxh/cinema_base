package com.kata.cinema.base.dao.abstracts.dto;

public interface FolderMovies extends AbstractDao<Long, FolderMovies> {

    FolderMovies findByUserId(long id);
}
