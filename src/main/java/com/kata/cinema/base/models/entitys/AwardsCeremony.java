package com.kata.cinema.base.models.entitys;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Setter
@Getter
@NoArgsConstructor
public class AwardsCeremony {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false)
    private Long id;

    @Column
    private String dateEvent;

    @Column
    private String placeEvent;

    @ManyToOne(fetch = FetchType.LAZY)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @JoinColumn(name = "awards_id")
    private Awards awards;

}
