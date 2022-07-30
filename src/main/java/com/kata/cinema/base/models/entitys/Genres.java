package com.kata.cinema.base.models.entitys;


import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "genres")
public class Genres {

    @Id
    @Column(name = "id_genres", nullable = false)
    private Long id;

    @Column(name = "genres_name")
    private String name;

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
