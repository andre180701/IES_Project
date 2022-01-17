package com.FastTravel.FastTravelService.inputsForms;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class InputRequestIdentifier {
    
    @NotNull
    @Pattern(regexp="[A-Z0-9]{2}" + "-" + "[A-Z0-9]{2}" + "-" + "[A-Z0-9]{2}", message="Registration should use the portuguese license plate pattern; Ex: AB-12-CD")
    String registration;
    
    @NotNull
    @Min(value=1, message= "Class must be greater than or equal to 1") 
    @Max(value=5, message= "Class must be less than or equal to 5")
    String vehicleClass;

    @NotNull
    @Size(min=1, max=50, message="Address must not be empty and has a limit of 50 characters")
    String address;

    @NotNull
    @Size(min=1, max=50, message="Locality must not be empty and has a limit of 50 characters")
    String locality;

    @NotNull
    @Pattern(regexp="[0-9]{4}" + "-" + "[0-9]{3}", message="Zip-code should use the portuguese zip-code pattern; Ex: 1234-123")
    String zipCode;

    @NotNull
    @Size(min=9, max=9, message="The cellphone number must have 9 digits")
    @Min(value=100000000, message= "The mininimum value is 100000000") 
    @Max(value=999999999, message= "The maximium value is 999999999")
    String contact;

    @NotNull
    @Size(min=1, max=50, message="CardName must not be empty and has a limit of 50 characters")
    String cardName;

    @NotNull
    @Size(min=1, max=50, message="CardCountry must not be empty and has a limit of 50 characters")
    String cardCountry;
    
    @NotNull
    @Size(min=8, max=10, message="The number of digits varies between 8 and 10")
    String cardNumber;

    @NotNull
    @Pattern(regexp="[0-9]{4}" + "-" + "[0-9]{1,2}"+ "-" + "[0-9]{1,2}", message="Expiration date must use the following pattern year-month-day; Ex: 2022-12-12")
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
    @Override
    public String toString() {
        return "InputRequestIdentifier [address=" + address + ", cardCountry=" + cardCountry + ", cardCvv=" + cardCvv
                + ", cardExpirationDate=" + cardExpirationDate + ", cardName=" + cardName + ", cardNumber=" + cardNumber
                + ", contact=" + contact + ", locality=" + locality + ", registration=" + registration
                + ", vehicleClass=" + vehicleClass + ", zipCode=" + zipCode + "]";
    }

}
