package com.FastTravel.FastTravelService.model;

public enum PaymentState {
    UNPAID, PAID, PAYMENT_FAILED;

    public static PaymentState getEnum(String num) {
        switch (num) {
            case "0":
                return PaymentState.UNPAID;             
            case "1":
                return PaymentState.PAID; 
            default:
                return PaymentState.PAYMENT_FAILED; 
        }
    }
}
