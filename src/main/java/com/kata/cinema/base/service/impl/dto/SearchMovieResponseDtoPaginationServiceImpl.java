package com.kata.cinema.base.service.impl.dto;

import com.kata.cinema.base.dao.abstracts.dto.PaginationDtoDao;
import com.kata.cinema.base.dao.abstracts.model.GenresDao;
import com.kata.cinema.base.models.dto.PageDto;
import com.kata.cinema.base.models.dto.SearchMovieResponseDto;
import com.kata.cinema.base.models.entitys.Genres;
import com.kata.cinema.base.models.entitys.Movies;
import com.kata.cinema.base.service.abstracts.dto.PaginationDtoService;
import com.kata.cinema.base.service.abstracts.dto.SearchMovieResponseDtoPaginationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SearchMovieResponseDtoPaginationServiceImpl extends PaginationDtoServiceImpl<SearchMovieResponseDto> implements SearchMovieResponseDtoPaginationService {

    GenresDao genresDao;
    public SearchMovieResponseDtoPaginationServiceImpl(PaginationDtoDao<SearchMovieResponseDto> paginationDtoDao, GenresDao genresDao) {
        super(paginationDtoDao);
        this.genresDao = genresDao;
    }

    @Override
    public PageDto<SearchMovieResponseDto> getPageDtoWithParameters(Integer currentPage, Integer itemsOnPage, Map<String, Object> parameters) {
        PageDto<SearchMovieResponseDto> pageDto = super.getPageDtoWithParameters(currentPage, itemsOnPage, parameters);
        List<Genres> genresList = genresDao.getAllFetch();
        System.out.println(genresList);
        for (Genres g : genresList) {
            for (Movies m : g.getMovies()) {
                for (SearchMovieResponseDto dto : pageDto.getEntities()) {
                    if (dto.getId().equals(m.getId())){
                        dto.getGenres().add(g.getName());
                    }
                }
            }
        }
        return pageDto;
    }
}
