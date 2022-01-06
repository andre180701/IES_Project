package com.FastTravel.FastTravelService.model;

import lombok.Data;
import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "clientId", nullable = false)
    private long id;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "nif", unique = true, nullable = false)
    private int nif;

    @Column(name = "firstName", nullable = false)
    private String first_name;

    @Column(name = "lastName", nullable = false)
    private String last_name;

    @OneToMany(mappedBy="client")
    Set<Identifier> identifiers;

    public Client() {
    }

    public Client(String email, String password, int nif, String first_name, String last_name) {
        this.email = email;
        this.password = password;
        this.nif = nif;
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public long getId() {
        return id;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getNif() {
        return nif;
    }

    public void setNif(int nif) {
        this.nif = nif;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Set<Identifier> getIdentifiers() {
        return identifiers;
    }

    public void setIdentifiers(Set<Identifier> identifiers) {
        this.identifiers = identifiers;
    }

    
}


