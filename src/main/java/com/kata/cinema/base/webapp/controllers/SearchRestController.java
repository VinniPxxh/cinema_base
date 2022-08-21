package com.kata.cinema.base.webapp.controllers;

import com.kata.cinema.base.models.dto.PageDto;
import com.kata.cinema.base.models.dto.SearchUserResponseDto;
import com.kata.cinema.base.models.dto.response.SearchMovieResponseDto;
import com.kata.cinema.base.models.enums.MovieSortType;
import com.kata.cinema.base.service.abstracts.dto.SearchMovieResponseDtoPaginationService;
import com.kata.cinema.base.service.abstracts.model.SearchUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/search")
public class SearchRestController {

    private final SearchUserService searchUserService;
    SearchMovieResponseDtoPaginationService searchMovieResponseDtoPaginationService;

    @Autowired
    public SearchRestController(SearchUserService searchUserService, SearchMovieResponseDtoPaginationService paginationDtoService) {
        this.searchUserService = searchUserService;
        this.searchMovieResponseDtoPaginationService = paginationDtoService;
    }

    @GetMapping
    public ResponseEntity<List<SearchUserResponseDto>> getUserByMail(
            @RequestParam(name = "email") String email) {
        List<SearchUserResponseDto> users = searchUserService.findSearchUserByEmail(email);
        return users.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(users);
    }


    @GetMapping("/movies/page/{pageNumber}")
    ResponseEntity<PageDto<SearchMovieResponseDto>> getMovies(@PathVariable Integer pageNumber,
                                                              @RequestParam(required = false, defaultValue = "10") Integer itemsOnPage, @RequestParam String name,
                                                              @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                                                              @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,
                                                              @RequestParam(required = false) List<String> genres, @RequestParam(required = false) Integer rars,
                                                              @RequestParam(required = false) Integer mpaa,
                                                              @RequestParam(required = false, defaultValue = "DATE_RELEASE_ASC") MovieSortType sortType) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("name", name);
        parameters.put("startDate", startDate);
        parameters.put("endDate", endDate);
        parameters.put("genres", genres);
        parameters.put("rars", rars);
        parameters.put("mpaa", mpaa);
        parameters.put("sortType", sortType);

        return ResponseEntity.ok(searchMovieResponseDtoPaginationService.getPageDtoWithParameters(pageNumber, itemsOnPage, parameters));
    }
}
