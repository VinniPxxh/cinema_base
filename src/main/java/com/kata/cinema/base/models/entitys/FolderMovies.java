package com.kata.cinema.base.models.entitys;

import com.kata.cinema.base.models.enums.Category;
import com.kata.cinema.base.models.enums.Privacy;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name = "folders_movies")
@Getter @Setter @NoArgsConstructor
public class FolderMovies {
    @Id
    private int id;
    private Category category;
    @ManyToOne
    private User user;
    private Privacy privacy;
    private String name;
    private String description;
}
