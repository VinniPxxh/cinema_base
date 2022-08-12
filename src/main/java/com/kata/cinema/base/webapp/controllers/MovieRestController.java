package com.kata.cinema.base.webapp.controllers;

import com.kata.cinema.base.models.dto.MovieReleaseResponseDto;
import com.kata.cinema.base.models.dto.PageDto;
import com.kata.cinema.base.models.dto.TopMoviesResponseDto;
import com.kata.cinema.base.models.entitys.Genres;
import com.kata.cinema.base.models.enums.TopMoviesType;
import com.kata.cinema.base.service.abstracts.model.MovieService;
import org.springframework.core.convert.ConversionService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieRestController {

    MovieService movieService;

    public MovieRestController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/release")
    ResponseEntity<List<MovieReleaseResponseDto>> getReleaseFilms() {
        return ResponseEntity.ok(movieService.getReleaseFilms());
    }

    @GetMapping("/top")
    ResponseEntity<PageDto<List<TopMoviesResponseDto>>> getTopMovies(@RequestParam(required = false, defaultValue = "250") Integer count,
                                                                     @RequestParam() TopMoviesType topMoviesType,
                                                                     @RequestParam() Genres genres,
                                                                     @RequestParam(required = false)
                                                                     @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                                                                     @RequestParam(required = false)
                                                                     @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {

    }
}
