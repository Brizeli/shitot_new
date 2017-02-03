package com.shitot.model;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


@NamedQueries({@NamedQuery(name = Symptom.ALL_SORTED, query = "select s from symptoms s order by s.name")})
@Entity(name = "symptoms")
public class Symptom extends NamedEntity {
    public static final String ALL_SORTED = "Symptom.getAllSorted";
    
    public Symptom() {
    }
    
    public Symptom(String name) {
        super(name);
    }
    
    @Override
    public String toString() {
        return super.toString();
    }
}
