package com.FastTravel.FastTravelService.model;

import lombok.Data;

import javax.persistence.*;

import java.util.Set;

@Entity
@Data
@Table(name = "PersonPassages")
public class PersonPassages {   

    @Id
    @Column(name = "person_passage_id")
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "person_passage_id")
    private Person person_id;

    @OneToMany(mappedBy="personPassages")
    Set<Passage> passages;

    public PersonPassages() {}

}