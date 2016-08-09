package com.shitot.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Next on 12.07.2016.
 * Slot is workingDay, you may create 7 slots for every clinic with empty set of intervals
 */
@NamedQueries({
        @NamedQuery(name = Slot.BY_CLINIC, query =
                "select distinct s from slots s where s.id in (select s1.id from slots s1 join s1.clinic c where c.id=:id) order by s.dayOfWeek"),
        @NamedQuery(name = Slot.BY_DAY_CLINIC, query =
                "select distinct s from slots s join s.clinic c where c.id=:id and s.dayOfWeek=:dayOfWeek"),
})

@Entity(name = "slots")
@Table(uniqueConstraints=@UniqueConstraint(columnNames = {"clinic_id", "day_of_week"}))
public class Slot extends BaseEntity{

    public static final String BY_CLINIC = "Slot.getByClinic";
    public static final String BY_DAY_CLINIC = "Slot.getByDayClinic";
    @Range(min = 0, max = 6)
    @Column(name = "day_of_week", nullable = false)
    private int dayOfWeek;

    @ManyToOne
    @JsonBackReference
    private Clinic clinic;

    @ElementCollection(fetch = FetchType.EAGER)
    @OrderBy("intervals")
    private Set<Integer> intervals = new HashSet<>();

    public Slot() {
    }

    public Slot(Integer id, int dayOfWeek, Clinic clinic, Set<Integer> intervals) {
        super(id);
        this.dayOfWeek = dayOfWeek;
        this.clinic = clinic;
        this.intervals = intervals;
    }

    public int getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(int dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public Set<Integer> getIntervals() {
        return intervals;
    }

    public void setIntervals(Set<Integer> intervals) {
        this.intervals = intervals;
    }

    public Clinic getClinic() {
        return clinic;
    }

    public void setClinic(Clinic clinic) {
        this.clinic = clinic;
    }

    @Override
    public String toString() {
        return "Slot{" +
                "dayOfWeek=" + dayOfWeek + '}';
    }
}
