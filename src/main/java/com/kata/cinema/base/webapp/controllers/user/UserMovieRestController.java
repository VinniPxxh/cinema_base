package com.kata.cinema.base.webapp.controllers.user;

import com.kata.cinema.base.models.dto.ScoreRequestDto;
import com.kata.cinema.base.models.dto.ScoreResponseDto;
import com.kata.cinema.base.service.abstracts.model.ScoreService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user/movies")
public class UserMovieRestController {

    private final ScoreService service;

    public UserMovieRestController(ScoreService service) {
        this.service = service;
    }

    @PostMapping("/scopes")
    public ResponseEntity<Object> createScoreMovies(ScoreRequestDto scoreRequestDto) {
        return ResponseEntity.ok(service.create(scoreRequestDto));
    }

    @GetMapping("/scopes/{id}")
    public ResponseEntity<Object> getOneScoreMovies(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @DeleteMapping("/scopes/{id}")
    public ResponseEntity<ScoreResponseDto> deleteScoreMovies(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.delete(id));
    }

}
