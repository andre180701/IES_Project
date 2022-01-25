package com.FastTravel.FastTravelService.modelMessages;

public class MsgNewPassageAdmin {
    private String method;
    private String clientEmail;
    private String registration;
    private String identifier;
    private String date;
    private String time;
    private String scutLongitude;
    private String scutLatitude;
    private String scutDescription;
    private String price;
    private String paymentState;
    
    public MsgNewPassageAdmin(String method, String clientEmail, String registration, String identifier, String date, String time,
            String scutLongitude, String scutLatitude, String scutDescription, String price, String paymentState) {
        this.method = method;
        this.clientEmail = clientEmail;
        this.registration = registration;
        this.identifier = identifier;
        this.date = date;
        this.time = time;
        this.scutLongitude = scutLongitude;
        this.scutLatitude = scutLatitude;
        this.scutDescription = scutDescription;
        this.price = price;
        this.paymentState = paymentState;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getScutLongitude() {
        return scutLongitude;
    }

    public void setScutLongitude(String scutLongitude) {
        this.scutLongitude = scutLongitude;
    }

    public String getScutLatitude() {
        return scutLatitude;
    }

    public void setScutLatitude(String scutLatitude) {
        this.scutLatitude = scutLatitude;
    }

    public String getScutDescription() {
        return scutDescription;
    }

    public void setScutDescription(String scutDescription) {
        this.scutDescription = scutDescription;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPaymentState() {
        return paymentState;
    }

    public void setPaymentState(String paymentState) {
        this.paymentState = paymentState;
    }

    @Override
    public String toString() {
        return "Message [clientEmail=" + clientEmail + ", date=" + date + ", identifier=" + identifier + ", method="
                + method + ", paymentState=" + paymentState + ", price=" + price + ", registration=" + registration
                + ", scutDescription=" + scutDescription + ", scutLatitude=" + scutLatitude + ", scutLongitude="
                + scutLongitude + ", time=" + time + "]";
    }

}
