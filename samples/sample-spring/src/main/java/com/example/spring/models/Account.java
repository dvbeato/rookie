package com.example.spring.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Account extends BaseModel {

    private String number;
    private String digit;
    @ManyToOne
    private Person owner;
    @ManyToOne
    private Agency agency;

    protected Account(){}

    public Account(String number, String digit, Person owner, Agency agency) {
        this.number = number;
        this.digit = digit;
        this.owner = owner;
        this.agency = agency;
    }

    public String getNumber() {
        return number;
    }

    public String getDigit() {
        return digit;
    }

    public Person getOwner() {
        return owner;
    }

    public Agency getAgency() {
        return agency;
    }
}
