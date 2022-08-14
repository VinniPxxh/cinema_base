package com.kata.cinema.base.models.dto;

import com.kata.cinema.base.models.enums.Category;
import com.kata.cinema.base.models.enums.Privacy;
import com.kata.cinema.base.models.enums.Rubric;
import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class FolderMovieDto {

    private Long id;
    private Category category;
    private Privacy privacy;
    private String name;
    private String description;
}
