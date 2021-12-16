package com.FastTravel.FastTravelService.model;

import lombok.Data;


import javax.persistence.*;

@Entity
@Data
@Table(name = "Person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "type", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private PersonType type;

    @OneToOne(mappedBy = "person_id")
    @PrimaryKeyJoinColumn
    private PersonPassages personPassages;

    public Person() {
    }

    public Person(String name, String email, String password, PersonType type) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.type = type;
    }

}
