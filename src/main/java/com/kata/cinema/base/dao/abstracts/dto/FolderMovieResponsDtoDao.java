package com.kata.cinema.base.dao.abstracts.dto;

import com.kata.cinema.base.models.dto.FolderMovieResponsDto;
import com.kata.cinema.base.models.entitys.FolderMovies;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FolderMovieResponsDtoDao extends JpaRepository<FolderMovieResponsDto, FolderMovies> {

    List<FolderMovieResponsDto> getAllByUserId(Long id);

    FolderMovieResponsDto getById(Long id);

}
