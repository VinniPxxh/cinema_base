package com.kata.cinema.base.service.impl.dto;

import com.kata.cinema.base.dao.abstracts.dto.FolderMovieResponsDtoDao;
import com.kata.cinema.base.models.dto.FolderMovieResponsDto;
import com.kata.cinema.base.service.abstracts.dto.FolderMovieResponsDtoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FolderMovieResponsDtoServiceImpl implements FolderMovieResponsDtoService {

    private final FolderMovieResponsDtoDao folderMovieResponsDtoDao;

    public FolderMovieResponsDtoServiceImpl(FolderMovieResponsDtoDao folderMovieResponsDtoDao) {
        this.folderMovieResponsDtoDao = folderMovieResponsDtoDao;
    }

    @Override
    public List<FolderMovieResponsDto> getAllByUserId(Long id) {
        return folderMovieResponsDtoDao.getAllByUserId(id);
    }

    @Override
    public FolderMovieResponsDto getById(Long id) {
        return folderMovieResponsDtoDao.getById(id);
    }

}
