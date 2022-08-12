package com.kata.cinema.base.models.entitys;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "roles")
@Getter
@Setter
@NoArgsConstructor
public class Role {

    @Id
    @SequenceGenerator(name = "gen_role")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_role")
    private Long id;

    @NotNull
    @Column(unique = true)
    private String name;
}
