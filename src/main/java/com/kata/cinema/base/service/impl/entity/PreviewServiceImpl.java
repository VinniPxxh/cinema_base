package com.kata.cinema.base.service.impl.entity;

import com.kata.cinema.base.dao.impl.dto.ContentDaoImpl;
import com.kata.cinema.base.service.abstracts.model.PreviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

@Service
public class PreviewServiceImpl implements PreviewService {
    private final ContentDaoImpl contentDao;

    @Autowired
    public PreviewServiceImpl(ContentDaoImpl contentDao) {
        this.contentDao = contentDao;
    }

    @Transactional(rollbackFor = {IOException.class})
    @Override
    public void upload(Long id, String URL) {
        id = contentDao.findById(id);
        contentDao.saveImageWithMovieId(URL, id);
    }
}
