package com.shitot.to;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by Igor on 10-Aug-16.
 */
public class PatientTo {

    private Integer id;

    @NotEmpty
    private String name;
    private int age;
    @NotEmpty
    private String telNumber;

    public PatientTo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isNew() {
        return id == null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }
}
