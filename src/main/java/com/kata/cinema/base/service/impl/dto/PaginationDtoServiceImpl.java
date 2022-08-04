package com.kata.cinema.base.service.impl.dto;

import com.kata.cinema.base.dao.abstracts.dto.PaginationDtoDao;

import java.util.List;
import java.util.Map;

public class PaginationDtoServiceImpl implements PaginationDtoDao{

    private PaginationDtoDao paginationDtoDao;


    public PaginationDtoServiceImpl(PaginationDtoDao paginationDtoDao) {
        this.paginationDtoDao = paginationDtoDao;
    }


    @Override
    public List getItemsDto(Integer currentPage, Integer itemsOnPage, Map parameters) {
        return paginationDtoDao.getItemsDto(currentPage, itemsOnPage, parameters);
    }

    @Override
    public Long getResultTotal(Map parameters) {
        return paginationDtoDao.getResultTotal(parameters);
    }
}
