package com.FastTravel.FastTravelService.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "payment_has_passage")
public class PaymentPassage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @OneToOne
    @MapsId("paymentId")    
    @JoinColumn(name = "payment_id")
    private Payment payment;

    @OneToOne
    @MapsId("passageId")
    @JoinColumn(name = "passage_id")
    private Passage passage;

    public PaymentPassage() {}

}