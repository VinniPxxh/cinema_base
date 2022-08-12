package com.kata.cinema.base.dao.impl.dto;

import com.kata.cinema.base.dao.abstracts.dto.TopMoviesResponseDtoPaginationDao;
import com.kata.cinema.base.models.dto.TopMoviesResponseDto;
import com.kata.cinema.base.models.entitys.Movies;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class TopMoviesResponseDtoPaginationDaoImpl extends AbstractDaoImpl<Long, Movies> implements TopMoviesResponseDtoPaginationDao {
    @Override
    public List<TopMoviesResponseDto> getItemsDto(Integer currentPage, Integer itemsOnPage, Map<String, Object> parameters) {
        return null;
    }

    @Override
    public Long getResultTotal(Map<String, Object> parameters) {
        return null;
    }
}
