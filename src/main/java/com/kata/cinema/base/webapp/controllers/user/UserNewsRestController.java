package com.kata.cinema.base.webapp.controllers.user;


import com.kata.cinema.base.models.dto.request.CommentsRequestDto;
import com.kata.cinema.base.models.entitys.Comments;
import com.kata.cinema.base.models.entitys.News;
import com.kata.cinema.base.models.entitys.User;
import com.kata.cinema.base.service.abstracts.model.CommentsService;
import com.kata.cinema.base.service.abstracts.model.NewsService;
import com.kata.cinema.base.service.abstracts.model.UserService;
import org.mapstruct.control.MappingControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/user/news")
public class UserNewsRestController {
    private final NewsService newsService;
    private final UserService userService;
    private final CommentsService commentsService;
    private final ConversionService conversionService;

    @Autowired
    public UserNewsRestController(NewsService newsService, UserService userService, CommentsService commentsService, ConversionService conversionService) {
        this.newsService = newsService;
        this.userService = userService;
        this.commentsService = commentsService;
        this.conversionService = conversionService;
    }

    @PostMapping("/{id}/comments")
    public ResponseEntity<CommentsRequestDto> addComments(@PathVariable Long id, @RequestParam Long userId,
                                                          @RequestBody CommentsRequestDto commentsRequestDto) {

        newsService.getById(id);
        userService.getById(userId);
        Comments comments = convertToComments(commentsRequestDto);
        comments.setDate(LocalDateTime.now());
        comments.setNews(newsService.getById(id).orElseThrow());
        comments.setUser(userService.getById(userId).orElseThrow());
        commentsService.create(comments);
        return new ResponseEntity<>(commentsRequestDto, HttpStatus.OK);
    }

    private Comments convertToComments(CommentsRequestDto commentsRequestDto) {
        return conversionService.convert(commentsRequestDto, Comments.class);
    }

}
