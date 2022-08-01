package com.kata.cinema.base.models.entitys;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@Entity(name = "users")
public class User {

    @Id
    @SequenceGenerator(name = "gen_user")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_user")
    private Long id;

    @NotNull
    private String email;

    @NotNull
    private String firstName;

    private String lastName;

    @NotNull
    private String password;

    private LocalDate birthday;

    private String avatarUrl;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles;
}
