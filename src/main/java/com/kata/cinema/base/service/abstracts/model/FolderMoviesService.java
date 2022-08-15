package com.kata.cinema.base.service.abstracts.model;

import com.kata.cinema.base.dao.abstracts.dto.FolderMoviesDao;

public interface FolderMoviesService {

    public FolderMoviesDao findByUserId(long id);
}
