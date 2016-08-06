package com.shitot.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;


@NamedQueries({
                  @NamedQuery(name = Symptom.ALL_SORTED, query = "select s from symptoms s order by s.name")
})
@Entity(name = "symptoms")
public class Symptom extends NamedEntity {
    public static final String ALL_SORTED = "Symptom.getAllSorted";

    public Symptom() {
    }

    public Symptom(String name) {
        super(name);
    }

    @ManyToMany(mappedBy = "symptoms",fetch = FetchType.EAGER)
    private Set<Appointment>appointments ;

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
