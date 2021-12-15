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
    @JoinColumn(name = "personPassages_person")
    private Person person;

    @OneToMany(mappedBy="personPassages")
    //@OneToMany(mappedBy="PersonPassages", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    Set<Passage> passages;

    public PersonPassages() {}

}