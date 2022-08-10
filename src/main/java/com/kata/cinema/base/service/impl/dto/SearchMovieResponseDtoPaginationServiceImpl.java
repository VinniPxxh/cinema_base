package com.kata.cinema.base.service.impl.dto;

import com.kata.cinema.base.dao.abstracts.dto.PaginationDtoDao;
import com.kata.cinema.base.models.dto.SearchMovieResponseDto;
import com.kata.cinema.base.service.abstracts.dto.PaginationDtoService;
import com.kata.cinema.base.service.abstracts.dto.SearchMovieResponseDtoPaginationService;
import org.springframework.stereotype.Service;

@Service
public class SearchMovieResponseDtoPaginationServiceImpl extends PaginationDtoServiceImpl<SearchMovieResponseDto> implements SearchMovieResponseDtoPaginationService {
    public SearchMovieResponseDtoPaginationServiceImpl(PaginationDtoDao<SearchMovieResponseDto> paginationDtoDao) {
        super(paginationDtoDao);
    }
}
