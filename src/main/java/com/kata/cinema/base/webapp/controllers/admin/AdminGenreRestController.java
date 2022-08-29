package com.kata.cinema.base.webapp.controllers.admin;

import com.kata.cinema.base.exceptions.IdNotFoundException;
import com.kata.cinema.base.models.dto.GenreResponseDto;
import com.kata.cinema.base.models.entitys.Genres;
import com.kata.cinema.base.service.abstracts.model.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/genres")
public class AdminGenreRestController {
    private final GenreService genreService;

    @Autowired
    public AdminGenreRestController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping
    public ResponseEntity<List<GenreResponseDto>> getGenres() {
        return ResponseEntity.ok(genreService.findGenres());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GenreResponseDto> deleteGenres(@PathVariable Long id) throws IdNotFoundException {
        if (genreService.isExistById(id)) {
            genreService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        throw new IdNotFoundException("There is no genre with ID: " + id + " , try again.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<GenreResponseDto> update(@PathVariable Long id, @RequestParam String name) {
        Genres genres = genreService.getById(id).orElseThrow();
        genres.setName(name);
        genreService.update(genres);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<GenreResponseDto> addGenre(@RequestParam String name) {
        genreService.create(new Genres(name));
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
