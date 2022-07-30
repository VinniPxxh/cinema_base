package com.kata.cinema.base.models.entitys;

import com.kata.cinema.base.models.enums.Privacy;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "folders_persons")
public class FolderPerson {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private Boolean favourites;

    private int user_id;

    @Enumerated(EnumType.STRING)
    private Privacy privacy;

    private String name;

    private String description;

}
