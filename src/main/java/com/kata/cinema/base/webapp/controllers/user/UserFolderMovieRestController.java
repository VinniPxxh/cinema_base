package com.kata.cinema.base.webapp.controllers.user;

import com.kata.cinema.base.dao.abstracts.dto.AbstractDao;
import com.kata.cinema.base.models.entitys.User;
import com.kata.cinema.base.service.abstracts.dto.FolderMovieResponsDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user/foldermovies")
public class UserFolderMovieRestController {

    private final AbstractDao abstractDao;

    public UserFolderMovieRestController(AbstractDao abstractDao) {
        this.abstractDao = abstractDao;
    }

    @GetMapping("{id}")
    public ResponseEntity<User> getOneUser(@PathVariable("id") Long id) {
        return ResponseEntity.ok(abstractDao.getById(id));
    }

    @GetMapping("userId")
    public ResponseEntity<List<FolderMovieResponsDto>> showAllUser() {
        List<FolderMovieResponsDto> allUsers = abstractDao.getAll();
        return ResponseEntity.ok(allUsers);
    }
}
