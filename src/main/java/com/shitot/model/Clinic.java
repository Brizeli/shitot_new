package com.shitot.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Set;

/**
 * Created by Next on 12.07.2016.
 */
@Entity(name = "clinics")
public class Clinic extends BaseEntity {

    private String name;
    @NotEmpty
    private String city;
    private String address;
    @OneToMany(mappedBy = "clinic", fetch = FetchType.EAGER)
    private Set<Slot> slots;

    @ManyToOne
    private Doctor doctor;

    public Clinic() {
    }

    public Clinic(Integer id, String name, String city, String address) {
        super(id);
        this.name = name;
        this.city = city;
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Set<Slot> getSlots() {
        return slots;
    }

    public void setSlots(Set<Slot> slots) {
        this.slots = slots;
    }
}
