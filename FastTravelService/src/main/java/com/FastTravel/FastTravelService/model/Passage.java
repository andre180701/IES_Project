package com.FastTravel.FastTravelService.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Passage")
public class Passage {

    @EmbeddedId
    private PassageKey id;

    @ManyToOne
    @MapsId("person_passage_id")
    @JoinColumn(name = "person_passage_id", referencedColumnName = "long")
    private PersonPassages personPassages;

    @ManyToOne
    @MapsId("scutId")
    @JoinColumn(name = "scut_id", referencedColumnName = "long")
    private Scut scut;

    public Passage() {}

}