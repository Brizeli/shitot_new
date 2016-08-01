package com.shitot.model;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.util.Set;

/**
 * Created by Next on 12.07.2016.
 * Slot is workingDay, you may create 7 slots for every clinic with empty set of intervals
 */
@Entity(name = "slots")
public class Slot extends BaseEntity {

    public static final Slot SUNDAY     = new Slot(DayOfWeek.SUNDAY);
    public static final Slot MONDAY     = new Slot(DayOfWeek.MONDAY);
    public static final Slot TUESDAY    = new Slot(DayOfWeek.TUESDAY);
    public static final Slot WEDNESDAY  = new Slot(DayOfWeek.WEDNESDAY);
    public static final Slot THURSDAY   = new Slot(DayOfWeek.THURSDAY);
    public static final Slot FRIDAY     = new Slot(DayOfWeek.FRIDAY);
    public static final Slot SATURDAY   = new Slot(DayOfWeek.SATURDAY);

    @Enumerated
    @Column(name = "day_of_week")
    private DayOfWeek dayOfWeek;
    @ManyToOne
    private Clinic clinic;
    @OneToMany(fetch = FetchType.EAGER)
    private Set<Interval> intervals;

    public Slot() {
    }

    public Slot(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public Slot(Integer id, DayOfWeek dayOfWeek) {
        super(id);
        this.dayOfWeek = dayOfWeek;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(DayOfWeek dayOfWeek) {
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
        return "Slot{" +
                   "dayOfWeek=" + dayOfWeek +
                   ", intervals=" + intervals +
                   '}';
    }
}
