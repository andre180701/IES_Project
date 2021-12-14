package com.FastTravel.FastTravelService.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
@Data
class PaymentPassageKey implements Serializable {

    @Column(name = "payment_id")
    private long paymentId;

    @Column(name = "passage_id")
    private long passageId;

    public PaymentPassageKey() {}

}