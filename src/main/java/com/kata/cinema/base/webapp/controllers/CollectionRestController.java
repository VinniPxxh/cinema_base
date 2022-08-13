package com.kata.cinema.base.webapp.controllers;

import com.kata.cinema.base.dao.abstracts.dto.CollectionDao;
import com.kata.cinema.base.dao.abstracts.dto.FolderMovies;
import com.kata.cinema.base.models.dto.CollectionRequestDto;
import com.kata.cinema.base.models.dto.CollectionResponseDto;
import com.kata.cinema.base.models.entitys.Collections;
import com.kata.cinema.base.models.enums.CollectionType;
import com.sun.xml.bind.v2.TODO;
import org.hibernate.Hibernate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping("/api/collections")
@Transactional
public class CollectionRestController {

    private CollectionDao collectionDao;
    private FolderMovies folderMovies;



    public CollectionRestController(CollectionDao collectionDao, FolderMovies folderMovies) {
        this.collectionDao = collectionDao;
        this.folderMovies = folderMovies;
    }

    @GetMapping
    public ResponseEntity<CollectionResponseDto> getCollectionResponseDto(Principal principal){

        String countViewedMovies;
        if(principal == null){
            countViewedMovies = null;
        }else{
//            TODO необходимо найти пользователя в репозитиории по имени из principal // countViewedMovies
        }

         Collections collections = collectionDao.findCollectionByType(CollectionType.MOVIES);
        System.out.println(collections);
        System.out.println(collections.getMovies().size());
//        CollectionResponseDto collectionResponseDto = new CollectionResponseDto(1L, "DOOM", "http://Url/DOOM_Movie.com", 2, 2);
        CollectionResponseDto collectionResponseDto = new CollectionResponseDto(collections.getId(), collections.getName(), collections.getCollectionUrl(), collections.getMovies().size(), null);

        return ResponseEntity.ok(collectionResponseDto);

    }

    @PostMapping
    public void postCollectionResponseDto(CollectionRequestDto collectionRequestDto){


    }

    @PutMapping("/{id}")
    public void deleteCollectionResponseDto(@PathVariable Long id){

    }

    @PatchMapping("/deactivate")
    public void deactivate(){

    }

    @PatchMapping("/activate")
    public void activate(){

    }

    @PostMapping("/{id}/movies")
    public void addMovie(@PathVariable String id){

    }

    @DeleteMapping("/{id}/movies")
    public void deleteMovie(@PathVariable String id){

    }


}
