package com.kata.cinema.base.models.entitys;

import com.kata.cinema.base.models.enums.TypeCharacter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "movie_person")
public class MoviePerson implements Serializable{

    @Id
    private int movie_id;


    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profession_id", referencedColumnName = "id")
    private Profession profession_id;


    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person person_id;

    @Enumerated(EnumType.STRING)
    private TypeCharacter type_character;

    private String nameRole; // нестыковки названия name_role?(выбрал с диаграммы)

}
