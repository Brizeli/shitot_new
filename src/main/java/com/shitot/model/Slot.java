package com.shitot.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;

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

    @Column(nullable = false)
    @NotEmpty
    private String intervals = " ";

    public Slot() {
    }

    public Slot(Integer id, int dayOfWeek, Clinic clinic, String intervals) {
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

    public String getIntervals() {
        return intervals;
    }

    public void setIntervals(String intervals) {
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
