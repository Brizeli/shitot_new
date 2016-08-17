package com.shitot.to;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by Igor on 10-Aug-16.
 */
public class  PatientTo {
    private Integer id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public boolean isNew() {
        return id == null;
    }
    @NotEmpty
    private String name;
    private int age;
    private String telNumber;

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
