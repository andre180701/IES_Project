package com.FastTravel.FastTravelService.model;

import lombok.Data;
import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
@Data
@Table(name = "credit_card")
public class CreditCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "creditCardId", nullable = false)
    private long id;

    @Column(name = "number", nullable = false)
    private int number;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "expirationDate", nullable = false)
    private Date expirationDate;

    @Column(name = "pais", nullable = false)
    private String pais;

    @Column(name = "cvv", nullable = false)
    private int cvv;

    @OneToMany(mappedBy="creditCard")
    Set<Identifier> identifiers;

    public CreditCard() {
    }

    public CreditCard(int number, String name, Date expirationDate, String pais, int cvv) {
        this.number = number;
        this.name = name;
        this.expirationDate = expirationDate;
        this.pais = pais;
        this.cvv = cvv;
    }

    public long getId() {
        return id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Set<Identifier> getIdentifiers() {
        return identifiers;
    }

    public void setIdentifiers(Set<Identifier> identifiers) {
        this.identifiers = identifiers;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    @Override
    public String toString() {
        return "CreditCard [cvv=" + cvv + ", expirationDate=" + expirationDate + ", id=" + id + ", name=" + name
                + ", number=" + number + ", pais=" + pais + "]";
    }

    

}


