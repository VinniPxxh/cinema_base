package com.kata.cinema.base.service.abstracts.dto;

import com.kata.cinema.base.models.enums.Category;
import com.kata.cinema.base.models.enums.Privacy;

public class FolderMovieResponsDto {
    Long id;
    Category category;
    Privacy privacy;
    String name;
    String description;

}
