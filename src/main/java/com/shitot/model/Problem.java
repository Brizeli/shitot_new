package com.shitot.model;

/**
 * Created by sfh on 31-Jul-16.
 */
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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

    @ManyToMany(mappedBy = "problems")
    private Set<Appointment>appointments;

    public Set<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(Set<Appointment> appointments) {
        this.appointments = appointments;
    }
}
