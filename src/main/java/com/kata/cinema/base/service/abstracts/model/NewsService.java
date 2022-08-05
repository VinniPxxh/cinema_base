package com.kata.cinema.base.service.abstracts.model;

import com.kata.cinema.base.models.dto.NewsResponseDto;
import com.kata.cinema.base.models.entitys.News;
import com.kata.cinema.base.models.enums.Rubric;

import java.time.LocalDate;
import java.util.List;

public interface NewsService {

    void save(News news);

    public List<NewsResponseDto> findByDateBetweenAndRubric(LocalDate dateStart, LocalDate dateEnd, Rubric rubric);

}
