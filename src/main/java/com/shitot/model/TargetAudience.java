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
                  @NamedQuery(name = TargetAudience.ALL_SORTED, query = "select t from audiences t order by t.name")
})
@Entity(name = "audiences")
public class TargetAudience extends NamedEntity {

    public static final String ALL_SORTED = "TargetAudience.getAllSorted";
    public static final TargetAudience CHILDREN = new TargetAudience("Children");
    public static final TargetAudience TEENS = new TargetAudience("Teens");
    public static final TargetAudience ADULTS = new TargetAudience("Adults");
    public static final TargetAudience ELDERY = new TargetAudience("Eldery");

    public TargetAudience() {
    }

    public TargetAudience(String name) {
        super(name);
    }

    @ManyToMany(mappedBy = "targetAudiences")
    @JsonIgnore
    private Set<Doctor> doctors;

    public Set<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(Set<Doctor> doctors) {
        this.doctors = doctors;
    }
}
