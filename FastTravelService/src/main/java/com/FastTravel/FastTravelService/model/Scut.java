package com.FastTravel.FastTravelService.model;


import javax.persistence.*;

@Entity
@Table(name = "scut")
public class Scut {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "latitude", nullable = false)
    private double latitude;

    @Column(name = "longitude", nullable = false)
    private double longitude;

    @Column(name = "instalationDate", nullable = true)
    private String instalationDate;

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

    public Scut(double latitude, double longitude, String instalationDate, double price1, double price2, double price3, double price4, double price5) {
    //public Scut(double latitude, double longitude, double price1, double price2, double price3, double price4, double price5) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.instalationDate = instalationDate;
        this.price1 = price1;
        this.price2 = price2;
        this.price3 = price3;
        this.price4 = price4;
        this.price5 = price5;
    }

    public String getInstalationDate() {
        return instalationDate;
    }

    public void setInstalationDate(String instalationDate) {
        this.instalationDate = instalationDate;
    }

    public long getId() {
        return id;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getPrice1() {
        return price1;
    }

    public void setPrice1(double price1) {
        this.price1 = price1;
    }

    public double getPrice2() {
        return price2;
    }

    public void setPrice2(double price2) {
        this.price2 = price2;
    }

    public double getPrice3() {
        return price3;
    }

    public void setPrice3(double price3) {
        this.price3 = price3;
    }

    public double getPrice4() {
        return price4;
    }

    public void setPrice4(double price4) {
        this.price4 = price4;
    }

    public double getPrice5() {
        return price5;
    }

    public void setPrice5(double price5) {
        this.price5 = price5;
    }

    

}