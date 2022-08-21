package com.kata.cinema.base.webapp.controllers;


import com.kata.cinema.base.models.dto.CollectionRequestDto;
import com.kata.cinema.base.models.dto.CollectionResponseDto;

import com.kata.cinema.base.models.entitys.Collections;
import com.kata.cinema.base.models.entitys.FolderMovies;
import com.kata.cinema.base.models.entitys.Movies;
import com.kata.cinema.base.models.enums.CollectionType;
import com.kata.cinema.base.service.abstracts.model.CollectionService;
import com.kata.cinema.base.service.abstracts.model.FolderMoviesService;

import com.kata.cinema.base.service.abstracts.model.MovieService;
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



    @GetMapping("/{userid}")
    public ResponseEntity<CollectionResponseDto> getCollectionResponseDto(@PathVariable Long userid){

            FolderMovies folderMovies =  folderMoviesService.findByUserId(userid);
            Integer countViewedMovies = folderMovies.getMovies().size();

        Collections collections = collectionService.findCollectionByType(CollectionType.MOVIES);
        CollectionResponseDto collectionResponseDto = new CollectionResponseDto(collections.getId(), collections.getName(), collections.getCollectionUrl(), collections.getMovies().size(), countViewedMovies);

        return ResponseEntity.ok(collectionResponseDto);
    }

    @PostMapping
    public void postCollectionResponseDto(CollectionRequestDto collectionRequestDto){
        collectionService.create(new Collections(collectionRequestDto.getName(), collectionRequestDto.getType()));

    }

    @PutMapping("/{id}")
    public void deleteCollectionResponseDto(@PathVariable Long id, CollectionRequestDto collectionRequestDto){
        Collections updateCollections = collectionService.getById(id).orElse(null);
        assert updateCollections != null;
        updateCollections.setName(collectionRequestDto.getName());
        updateCollections.setCollectionType(collectionRequestDto.getType());
        collectionService.update(updateCollections);

    }

    @PatchMapping("/{id}/deactivate")
    public void deactivate(@PathVariable Long id){
        Collections collectionsDeactivate = collectionService.getById(id).orElse(null);
        assert collectionsDeactivate != null;
        collectionsDeactivate.setEnable(false);
        collectionService.update(collectionsDeactivate);
    }

    @PatchMapping("/{id}/activate")
    public void activate(@PathVariable Long id){
        Collections collectionsActive = collectionService.getById(id).orElse(null);
        assert collectionsActive != null;
        collectionsActive.setEnable(true);
        collectionService.update(collectionsActive);

    }

    @DeleteMapping("/{id}")
    public void deleteCollections(@PathVariable Long id){
        collectionService.deleteById(id);
    }

    @PostMapping("/{id}/movies")
    public void addMovie(@PathVariable Long id,@RequestBody List<Long> movieIds){
        Collections collectionsAddMovie = collectionService.getById(id).orElse(null);
        Set<Long> setMoviesId = new HashSet<>(movieIds);
        if(collectionsAddMovie != null){
            Set<Movies> moviesSet = collectionsAddMovie.getMovies();
            if(moviesSet.isEmpty()){
                for (Long i : setMoviesId){
                    moviesSet.add(movieService.getById(i));
                }
            }else{
                Set<Long> availableFilmsId = new HashSet<>();
                for (Movies i : moviesSet){
                    availableFilmsId.add(i.getId());
                }
                availableFilmsId.addAll(setMoviesId);
                for (Long i : availableFilmsId){
                    moviesSet.add(movieService.getById(i));
                }
            }
            collectionService.update(collectionsAddMovie);
        }else{
            throw new RuntimeException("collections with id: " + id  + "does not exist");
        }
    }

    @DeleteMapping("/{id}/movies")
    public void deleteMovie(@PathVariable Long id,@RequestBody List<Long> movieIds){

        Collections collectionsDeleteMovie = collectionService.getById(id).orElse(null);
        Set<Long> setMoviesDeleteId = new HashSet<>(movieIds);
        if(collectionsDeleteMovie != null){
            Set<Movies> moviesSet = collectionsDeleteMovie.getMovies();
            Set<Movies> deleteSet = new HashSet<>();
            if (!moviesSet.isEmpty()){
                for (Movies i : moviesSet){
                    for (Long n : setMoviesDeleteId){
                        if(i.getId() == n){
                            deleteSet.add(movieService.getById(n));
                        }
                    }
                }
                moviesSet.removeAll(deleteSet);
            }else{
                throw  new RuntimeException("movie in this collection: " + id + " is empty");
            }

            collectionService.update(collectionsDeleteMovie);
        }else{
            throw new RuntimeException("collections with id: " + id  + "does not exist");
        }

    }


}
