package com.FastTravel.FastTravelService.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "passage")
public class Passage {

    @EmbeddedId
    private PassageKey id;

    @ManyToOne
    @MapsId("passageId")
    @JoinColumn(name = "passage_id")
    private PersonPassages personpassages;

    @ManyToOne
    @MapsId("scutId")
    @JoinColumn(name = "scut_id")
    private Scut scut;

    public Passage() {}

}