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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person persons;

    @ManyToOne
    @JoinColumn(name = "movies_id")
    private Movies movies;

    @ManyToOne
    @JoinColumn(name = "nomination_id")
    private Nomination nomination;

    @ManyToOne
    @JoinColumn(name = "awards_ceremony_id")
    private AwardsCeremony awardsCeremony;

    @Column
    private String nominationStatus;
}
