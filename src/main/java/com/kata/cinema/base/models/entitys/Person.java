package com.kata.cinema.base.models.entitys;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "persons")
public class Person {

    @Id
    @SequenceGenerator(name = "gen_person")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person")
    private Long id;

    @NotNull
    private String firstName;

    private String lastName;

    private Double height;

    private Date birthday;

    @Column(name = "place_birthday")
    private String placeBirthday;

}






