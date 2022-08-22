package com.kata.cinema.base.webapp.controllers;

import com.kata.cinema.base.models.dto.response.NewsTitleResponseDto;
import com.kata.cinema.base.service.abstracts.model.NewsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/news/latest")
@Api(tags = "Новости")
public class NewsRestController {

    private final NewsService newsService;

    public NewsRestController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping
    @ApiOperation(value = "Получение списка последних новостей")
    public ResponseEntity<List<NewsTitleResponseDto>> getLatestNews() {
        return ResponseEntity.ok(newsService.getLatestNews());
    }

}
