package com.kata.cinema.base.models.entitys;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;


@Entity(name = "users")
@Getter @Setter @NoArgsConstructor
public class User {

    @Id
    private int id;
    @NotNull private String email;
    @NotNull private String firstName;
    private String lastName;
    @NotNull private String password;
    private LocalDate birthday;
    @NotNull private int roleId;
}
