package com.kata.cinema.base.models.entitys;

import com.kata.cinema.base.models.enums.TypeCharacter;
import lombok.EqualsAndHashCode;
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
public class MoviePerson{

    @EmbeddedId
    private MoviePersonId moviePersonId;

    @Enumerated(EnumType.STRING)
    private TypeCharacter typeCharacter;

    private String nameRole;

}

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Embeddable
class MoviePersonId implements Serializable{

    //TODO расскоментировать после добавления сущности Movie
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "movie_id")
//    private MoviePersonId movie;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profession_id")
    private Profession profession;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    private Person person;

}
