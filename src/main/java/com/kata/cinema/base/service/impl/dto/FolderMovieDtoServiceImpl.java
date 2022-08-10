package com.kata.cinema.base.service.impl.dto;

import com.kata.cinema.base.dao.abstracts.dto.FolderMovieDtoDao;
import com.kata.cinema.base.models.dto.FolderMovieDto;
import com.kata.cinema.base.service.abstracts.dto.FolderMovieDtoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FolderMovieDtoServiceImpl implements FolderMovieDtoService {

    private final FolderMovieDtoDao folderMovieResponsDtoDao;

    public FolderMovieDtoServiceImpl(FolderMovieDtoDao folderMovieResponsDtoDao) {
        this.folderMovieResponsDtoDao = folderMovieResponsDtoDao;
    }

    @Override
    public List<FolderMovieDto> getAllByUserId(Long id) {
        return folderMovieResponsDtoDao.getAllByUserId(id);
    }

    @Override
    public Object getById(Long id) {
        return folderMovieResponsDtoDao.getById(id);
    }

}
