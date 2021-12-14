package com.FastTravel.FastTravelService.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table(name = "personpassages")
public class PersonPassages {

    @Id
    @Column(name = "person_id")
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "person_id")
    private Person person;

    @OneToMany(mappedBy="personpassages")
    Set<Passages> passages;

    public personpassages() {}

}