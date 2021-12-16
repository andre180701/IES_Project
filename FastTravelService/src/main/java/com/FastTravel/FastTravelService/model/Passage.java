package com.FastTravel.FastTravelService.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Passage")
public class Passage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @ManyToOne
    @JoinColumn(name = "person_passage_id")
    private PersonPassages personPassages;

    @ManyToOne
    @JoinColumn(name = "scut_id")
    private Scut scut;

    public Passage() {}

}