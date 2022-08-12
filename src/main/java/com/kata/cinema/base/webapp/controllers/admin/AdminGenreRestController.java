package com.kata.cinema.base.webapp.controllers.admin;

import com.kata.cinema.base.models.dto.GenreResponseDto;
import com.kata.cinema.base.models.entitys.Genres;
import com.kata.cinema.base.service.abstracts.model.GenreService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/moderator/genres")
public class AdminGenreRestController {
    private final GenreService genreService;


    public AdminGenreRestController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping
    public ResponseEntity<List<GenreResponseDto>> getGenres(@RequestParam Long id, String name) {
        genreService.findGenres(id, name);
        return new ResponseEntity<>(HttpStatus.FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteGenres(@PathVariable Long id) {
        genreService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HttpStatus> update(@RequestBody Genres genres) {
        genreService.update(genres);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<HttpStatus> addGenre(@RequestBody Genres genres) {
        genreService.save(genres);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
