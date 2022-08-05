package com.kata.cinema.base.dao.impl.dto;

import com.kata.cinema.base.dao.abstracts.dto.FolderMovieResponsDtoDao;
import com.kata.cinema.base.models.dto.FolderMovieResponsDto;
import com.kata.cinema.base.models.entitys.FolderMovies;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.*;

@Repository
public class FolderMovieResponsDtoDaoImpl {

    private final FolderMovieResponsDtoDao folderMovieResponsDtoDao;
    @PersistenceContext
    protected EntityManager entityManager;

    public FolderMovieResponsDtoDaoImpl(FolderMovieResponsDtoDao folderMovieResponsDtoDao, EntityManager entityManager) {
        this.folderMovieResponsDtoDao = folderMovieResponsDtoDao;
        this.entityManager = entityManager;
    }

    public List<FolderMovieResponsDto> getAllByUserId(Long id) {
        return folderMovieResponsDtoDao.findAll();
    }

    public FolderMovieResponsDto getById(Long id) {
        FolderMovieResponsDto folderMovieResponsDto = new FolderMovieResponsDto();
        FolderMovies folderMovies = entityManager.find(FolderMovies.class, id);
        folderMovieResponsDto.setId(folderMovies.getId());
        folderMovieResponsDto.setCategory(folderMovies.getCategory());
        folderMovieResponsDto.setDescription(folderMovies.getDescription());
        folderMovieResponsDto.setName(folderMovies.getName());
        folderMovieResponsDto.setPrivacy(folderMovies.getPrivacy());
        return folderMovieResponsDto;
    }
}
