package com.kata.cinema.base.webapp.controllers;

import com.kata.cinema.base.models.dto.MovieReleaseResponseDto;
import com.kata.cinema.base.service.abstracts.model.MovieService;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/movies/release")
public class MovieRestController {

    MovieService movieService;

    public MovieRestController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    @ResponseBody
    ResponseEntity<List<MovieReleaseResponseDto>> getReleaseFilms() {
        return ResponseEntity.ok(movieService.getReleaseFilms());
    }
}
