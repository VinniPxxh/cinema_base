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
@Table(name = "score")
public class Score {
    @Id
    @SequenceGenerator(name = "gen_score")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "score")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name="movieId")
    private Long movieId;

    @Column(name = "userId")
    private Long userId;

    @Column(name = "score")
    private Long score;

    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private Movies movie;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Score score = (Score) o;
        return id != null && Objects.equals(id, score.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
