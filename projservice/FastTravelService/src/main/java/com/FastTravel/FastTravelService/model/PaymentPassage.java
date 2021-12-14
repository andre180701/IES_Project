package com.FastTravel.FastTravelService.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "transaction_has_product")
public class PaymentPassage {

    @EmbeddedId
    private PaymentPassageKey id;

    @OneToOne
    @MapsId("transactionId")
    @JoinColumn(name = "transaction_id")
    private Transaction transaction;

    @OneToOne
    @MapsId("passageId")
    @JoinColumn(name = "passage_id")
    private Passage passage;



    public PaymentPassage() {}

}