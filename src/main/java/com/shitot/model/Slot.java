package com.shitot.model;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Set;

/**
 * Created by Next on 12.07.2016.
 * Slot is workingDay, you may create 7 slots for every clinic with empty set of intervals
 */
@NamedQueries({
    @NamedQuery(name = Slot.BY_CLINIC, query =
        "select s from slots s join s.clinic c join s.intervals i where c.id=:id order by s.dayOfWeek, i.hour"),
    @NamedQuery(name = Slot.BY_DAY_CLINIC, query =
        "select s from slots s join s.clinic c join s.intervals i where c.id=:id and s.dayOfWeek=:dayOfWeek order by i.hour"),
})

@Entity(name = "slots")
@Table(uniqueConstraints=@UniqueConstraint(columnNames = {"day_of_week", "clinic_id"}))
public class Slot extends BaseEntity{

    public static final String BY_CLINIC = "Slot.getByClinic";
    public static final String BY_DAY_CLINIC = "Slot.getByDayClinic";

    @Min(0)
    @Max(6)
    private int dayOfWeek;

    @ManyToOne(fetch = FetchType.EAGER)
    private Clinic clinic;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Interval> intervals;

    public Slot() {
    }

    public Slot(int dayOfWeek, Clinic clinic, Set<Interval> intervals) {
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

    public Set<Interval> getIntervals() {
        return intervals;
    }

    public void setIntervals(Set<Interval> intervals) {
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
        String res = "Slot{" + "dayOfWeek=" + dayOfWeek + ", intervals=";
        for (Interval interval : intervals)
            res += interval.toString();
        return res + "}";
    }
}
