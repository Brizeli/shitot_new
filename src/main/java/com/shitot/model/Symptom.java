package com.shitot.model;

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

    @ManyToMany(mappedBy = "symptoms")
    private Set<Appointment>appointments ;

    public Set<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(Set<Appointment> appointments) {
        this.appointments = appointments;
    }
}
