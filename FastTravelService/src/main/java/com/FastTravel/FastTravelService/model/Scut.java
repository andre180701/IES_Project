package com.FastTravel.FastTravelService.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Scut")
public class Scut {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "latitude", nullable = false)
    private double latitude;

    @Column(name = "longitude", nullable = false)
    private double longitude;

    @Column(name = "instalation_date", nullable = false)
    private String instalation_date;

    @Column(name = "price1", nullable = false)
    private double price1;

    @Column(name = "price2", nullable = false)
    private double price2;

    @Column(name = "price3", nullable = false)
    private double price3;

    @Column(name = "price4", nullable = false)
    private double price4;

    @Column(name = "price5", nullable = false)
    private double price5;

    public Scut() { }

    public Scut(double latitude, double longitude, String instalation_date, double price1, double price2, double price3, double price4, double price5) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.instalation_date = instalation_date;
        this.price1 = price1;
        this.price2 = price2;
        this.price3 = price3;
        this.price4 = price4;
        this.price5 = price5;
    }

}