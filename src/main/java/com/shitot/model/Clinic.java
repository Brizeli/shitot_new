package com.shitot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Next on 12.07.2016.
 */
@NamedQueries({
                  @NamedQuery(name = Clinic.ALL_CITIES_SORTED, query = "select distinct c.city as city from clinics c order by c.city"),
                  @NamedQuery(name = Clinic.GET, query = "select c from clinics c where c.id=:id and c.doctor.id=:doctorId"),
                  @NamedQuery(name = Clinic.DELETE, query = "delete from clinics c where c.id=:id and c.doctor.id=:doctorId"),
})
@Entity(name = "clinics")
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"city", "doctor_id"}))
public class Clinic extends BaseEntity {

    public static final String ALL_CITIES_SORTED = "Clinic.getAllCities";
    public static final String GET = "Clinic.get";
    public static final String DELETE = "Clinic.delete";
    private String name;
    @NotEmpty
    private String city;
    @NotEmpty
    private String address;
    @OneToMany(mappedBy = "clinic", fetch = FetchType.EAGER)
    @OrderBy("dayOfWeek")
    private Set<Slot> slots;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Doctor doctor;

    public Clinic() {
    }

    public Clinic(String name, String city, String address) {
        this.name = name;
        this.city = city;
        this.address = address;
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
}
