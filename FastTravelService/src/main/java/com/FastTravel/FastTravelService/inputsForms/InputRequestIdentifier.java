package com.FastTravel.FastTravelService.inputsForms;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class InputRequestIdentifier {
    
    @NotNull
    @Pattern(regexp="^[A-Z0-9]{2}]" + "-" + "^[A-Z0-9]{2}]" + "-" + "^[A-Z0-9]{2}]", message="Registration should use the portuguese license plate pattern; Ex: AB-12-CD")
    String registration;
    
    @NotNull
    @Min(value=1, message= "Class ranges between 1 and 5") 
    @Max(value=5, message= "Class ranges between 1 and 5")
    String vehicleClass;

    String address;
    String locality;

    @NotNull
    @Pattern(regexp="^[0-9]{4}]" + "-" + "^[0-9]{3}]", message="Zip-code should use the portuguese zip-code pattern; Ex: 1234-123")
    String zipCode;

    @NotNull
    @Size(min=9, max=9, message="The cellphone number must have 9 digits")
    @Min(value=100000000, message= "The mininimum value is 100000000") 
    @Max(value=999999999, message= "The mininimum value is 999999999")
    String contact;
    String cardName;
    String cardCountry;
    
    @NotNull
    @Size(min=8, max=10, message="The number of digits varies between 8 and 10")
    String cardNumber;

    @NotNull
    @Pattern(regexp="^[0-9]{2}]" + "/" + "^[0-9]{4}]", message="Expiration date must use the following pattern month/year; Ex: 12/2022")
    String cardExpirationDate;
    
    @NotNull
    @Size(min=3, max=3, message="CVV must have 3 digits")
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
