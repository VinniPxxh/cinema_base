package com.kata.cinema.base.service.impl.entity;

import com.kata.cinema.base.dao.impl.dto.ContentDaoImpl;
import com.kata.cinema.base.dao.impl.dto.MoviesDaoImpl;
import com.kata.cinema.base.models.entitys.Content;
import com.kata.cinema.base.service.abstracts.model.PreviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

@Service
public class PreviewServiceImpl implements PreviewService {
    private final ContentDaoImpl contentDao;
    private final MoviesDaoImpl movieDao;

    @Autowired
    public PreviewServiceImpl(ContentDaoImpl contentDao, MoviesDaoImpl movieDao) {
        this.contentDao = contentDao;
        this.movieDao = movieDao;
    }

    @Transactional(rollbackFor = {IOException.class})
    @Override
    public void upload(Long id, String URL) {
        Content con = new Content();
        con.setContentUrl(URL);
        con.setMovies(movieDao.findMovieById(id));
        con.setContentUrl(URL);
        contentDao.save(con);
//        contentDao.saveImageWithMovieId(URL, id);
    }
}
