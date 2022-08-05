package com.kata.cinema.base.service.abstracts.dto;

import com.kata.cinema.base.models.dto.FolderMovieResponsDto;

import java.util.List;

public interface FolderMovieResponsDtoService {

    List<FolderMovieResponsDto> getAllByUserId(Long id);

    FolderMovieResponsDto getById(Long id);
}
