package com.kata.cinema.base.models.entitys;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "professions")
public class Profession implements Serializable {

    @Id
    @SequenceGenerator(name = "gen_profession")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_profession")
    private Long id;

    @NotNull
    @Column(unique = true)
    private String name;

}
