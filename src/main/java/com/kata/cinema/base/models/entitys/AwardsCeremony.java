package com.kata.cinema.base.models.entitys;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table
@Data
@NoArgsConstructor
public class AwardsCeremony {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column
    private String date_event;

    @Column
    private String place_event;

    @Column
    private int award_id;


    @ManyToOne
    @JoinColumn(name = "awards_id")
    private Awards awards;

}
