package com.shitot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.Set;

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
    @NotEmpty
    private String telNumber;

    @JsonIgnore
    @OneToMany (mappedBy = "patient",cascade = CascadeType.REMOVE)
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

    @Override
    public String toString() {
        return "Patient{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", tel='" + telNumber + '\'' +
                "} " + super.toString();
    }
}
