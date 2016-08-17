package com.shitot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@NamedQueries({
        @NamedQuery(name = Problem.ALL_SORTED, query = "select s from problems s order by s.name")

})
@Entity(name="problems")
public class Problem extends NamedEntity{
    public static final String ALL_SORTED = "Problems.getAllSorted";

    public Problem() {
    }

    public Problem(String name) {
        super(name);
    }

    @ManyToMany(mappedBy = "problems", fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<Appointment>appointments;

    public Set<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(Set<Appointment> appointments) {
        this.appointments = appointments;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
