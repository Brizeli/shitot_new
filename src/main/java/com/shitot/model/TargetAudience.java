package com.shitot.model;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

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
}
