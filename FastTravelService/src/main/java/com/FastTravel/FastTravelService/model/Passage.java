package com.FastTravel.FastTravelService.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "passage")
public class Passage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "registration", nullable = false)
    private String registration;

    @Column(name = "date", nullable = false)
    private String date;

    @Column(name = "time", nullable = false)
    private String time;

    @Column(name = "deviceId", nullable = false)
    private int deviceId;

    @Column(name = "idScut", nullable = false)
    private int idScut;

    @Column(name = "paymentState", nullable = false)
    private String paymentState;

    @ManyToOne
    @JoinColumn(name = "person_passage_id")
    private PersonPassages personPassages;

    @ManyToOne
    @JoinColumn(name = "scut_id")
    private Scut scut;

    public Passage() {}

    public Passage(String registration, String date, String time, int deviceId, int idScut){
        this.registration = registration;
        this.date = date;
        this.time = time;
        this.deviceId = deviceId;
        this.idScut = idScut;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
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

    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    public int getIdScut() {
        return idScut;
    }

    public void setIdScut(int idScut) {
        this.idScut = idScut;
    }

    public String getPaymentState() {
        return paymentState;
    }

    public void setPaymentState(String paymentState) {
        this.paymentState = paymentState;
    }

    public PersonPassages getPersonPassages() {
        return personPassages;
    }

    public void setPersonPassages(PersonPassages personPassages) {
        this.personPassages = personPassages;
    }

    public Scut getScut() {
        return scut;
    }

    public void setScut(Scut scut) {
        this.scut = scut;
    }
    
}
