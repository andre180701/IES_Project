package com.FastTravel.FastTravelService.model;

public class IdentifierByUser {
    private String registration;
    private int identifier;
    private int classT;
    private int methodPayment;
    private StateIdentifier state;


    public IdentifierByUser(String registration, int identifier, int classT, int methodPayment, StateIdentifier state) {
        this.registration = registration;
        this.identifier = identifier;
        this.classT = classT;
        this.methodPayment = methodPayment;
        this.state = state;
    }
    

    public String getRegistration() {
        return this.registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public int getIdentifier() {
        return this.identifier;
    }

    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }

    public int getClassT() {
        return this.classT;
    }

    public void setClassT(int classT) {
        this.classT = classT;
    }

    public int getMethodPayment() {
        return this.methodPayment;
    }

    public void setMethodPayment(int methodPayment) {
        this.methodPayment = methodPayment;
    }

    public StateIdentifier getState() {
        return this.state;
    }

    public void setState(StateIdentifier state) {
        this.state = state;
    }

}
