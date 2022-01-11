package com.FastTravel.FastTravelService.inputsForms;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class InputRequestIdentifier {
    String registration;
    
    @NotNull
    @Min(value=1, message= "Class ranges between 1 and 5.") 
    @Max(value=5, message= "Class ranges between 1 and 5.")
    String vehicleClass;

    String address;
    String locality;
    String zipCode;
    String contact;
    String cardName;
    String cardCountry;
    String cardNumber;
    String cardExpirationDate;
    String cardCvv;
    public String getRegistration() {
        return registration;
    }
    public void setRegistration(String registration) {
        this.registration = registration;
    }
    public String getVehicleClass() {
        return vehicleClass;
    }
    public void setVehicleClass(String vehicleClass) {
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
    public String getContact() {
        return contact;
    }
    public void setContact(String contact) {
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
    public String getCardNumber() {
        return cardNumber;
    }
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
    public String getCardExpirationDate() {
        return cardExpirationDate;
    }
    public void setCardExpirationDate(String cardExpirationDate) {
        this.cardExpirationDate = cardExpirationDate;
    }
    public String getCardCvv() {
        return cardCvv;
    }
    public void setCardCvv(String cardCvv) {
        this.cardCvv = cardCvv;
    }

}
