package com.kata.cinema.base.webapp.controllers.user;

import com.kata.cinema.base.models.dto.FolderMovieDto;
import com.kata.cinema.base.service.abstracts.dto.FolderMovieDtoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user/foldermovies")
public class UserFolderMovieRestController {

    private final FolderMovieDtoService folderMovieResponsDtoService;

    public UserFolderMovieRestController(FolderMovieDtoService folderMovieResponsDtoService) {
        this.folderMovieResponsDtoService = folderMovieResponsDtoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneFolderMovies(@PathVariable("id") Long id) {
        return ResponseEntity.ok(folderMovieResponsDtoService.getById(id));
    }

    @GetMapping("/userId")
    public ResponseEntity<List<FolderMovieDto>> getByUserId(Long id) {
        return ResponseEntity.ok(folderMovieResponsDtoService.getAllByUserId(id));
    }

}
