package com.kata.cinema.base.service.impl.entity;

import com.kata.cinema.base.dao.abstracts.dto.ContentDao;
import com.kata.cinema.base.dao.abstracts.dto.MoviesDao;
import com.kata.cinema.base.dao.impl.dto.AbstractDaoImpl;
import com.kata.cinema.base.dao.impl.dto.ContentDaoImpl;
import com.kata.cinema.base.dao.impl.dto.MoviesDaoImpl;
import com.kata.cinema.base.models.entitys.Content;
import com.kata.cinema.base.models.entitys.Movies;
import com.kata.cinema.base.service.abstracts.model.PreviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

@Service
public class PreviewServiceImpl implements PreviewService {
    private final ContentDao contentDao;
    private final MoviesDao moviesDao;

    @Autowired
    public PreviewServiceImpl(ContentDao contentDao, MoviesDao moviesDao) {
        this.contentDao = contentDao;
        this.moviesDao = moviesDao;
    }

    @Transactional(rollbackFor = {IOException.class})
    @Override
    public void upload(Long id, String URL) {
        Content con = new Content();
        con.setContentUrl(URL);
        con.setMovies(moviesDao.getById(id).orElseThrow());
        con.setContentUrl(URL);
        contentDao.create(con);
    }
}
