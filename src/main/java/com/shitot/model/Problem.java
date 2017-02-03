package com.shitot.model;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedQueries({@NamedQuery(name = Problem.ALL_SORTED, query = "select s from problems s order by s.name")})
@Entity(name = "problems")
public class Problem extends NamedEntity {
    public static final String ALL_SORTED = "Problems.getAllSorted";
    
    public Problem() {
    }
    
    public Problem(String name) {
        super(name);
    }
    
    @Override
    public String toString() {
        return super.toString();
    }
}
