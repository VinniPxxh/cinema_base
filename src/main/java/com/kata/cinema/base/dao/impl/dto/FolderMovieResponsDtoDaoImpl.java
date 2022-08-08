package com.kata.cinema.base.dao.impl.dto;

import com.kata.cinema.base.dao.abstracts.dto.FolderMovieResponsDtoDao;
import com.kata.cinema.base.models.dto.FolderMovieResponsDto;
import com.kata.cinema.base.models.entitys.FolderMovies;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;


@Repository
public class FolderMovieResponsDtoDaoImpl {

    private final FolderMovieResponsDtoDao folderMovieResponsDtoDao;

    private Session session;

    @PersistenceContext
    protected EntityManager entityManager;

    public FolderMovieResponsDtoDaoImpl(FolderMovieResponsDtoDao folderMovieResponsDtoDao, EntityManager entityManager) {
        this.folderMovieResponsDtoDao = folderMovieResponsDtoDao;
        this.entityManager = entityManager;
    }

    public List<FolderMovieResponsDto> getAllByUserId(Long id) {
        return session.createQuery("SELECT a.category, a.privacy, a.name, a.description FROM FolderMovieResponsDto a", FolderMovieResponsDto.class).getResultList();
    }

    public FolderMovieResponsDto getById(Long id) {
        return (FolderMovieResponsDto) session.createQuery("SELECT e.category, e.privacy, e.name, e.description FROM FolderMovieResponsDto e where e.id in (:id)");
    }
}
