package com.FastTravel.FastTravelService.model;

public enum StateIdentifier {
    UNPAID, PAID, PAYMENT_FAILED, SENDING, RECEIVED, DESACTIVATE, ACTIVATE;

    public static StateIdentifier getEnum(String num) {
        switch (num) {
            case "0":
                return StateIdentifier.UNPAID;             
            case "1":
                return StateIdentifier.PAID; 
            case "2":
                return StateIdentifier.PAYMENT_FAILED; 
            case "3":
                return StateIdentifier.SENDING; 
            case "4":
                return StateIdentifier.RECEIVED; 
            case "5":
                return StateIdentifier.DESACTIVATE; 
            default:
                return StateIdentifier.ACTIVATE;             
        }
    }
}
