package com.shitot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Next on 12.07.2016.
 */
@NamedQueries({
                  @NamedQuery(name = Clinic.ALL_CITIES_SORTED,query = "select c.city from clinics c")
})
@Entity(name = "clinics")
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"city","doctor_id"}))
public class Clinic extends BaseEntity {

    public static final String ALL_CITIES_SORTED = "Clinic.getAllCities";
    private String name;
    @NotEmpty
    private String city;
    private String address;
    @OneToMany(mappedBy = "clinic", fetch = FetchType.EAGER)
    private Set<Slot> slots;

    @ManyToOne
    @JsonIgnore
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
