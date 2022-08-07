package com.kata.cinema.base.webapp.controllers;

import com.kata.cinema.base.models.dto.SearchUserResponseDto;
import com.kata.cinema.base.service.abstracts.model.SearchUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/search")
public class SearchRestController {

    private final SearchUserService searchUserService;

    @Autowired
    public SearchRestController(SearchUserService searchUserService) {
        this.searchUserService = searchUserService;
    }

    @GetMapping
    public ResponseEntity<SearchUserResponseDto> getUserByMail(
            @RequestParam(name = "email", required = false) String email) {
        return searchUserService.findSearchUserByEmail(email).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

}
