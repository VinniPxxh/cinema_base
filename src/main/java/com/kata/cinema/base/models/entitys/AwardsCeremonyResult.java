package com.kata.cinema.base.models.entitys;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table
@Data
@NoArgsConstructor
public class AwardsCeremonyResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id", nullable = false)
    private int person_id;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id", nullable = false)
    private int movie_id;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nomination_id", nullable = false)
    private int nomination_id;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "awards_ceremony_id", nullable = false)
    private int awards_ceremony_id;
    @Column
    private String nomination_status;

    @ManyToOne
    @JoinColumn(name = "nomination_id")
    private Nomination nomination;

    @ManyToOne
    @JoinColumn(name = "awards_ceremony_id")
    private AwardsCeremony awardsCeremony;
}
