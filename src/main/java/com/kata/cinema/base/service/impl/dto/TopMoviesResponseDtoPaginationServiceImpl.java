package com.kata.cinema.base.service.impl.dto;

import com.kata.cinema.base.dao.abstracts.dto.PaginationDtoDao;
import com.kata.cinema.base.models.dto.PageDto;
import com.kata.cinema.base.models.dto.TopMoviesResponseDto;
import com.kata.cinema.base.service.abstracts.dto.TopMoviesResponseDtoPaginationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TopMoviesResponseDtoPaginationServiceImpl extends PaginationDtoServiceImpl<TopMoviesResponseDto> implements TopMoviesResponseDtoPaginationService {

    public TopMoviesResponseDtoPaginationServiceImpl(PaginationDtoDao<TopMoviesResponseDto> paginationDtoDao) {

        super(paginationDtoDao);
    }

    @Override
    public PageDto<TopMoviesResponseDto> getPageDto(Integer currentPage, Integer itemsOnPage) {
        PageDto<TopMoviesResponseDto> dtos = super.getPageDto(currentPage, itemsOnPage);
        return dtos;
    }

    @Override
    public PageDto<TopMoviesResponseDto> getPageDtoWithParameters(Integer currentPage, Integer itemsOnPage, Map<String, Object> parameters) {
        PageDto<TopMoviesResponseDto> dtos = super.getPageDtoWithParameters(currentPage, itemsOnPage, parameters);
        return dtos;
    }
}
