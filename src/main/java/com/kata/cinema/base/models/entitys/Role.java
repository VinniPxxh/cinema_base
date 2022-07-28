package com.kata.cinema.base.models.entitys;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity(name = "roles")
@Getter
@Setter
@NoArgsConstructor
public class Role {
    @Id
    private int id;
    @NotNull
    @Column(unique = true)
    private String name;
}
