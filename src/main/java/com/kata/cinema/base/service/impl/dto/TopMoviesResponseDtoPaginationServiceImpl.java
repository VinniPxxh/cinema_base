package com.kata.cinema.base.service.impl.dto;

import com.kata.cinema.base.dao.abstracts.dto.PaginationDtoDao;
import com.kata.cinema.base.models.dto.TopMoviesResponseDto;
import com.kata.cinema.base.service.abstracts.dto.TopMoviesResponseDtoPaginationService;
import org.springframework.stereotype.Service;

@Service
public class TopMoviesResponseDtoPaginationServiceImpl extends PaginationDtoServiceImpl<TopMoviesResponseDto> implements TopMoviesResponseDtoPaginationService {

    public TopMoviesResponseDtoPaginationServiceImpl(PaginationDtoDao<TopMoviesResponseDto> paginationDtoDao) {
        super(paginationDtoDao);
    }
}
