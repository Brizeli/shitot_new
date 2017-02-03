package com.shitot.model;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * Created by Next on 20.07.2016.
 */
@NamedQueries({@NamedQuery(name = Qualification.ALL_SORTED, query = "select e from qualifications e order by e.name")})
@Entity(name = "qualifications")
public class Qualification extends NamedEntity {
    public static final String ALL_SORTED = "Qualification.getAllSorted";
    
    public Qualification() {
    }
    
    public Qualification(String name) {
        super(name);
    }
}
