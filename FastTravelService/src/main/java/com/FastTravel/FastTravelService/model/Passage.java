package com.FastTravel.FastTravelService.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Passage")
public class Passage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "passage_id")
    private long id;

    @ManyToOne
    @MapsId
    @JoinColumn(name = "person_passage_id")
    private PersonPassages personPassages;

    @ManyToOne
    @JoinColumn(name = "scut_id")
    private Scut scut;

    public Passage() {}

}