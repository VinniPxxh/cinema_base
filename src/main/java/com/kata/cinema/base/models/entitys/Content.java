package com.kata.cinema.base.models.entitys;

import com.kata.cinema.base.models.enums.Type;
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

    @Column(name = "content_url")
    private String contentUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    @JoinColumn(name = "movie_id")
    private Movies movies;

    @Enumerated(EnumType.STRING)
    private Type type;

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
