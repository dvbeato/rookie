package org.rookie.factory.test.model;

import javax.persistence.Entity;

@Entity
public class Person extends BaseModel {

    private String name;
    private Integer age;
    private String document;

    protected Person() {}

    public Person(String name, Integer age, String document) {
        this.name = name;
        this.age = age;
        this.document = document;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getDocument() {
        return document;
    }

}
