package com.kata.cinema.base.models.entitys;


import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "genres")
public class Genres {

    @Id
    @SequenceGenerator(name = "gen_genres")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_genres")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "movie_genre",
            joinColumns = @JoinColumn(name = "genre_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id")
    )
    @ToString.Exclude
    private Set<Movies> movies;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Genres genres = (Genres) o;
        return id != null && Objects.equals(id, genres.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
