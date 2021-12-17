package com.FastTravel.FastTravelService.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Passage")
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
}
