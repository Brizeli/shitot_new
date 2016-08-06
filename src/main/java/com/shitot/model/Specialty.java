package com.shitot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import java.util.Collection;
import java.util.Set;

/**
 * Created by Next on 20.07.2016.
 */
@NamedQueries({
                  @NamedQuery(name = Specialty.ALL_SORTED, query = "select s from specialties s order by s.name")
})
@Entity(name = "specialties")
public class Specialty extends NamedEntity {
    public static final String ALL_SORTED = "Specialty.getAllSorted";

    public Specialty() {
    }

    public Specialty(String name) {
        super(name);
    }

    @ManyToMany(mappedBy = "specialties")
    @JsonIgnore
    private Set<Doctor> doctors;

    public Set<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(Set<Doctor> doctors) {
        this.doctors = doctors;
    }
}
