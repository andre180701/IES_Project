package com.FastTravel.FastTravelService.model;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Data
@Table(name = "identifier")
public class Identifier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "identifierId", nullable = false)
    private long id;

    @Column(name = "registration", unique = true, nullable = false)
    private String registration;

    @Column(name = "classe", nullable = false)
    @NotNull
    @Min(value=1, message= "Class ranges between 1 and 5.") 
    @Max(value=5, message= "Class ranges between 1 and 5.")
    private int classe;

    @Column(name = "state", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private StateIdentifier state;

    @ManyToOne
    @JoinColumn(name = "clientId", nullable = false)
    private Client client;

    @ManyToOne
    @JoinColumn(name = "creditCardID", nullable = false)
    //@Size(min=8, max=10, message="The number of digits varies between 8 and 10")
    private CreditCard creditCard;

    @OneToMany(mappedBy="identifier")
    Set<Passage> passages;

    public Identifier() {
    }

    public Identifier(String registration, int classe, Client client, CreditCard creditCard) {
        this.registration = registration;
        this.classe = classe;
        this.client = client;
        this.creditCard = creditCard;
        this.state = StateIdentifier.UNPAID;
    }

    public long getId() {
        return id;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public int getClasse() {
        return classe;
    }

    public void setClasse(int classe) {
        this.classe = classe;
    }

    public StateIdentifier getState() {
        return state;
    }

    public void setState(StateIdentifier state) {
        this.state = state;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public Set<Passage> getPassages() {
        return passages;
    }

    public void setPassages(Set<Passage> passages) {
        this.passages = passages;
    }

    @Override
    public String toString() {
        return "Identifier [classe=" + classe + ", client=" + client + ", creditCard=" + creditCard + ", id=" + id
                + ", registration=" + registration + ", state=" + state + "]";
    }

}