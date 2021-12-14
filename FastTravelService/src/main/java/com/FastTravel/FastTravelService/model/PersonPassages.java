package com.FastTravel.FastTravelService.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table(name = "PersonPassages")
public class PersonPassages {   

    @Id
    @Column(name = "personPassages_id")
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "personPassages_person")
    private Person person;

    @OneToMany(mappedBy="PersonPassages")
    Set<Passage> passages;

    public PersonPassages() {}

}