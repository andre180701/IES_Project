package com.FastTravel.FastTravelService.model;

import lombok.Data;
import java.sql.Date;
import javax.persistence.*;
import java.sql.Time;

@Entity
@Data
@Table(name = "passage")
public class Passage implements Comparable<Passage>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "passageId", nullable = false)
    private long id;

    @Column(name = "date", nullable = false)
    private Date date;

    @Column(name = "time", nullable = false)
    private Time time;

    @Column(name = "paymentState", nullable = false)
    private PaymentState paymentState;

    @ManyToOne
    @JoinColumn(name = "identifierId", nullable = false)
    private Identifier identifier;

    @ManyToOne
    @JoinColumn(name = "scutId", nullable = false)
    private Scut scut;

    
    public Passage() {}

    public Passage(Date date, Time time, Identifier identifier, Scut scut) {
        this.date = date;
        this.time = time;
        this.identifier = identifier;
        this.scut = scut;
        this.paymentState = PaymentState.UNPAID;
    }

    public int compareTo(Passage passage) {
        if ( date.compareTo(passage.getDate()) < 0){
            return 1;
        }
        else if ( date.compareTo(passage.getDate()) > 0){
            return -1;
        }
        else if ( time.compareTo(passage.getTime()) < 0){
            return 1;
        }
        else if ( time.compareTo(passage.getTime()) > 0){
            return -1;
        }else{
            return 0;
        }
    }

    public double getPrice(){
        switch (this.identifier.getClasse()) {
            case 1:
                return this.scut.getPrice1();
            case 2:
                return this.scut.getPrice2();
            case 3:
                return this.scut.getPrice3();
            case 4:
                return this.scut.getPrice4();
            default:
                return this.scut.getPrice5();
        }
    }

    public long getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public PaymentState getPaymentState() {
        return paymentState;
    }

    public void setPaymentState(PaymentState paymentState) {
        this.paymentState = paymentState;
    }

    public Identifier getIdentifier() {
        return identifier;
    }

    public void setIdentifier(Identifier identifier) {
        this.identifier = identifier;
    }

    public Scut getScut() {
        return scut;
    }

    public void setScut(Scut scut) {
        this.scut = scut;
    }

    @Override
    public String toString() {
        return "Passage [date=" + date + ", id=" + id + ", identifier=" + identifier + ", paymentState=" + paymentState
                + ", scut=" + scut + ", time=" + time + "]";
    }
}
