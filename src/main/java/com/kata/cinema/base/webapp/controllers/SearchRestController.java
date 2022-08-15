package com.kata.cinema.base.webapp.controllers;

import com.kata.cinema.base.models.dto.SearchUserResponseDto;
import com.kata.cinema.base.service.abstracts.model.SearchUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/search")
public class SearchRestController {

    private final SearchUserService searchUserService;

    @Autowired
    public SearchRestController(SearchUserService searchUserService) {
        this.searchUserService = searchUserService;
    }

    @GetMapping
    public ResponseEntity<List<SearchUserResponseDto>> getUserByMail(
            @RequestParam(name = "email") String email) {
        List<SearchUserResponseDto> users = searchUserService.findSearchUserByEmail(email);
        return users.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(users);
    }

}
