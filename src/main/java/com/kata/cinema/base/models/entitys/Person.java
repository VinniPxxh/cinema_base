package com.kata.cinema.base.models.entitys;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "Person")
@Table(name = "persons")
public class Person {

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    private int id;
    @NotNull
    private String first_name;
    private String last_name;
    private double height;
    private Date date_birth;
    private String place_of_birth;

}






