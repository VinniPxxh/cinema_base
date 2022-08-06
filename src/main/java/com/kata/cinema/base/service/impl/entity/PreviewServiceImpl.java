package com.kata.cinema.base.service.impl.entity;

import com.kata.cinema.base.dao.impl.dto.ContentDaoImpl;
import com.kata.cinema.base.models.entitys.Content;
import com.kata.cinema.base.service.abstracts.model.PreviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

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
    public void upload(Long id, MultipartFile file) {
        contentDao.saveImageWithMovieId((Content) file, id);
        contentDao.create(id);
    }
}
