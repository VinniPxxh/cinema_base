package com.kata.cinema.base.webapp.controllers.admin;

import com.kata.cinema.base.models.dto.GenreResponseDto;
import com.kata.cinema.base.models.entitys.Genres;
import com.kata.cinema.base.service.abstracts.model.GenreService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/moderator/genres")
public class AdminGenreRestController {
    private final GenreService genreService;

    public AdminGenreRestController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<GenreResponseDto>> getGenres(@PathVariable Long id, String name) {
        return ResponseEntity.ok(genreService.findGenres(id, name));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GenreResponseDto> deleteGenres(@PathVariable Long id) {
        genreService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GenreResponseDto> update(@RequestBody Genres genres) {
        genreService.update(genres);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<GenreResponseDto> addGenre(@RequestBody Genres genres) {
        genreService.save(genres);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
