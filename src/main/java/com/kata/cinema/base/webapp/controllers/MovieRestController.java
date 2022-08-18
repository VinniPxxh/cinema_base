package com.kata.cinema.base.webapp.controllers;

import com.kata.cinema.base.models.dto.PageDto;
import com.kata.cinema.base.models.dto.TopMoviesResponseDto;
import com.kata.cinema.base.models.dto.response.MovieReleaseResponseDto;
import com.kata.cinema.base.models.enums.TopMoviesType;
import com.kata.cinema.base.service.abstracts.dto.TopMoviesResponseDtoPaginationService;
import com.kata.cinema.base.service.abstracts.model.MovieService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/movies")
public class MovieRestController {

    private final MovieService movieService;
    private final TopMoviesResponseDtoPaginationService topMoviesResponseDtoPaginationService;

    public MovieRestController(MovieService movieService, TopMoviesResponseDtoPaginationService topMoviesResponseDtoPaginationService) {
        this.movieService = movieService;
        this.topMoviesResponseDtoPaginationService = topMoviesResponseDtoPaginationService;
    }

    @GetMapping("/release")
    ResponseEntity<List<MovieReleaseResponseDto>> getReleaseFilms() {
        return ResponseEntity.ok(movieService.getReleaseFilms());
    }

    @GetMapping("/top")
    ResponseEntity<PageDto<TopMoviesResponseDto>> getTopMovies(@RequestParam(required = false) Integer pageNumber,
                                                               @RequestParam(required = false, defaultValue = "50") Integer itemsOnPage,
                                                               @RequestParam(required = false, defaultValue = "250") Integer count,
                                                               @RequestParam(required = false, defaultValue = "ORDER") TopMoviesType topMoviesType,
                                                               @RequestParam(required = false, name = "genres") List<Integer> genreId,
                                                               @RequestParam(required = false)
                                                               @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                                                               @RequestParam(required = false)
                                                               @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("count", count);
        parameters.put("topMoviesType", topMoviesType);
        parameters.put("genres", genreId);
        parameters.put("startDate", startDate);
        parameters.put("endDate", endDate);

        return ResponseEntity.ok(topMoviesResponseDtoPaginationService.getPageDtoWithParameters(pageNumber, itemsOnPage, parameters));
    }
}
