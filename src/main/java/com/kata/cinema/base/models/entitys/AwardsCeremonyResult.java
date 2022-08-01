package com.kata.cinema.base.models.entitys;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Setter
@Getter
@NoArgsConstructor
public class AwardsCeremonyResult {
    @Id
    @SequenceGenerator(name = "gen_awards_ceremony_result")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_awards_ceremony_result")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    private Person person;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "movie_id")
//    private Movie movie;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nomination_id")
    private Nomination nomination;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "awards_ceremony_id")
    private AwardsCeremony awardsCeremony;

    private String nomination_status;
}
