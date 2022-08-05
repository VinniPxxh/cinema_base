package com.kata.cinema.base.webapp.controllers.user;

import com.kata.cinema.base.models.dto.FolderMovieResponsDto;
import com.kata.cinema.base.service.abstracts.dto.FolderMovieResponsDtoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user/foldermovies")
public class UserFolderMovieRestController {

    private final FolderMovieResponsDtoService folderMovieResponsDtoService;

    public UserFolderMovieRestController(FolderMovieResponsDtoService folderMovieResponsDtoService) {
        this.folderMovieResponsDtoService = folderMovieResponsDtoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<FolderMovieResponsDto> getOneFolderMovies(@PathVariable("id") Long id) {
        return ResponseEntity.ok(folderMovieResponsDtoService.getById(id));
    }

    @GetMapping("/userId")
    public ResponseEntity<List<FolderMovieResponsDto>> getByUserId(Long id) {
        return ResponseEntity.ok(folderMovieResponsDtoService.getAllByUserId(id));
    }

}
