package com.FastTravel.FastTravelService.inputsForms;

import java.sql.Date;

public class InputRequestIdentifier {
    String registration;
    int vehicleClass;
    String address;
    String locality;
    String zipCode;
    int contact;
    String cardName;
    String cardCountry;
    int cardNumber;
    Date cardExpirationDate;
    int cardCvv;
    
    public String getRegistration() {
        return registration;
    }
    public void setRegistration(String registration) {
        this.registration = registration;
    }
    public int getVehicleClass() {
        return vehicleClass;
    }
    public void setVehicleClass(int vehicleClass) {
        this.vehicleClass = vehicleClass;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getLocality() {
        return locality;
    }
    public void setLocality(String locality) {
        this.locality = locality;
    }
    public String getZipCode() {
        return zipCode;
    }
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
    public int getContact() {
        return contact;
    }
    public void setContact(int contact) {
        this.contact = contact;
    }
    public String getCardName() {
        return cardName;
    }
    public void setCardName(String cardName) {
        this.cardName = cardName;
    }
    public String getCardCountry() {
        return cardCountry;
    }
    public void setCardCountry(String cardCountry) {
        this.cardCountry = cardCountry;
    }
    public int getCardNumber() {
        return cardNumber;
    }
    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }
    public Date getCardExpirationDate() {
        return cardExpirationDate;
    }
    public void setCardExpirationDate(Date cardExpirationDate) {
        this.cardExpirationDate = cardExpirationDate;
    }
    public int getCardCvv() {
        return cardCvv;
    }
    public void setCardCvv(int cardCvv) {
        this.cardCvv = cardCvv;
    }
    


}
