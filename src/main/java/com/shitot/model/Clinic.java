package com.shitot.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Next on 12.07.2016.
 */
@NamedQueries({
        @NamedQuery(name = Clinic.ALL_CITIES, query =
                "select distinct c.city as city from clinics c order by c.city"),
        @NamedQuery(name = Clinic.BY_DOCTOR, query = "select c from clinics c join c.doctor d where d.id=:id order by c.city, c.address"),
        @NamedQuery(name = Clinic.DOCTOR_BY_CITY, query =
                "select distinct d from doctors d join d.clinics c where c.city=:city order by d.fullName"),
        @NamedQuery(name = Clinic.DOCTOR_BY_CITY_SPECIALTY, query =
                "select distinct d from clinics c join c.doctor d join d.specialties sp where sp.name=:specialty and c.city=:city order by d.fullName")
})
@Entity(name = "clinics")
public class Clinic extends BaseEntity {

    public static final String ALL_CITIES = "City.getAll";
    public static final String BY_DOCTOR = "Clinic.getByDoctor";
    public static final String DOCTOR_BY_CITY = "Doctor.getByCity";
    public static final String DOCTOR_BY_CITY_SPECIALTY = "Doctor.getByCitySpecialty";

    private String name;
    @NotEmpty
    private String city;
    @NotEmpty
    private String address;
    @OneToMany(orphanRemoval = true, mappedBy = "clinic", fetch = FetchType.EAGER)
    @OrderBy(value = "dayOfWeek")
    private Set<Slot> slots;

    @ManyToOne
    @JsonBackReference
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

    @Override
    public String toString() {
        return "Clinic{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
