package com.kata.cinema.base.webapp.controllers.publicist;

import com.kata.cinema.base.models.dto.NewsRequestDto;
import com.kata.cinema.base.models.dto.NewsResponseDto;
import com.kata.cinema.base.models.entitys.News;
import com.kata.cinema.base.models.enums.Rubric;
import com.kata.cinema.base.service.abstracts.dto.NewsResponseDtoService;
import com.kata.cinema.base.service.abstracts.model.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController("/api/publicist/news")
public class PublicistNewsRestController {

    NewsService newsService;
    NewsResponseDtoService newsResponseDtoService;

    @Autowired
    public PublicistNewsRestController(NewsService newsService, NewsResponseDtoService newsResponseDtoService) {
        this.newsService = newsService;
        this.newsResponseDtoService = newsResponseDtoService;
    }

    @ResponseBody
    @GetMapping
    public ResponseEntity<List<NewsResponseDto>> getNews(@RequestParam(value = "startDate", required = false) LocalDate startDate,
                                                         @RequestParam(value = "endDate", required = false) LocalDate endDate,
                                                         @RequestParam(value = "rubric", required = false)Rubric rubric) {
        return ResponseEntity.ok(newsResponseDtoService.getAllNews(startDate, endDate, rubric));

    }
    @PostMapping
    public ResponseEntity<HttpStatus> createNews(@RequestBody NewsRequestDto newsRequestDto){
        News news = convertToNews(newsRequestDto);
        newsService.save(news);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    private static News convertToNews(NewsRequestDto dto){
        News news = new News();
        news.setDate(new Date());
        news.setRubric(dto.getRubric());
        news.setTitle(dto.getTitle());
        news.setHtmlBody(dto.getHtmlBody());
        return news;
    }

}
