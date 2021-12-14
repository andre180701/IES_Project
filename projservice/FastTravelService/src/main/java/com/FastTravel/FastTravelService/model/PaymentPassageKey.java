package com.FastTravel.FastTravelService.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Data
class PaymentPassageKey implements Serializable {

    @Column(name = "transaction_id")
    private long transactionId;

    @Column(name = "passage_id")
    private long passageId;

    public PaymentPassageKey() {}

}