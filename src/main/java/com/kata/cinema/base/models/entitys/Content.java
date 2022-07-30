package com.kata.cinema.base.models.entitys;
/*
id - уникальный идентификатор
movie_id - идентификатор фильма
content_url - путь к контенут
type - тип, может принимать следующие значения MOVIES, SERIALS, PREVIEW, FRAME, TRAILER
 */

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
@Table(name = "content")

public class Content {

    @Id
    @Column(name = "id_content", nullable = false)
    private Long id;

    @Column(name = "movie_id_content")
    private Long movie_id;

    @Column(name = "content_url")
    private String content_url;

    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private Set<Movies> movies;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Content content = (Content) o;
        return id != null && Objects.equals(id, content.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
