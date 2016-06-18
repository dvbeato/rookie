package com.example.spring.models;

import javax.persistence.Entity;

@Entity
public class Bank extends BaseModel {

    private Long number;
    private String name;

    protected Bank() {}

    public Bank(Long number, String name) {
        this.number = number;
        this.name = name;
    }

    public Long getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public void setName(String name) {
        this.name = name;
    }
}
