package com.FastTravel.FastTravelService.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Payment_has_passage")
public class PaymentPassage {

    @EmbeddedId
    private PaymentPassageKey id;

    @OneToOne
    @MapsId("paymentId")    
    @JoinColumn(name = "payment_id", referencedColumnName="long")
    private Payment payment;

    @OneToOne
    @MapsId("passageId")
    @JoinColumn(name = "passage_id", referencedColumnName= "PassageKey")
    private Passage passage;

    public PaymentPassage() {}

}