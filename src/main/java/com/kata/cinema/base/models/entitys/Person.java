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

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotNull
    private String firstName;

    private String lastName;

    private Double height;

    private Date birthday;

    @Column(name = "place_birthday")
    private String placeBirthday;

}






