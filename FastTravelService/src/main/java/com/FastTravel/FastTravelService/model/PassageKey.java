package com.FastTravel.FastTravelService.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
@Data
class PassageKey implements Serializable {

    @Column(name = "personPassage_id")
    private int personPassageId;

    @Column(name = "scut_id")
    private long scutId;

    public PassageKey() {}

}