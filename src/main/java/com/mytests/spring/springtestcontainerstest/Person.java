package com.mytests.spring.springtestcontainerstest;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "persons")
public class Person {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String surname;
    private String gender;

    public Person(String name, String surname, String gender) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
    }

    public Person() {
    }


}
