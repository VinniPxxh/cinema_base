package com.kata.cinema.base.webapp.controllers;

import com.kata.cinema.base.dao.abstracts.dto.PaginationDtoDao;
import com.kata.cinema.base.dao.impl.dto.SearchMovieResponseDtoPaginationDaoImpl;
import com.kata.cinema.base.models.dto.PageDto;
import com.kata.cinema.base.models.dto.SearchMovieResponseDto;
import com.kata.cinema.base.models.enums.MovieSortType;
import com.kata.cinema.base.service.abstracts.dto.PaginationDtoService;
import com.kata.cinema.base.service.abstracts.dto.SearchMovieResponseDtoPaginationService;
import com.kata.cinema.base.service.abstracts.model.MovieService;
import com.kata.cinema.base.service.impl.dto.PaginationDtoServiceImpl;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/search")
public class SearchRestController {

    SearchMovieResponseDtoPaginationService SearchMovieResponseDtoPaginationService;

    public SearchRestController(SearchMovieResponseDtoPaginationService paginationDtoService) {
        this.SearchMovieResponseDtoPaginationService = paginationDtoService;
    }

    @GetMapping("/movies/page/{pageNumber}")
    ResponseEntity<PageDto<SearchMovieResponseDto>> getMovies(@PathVariable(required = false) Integer pageNumber,
                             @RequestParam(required = false, defaultValue = "10") Integer itemsOnPage, @RequestParam(required = false) String name,
                             @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                             @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,
                             @RequestParam(required = false) List<String> genres, @RequestParam(required = false) Integer rars,
                             @RequestParam(required = false) Integer mpaa,
                             @RequestParam(required = false, defaultValue = "DATE_RELEASE_ASC") MovieSortType sortType) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("name",name);
        parameters.put("startDate",startDate);
        parameters.put("endDate",endDate);
        parameters.put("genres",genres);
        parameters.put("rars",rars);
        parameters.put("mpaa",mpaa);
        parameters.put("sortType",sortType);

        return ResponseEntity.ok(SearchMovieResponseDtoPaginationService.getPageDtoWithParameters(pageNumber, itemsOnPage, parameters));
    }

}
