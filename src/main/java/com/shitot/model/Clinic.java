package com.shitot.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Next on 12.07.2016.
 */
@NamedQueries({
        @NamedQuery(name = Clinic.BY_CITY_SPECIALTY, query =
            "select c from clinics c join c.doctor d join d.specialties sp where sp.name=:specialty and c.city=:city order by c.address"),
        @NamedQuery(name = Clinic.BY_DOCTOR, query = "select c from clinics c join c.doctor d where d.id=:id order by c.city, c.address")
})
@Entity(name = "clinics")
public class Clinic extends BaseEntity {

    public static final String BY_CITY_SPECIALTY = "Clinic.getByCitySpecialty";
    public static final String BY_DOCTOR = "Clinic.getByDoctor";

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

    public Clinic(Integer id, String name, String city, String address, Doctor doctor) {
        super(id);
        this.name = name;
        this.city = city;
        this.address = address;
        this.doctor = doctor;
    }

    public Clinic(String name, String city, String address, Doctor doctor) {
        this(null, name, city, address, doctor);
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
