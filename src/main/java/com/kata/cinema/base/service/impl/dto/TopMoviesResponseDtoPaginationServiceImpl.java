package com.kata.cinema.base.service.impl.dto;

import com.kata.cinema.base.dao.abstracts.dto.PaginationDtoDao;
import com.kata.cinema.base.dao.abstracts.model.GenresDao;
import com.kata.cinema.base.dao.abstracts.model.MoviePersonDao;
import com.kata.cinema.base.models.dto.PageDto;
import com.kata.cinema.base.models.dto.TopMoviesResponseDto;
import com.kata.cinema.base.models.entitys.Genres;
import com.kata.cinema.base.models.entitys.MoviePerson;
import com.kata.cinema.base.models.entitys.Movies;
import com.kata.cinema.base.service.abstracts.dto.TopMoviesResponseDtoPaginationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TopMoviesResponseDtoPaginationServiceImpl extends PaginationDtoServiceImpl<List<TopMoviesResponseDto>> implements TopMoviesResponseDtoPaginationService {

    private final GenresDao genresDao;
    private final MoviePersonDao moviePersonDao;

    public TopMoviesResponseDtoPaginationServiceImpl(PaginationDtoDao<List<TopMoviesResponseDto>> paginationDtoDao, GenresDao genresDao, MoviePersonDao moviePersonDao) {
        super(paginationDtoDao);
        this.genresDao = genresDao;
        this.moviePersonDao = moviePersonDao;
    }

    @Override
    public PageDto<List<TopMoviesResponseDto>> getPageDtoWithParameters(Integer currentPage, Integer itemsOnPage, Map<String, Object> parameters) {
        PageDto<List<TopMoviesResponseDto>> pageDto = super.getPageDtoWithParameters(currentPage, itemsOnPage, parameters);
        List<Genres> genresList = genresDao.getAllFetch();
        for (Genres g : genresList) {
            for (Movies m : g.getMovies()) {
                for (List<TopMoviesResponseDto> dtoList : pageDto.getEntities()) {
                    for (TopMoviesResponseDto dto : dtoList) {
                        if (dto.getId().equals(m.getId())){
                            dto.getGenres().add(g.getName());
                        }
                    }
                }
            }
        }
        List<MoviePerson> moviePersonList = moviePersonDao.getAllFetch();
        for (MoviePerson mp : moviePersonList) {
            for (List<TopMoviesResponseDto> dtoList : pageDto.getEntities()) {
                for (TopMoviesResponseDto dto : dtoList) {
                    if (mp.getMovie().getId().equals(dto.getId())) {
                        dto.getActorsName().add(mp.getNameCharacter());
                    }
                }
            }
        }
        return pageDto;
    }
}
