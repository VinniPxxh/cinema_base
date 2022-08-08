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
@Table(name = "content")
public class Content {

    @Id
    @SequenceGenerator(name = "gen_content")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_content")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "movieId")
    private Long movieId;

    @Column(name = "contentUrl")
    private String contentUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private Movies movies;

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
