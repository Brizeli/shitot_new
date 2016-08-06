package com.shitot.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by sfh on 31-Jul-16.
 */

@NamedQueries({
        @NamedQuery(name = Patient.ALL_SORTED, query = "select d from patients d order by d.name")
})
@Entity(name = "patients")
public class Patient extends BaseEntity {
    public static final String ALL_SORTED = "Patient.getAllSorted";

    public Patient() {
    }

    @NotEmpty
    private String name;
    private int age;
    private String telNumber;


    @OneToMany (mappedBy = "patient")
    private Set<Appointment> appointments;

    public Set<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(Set<Appointment> appointments) {
        this.appointments = appointments;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
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

    public Patient(String name, int age, String telNumber) {
        this.name = name;
        this.age = age;
        this.telNumber = telNumber;
    }
}
