package com.shitot.model;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * Created by Next on 20.07.2016.
 */
@NamedQueries({@NamedQuery(name = Specialty.ALL_SORTED, query = "select s from specialties s order by s.name")})
@Entity(name = "specialties")
public class Specialty extends NamedEntity {
    public static final String ALL_SORTED = "Specialty.getAllSorted";

    public Specialty() {
    }

    public Specialty(String name) {
        super(name);
    }
    
}
