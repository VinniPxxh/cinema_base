package com.kata.cinema.base.models.entitys;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity(name = "roles")
@Getter
@Setter
@NoArgsConstructor
public class Role implements GrantedAuthority {

    @Id
    @SequenceGenerator(name = "gen_role")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_role")
    private Long id;

    @NotNull
    @Column(unique = true)
    private String name;

    @Override
    public String getAuthority() {
        return null;
    }
}
