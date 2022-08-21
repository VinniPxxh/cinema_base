package com.kata.cinema.base.webapp.controllers;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kata.cinema.base.exceptions.IdNotFoundException;
import com.kata.cinema.base.models.dto.CollectionRequestDto;
import com.kata.cinema.base.models.dto.CollectionResponseDto;

import com.kata.cinema.base.models.entitys.Collections;
import com.kata.cinema.base.models.entitys.FolderMovies;
import com.kata.cinema.base.models.entitys.Movies;
import com.kata.cinema.base.models.enums.CollectionType;
import com.kata.cinema.base.service.abstracts.model.CollectionService;
import com.kata.cinema.base.service.abstracts.model.FolderMoviesService;

import com.kata.cinema.base.service.abstracts.model.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/collections")
@Transactional
public class CollectionRestController {

    private CollectionService collectionService;
    private FolderMoviesService folderMoviesService;
    private MovieService movieService;


    public CollectionRestController(CollectionService collectionService, FolderMoviesService folderMoviesService, MovieService movieService) {
        this.collectionService = collectionService;
        this.folderMoviesService = folderMoviesService;
        this.movieService = movieService;
    }



//    TODO заменить user_id на Аутентифицированного пользователя (Principal)
    @GetMapping("/{user_id}")
    public ResponseEntity<CollectionResponseDto> getCollectionResponseDto(@PathVariable Long user_id) {

        FolderMovies folderMovies =  folderMoviesService.findByUserId(user_id);
        Integer countViewedMovies = folderMovies.getMovies().size();

        Collections collections = collectionService.findCollectionByType(CollectionType.MOVIES);
        CollectionResponseDto collectionResponseDto = new CollectionResponseDto(collections.getId(), collections.getName(), collections.getCollectionUrl(), collections.getMovies().size(), countViewedMovies);

        return ResponseEntity.ok(collectionResponseDto);
    }



    @PostMapping
    public ResponseEntity<Collections> postCollectionResponseDto(CollectionRequestDto collectionRequestDto) {
        Collections collections = new Collections(collectionRequestDto.getName(), collectionRequestDto.getType());
        collectionService.create(collections);

        return new ResponseEntity<>(collections, HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<CollectionRequestDto> updateCollectionResponseDto(@PathVariable Long id, CollectionRequestDto collectionRequestDto) {
        Collections updateCollections = collectionService.getById(id).orElseThrow();
        updateCollections.setName(collectionRequestDto.getName());
        updateCollections.setCollectionType(collectionRequestDto.getType());
        collectionService.update(updateCollections);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @PatchMapping("/{id}/deactivate")
    public ResponseEntity<Collections> deactivate(@PathVariable Long id) {
        Collections collectionsDeactivate = collectionService.getById(id).orElseThrow();
        collectionsDeactivate.setEnable(false);
        collectionService.update(collectionsDeactivate);
        Collections collections = new Collections(collectionsDeactivate.getName(), collectionsDeactivate.getEnable());
        return new ResponseEntity<>(collections,HttpStatus.OK);
    }

    @PatchMapping("/{id}/activate")
    public ResponseEntity<Collections> activate(@PathVariable Long id) {
        Collections collectionsActive = collectionService.getById(id).orElseThrow();
        collectionsActive.setEnable(true);
        collectionService.update(collectionsActive);
        Collections collections = new Collections(collectionsActive.getName(), collectionsActive.getEnable());
        return new ResponseEntity<>(collections,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CollectionResponseDto> deleteCollections(@PathVariable Long id) {
        if (collectionService.isExistById(id)) {
            collectionService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        throw new IdNotFoundException("There is no genre with ID: " + id + " , try again.");
    }

    @PostMapping("/{id}/movies")
    public ResponseEntity<Collections> addMovie(@PathVariable Long id,@RequestBody List<Long> movieIds) {
        Collections collectionsAddMovie = collectionService.getById(id).orElse(null);
        Set<Long> setMoviesId = new HashSet<>(movieIds);
        if (collectionsAddMovie != null) {
            Set<Movies> moviesSet = collectionsAddMovie.getMovies();
            if (moviesSet.isEmpty()) {
                for (Long i : setMoviesId) {
                    moviesSet.add(movieService.getById(i));
                }
            } else {
                Set<Long> availableFilmsId = new HashSet<>();
                for (Movies i : moviesSet) {
                    availableFilmsId.add(i.getId());
                }
                availableFilmsId.addAll(setMoviesId);
                for (Long i : availableFilmsId) {
                    moviesSet.add(movieService.getById(i));
                }
            }
            collectionService.update(collectionsAddMovie);
            return new ResponseEntity<>(collectionsAddMovie, HttpStatus.OK);
        } else {
            throw new RuntimeException("collections with id: " + id  + " does not exist!!!!!!");
        }
    }

    @DeleteMapping("/{id}/movies")
    public ResponseEntity<Collections> deleteMovie(@PathVariable Long id,@RequestBody List<Long> movieIds) {

        Collections collectionsDeleteMovie = collectionService.getById(id).orElse(null);
        Set<Long> setMoviesDeleteId = new HashSet<>(movieIds);
        if (collectionsDeleteMovie != null) {
            Set<Movies> moviesSet = collectionsDeleteMovie.getMovies();
            Set<Movies> deleteSet = new HashSet<>();
            if (!moviesSet.isEmpty()) {
                for (Movies i : moviesSet) {
                    for (Long n : setMoviesDeleteId) {
                        if (i.getId() == n) {
                            deleteSet.add(movieService.getById(n));
                        }
                    }
                }
                moviesSet.removeAll(deleteSet);
            } else {
                throw  new RuntimeException("movie in this collection: " + id + " is empty");
            }

            collectionService.update(collectionsDeleteMovie);
            return new ResponseEntity<>(collectionsDeleteMovie, HttpStatus.OK);
        } else {
            throw new RuntimeException("collections with id: " + id  + " does not exist!!!!!!!!!!");
        }

    }


}
