package com.shitot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Range;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Next on 12.07.2016.
 */
@Entity(name = "intervals")
public class Interval implements Comparable{

    @Id
    @Range(min = 0, max = 23)
    private int hour;

    @ManyToMany (mappedBy = "intervals")
    @JsonIgnore
    private Set<Slot> slots;

    public Interval() {
    }

    public Interval(int hour) {
        this.hour = hour;
    }

    public static String intervalEnd(int hour) {
        return (hour >= 0 && hour <= 23) ? String.format("%02d", hour) : "";
    }

    public static String intervalStart(int hour) {
        return (hour >= 0 && hour <= 23) ? String.format("%02d", (hour + 1) % 24) : "";
    }

    public static String intervalName(int hour) {
        return (hour >= 0 && hour <= 23) ? String.format("%02d - %02d", hour, (hour + 1) % 24) : "";
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public Set<Slot> getSlots() {
        return slots;
    }

    public void setSlots(Set<Slot> slots) {
        this.slots = slots;
    }

    public void addSlot(Slot slot) {
        if (slots == null)
            slots = new HashSet<Slot>();
        slots.add(slot);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Interval interval = (Interval) o;

        return hour == interval.hour;

    }

    @Override
    public int hashCode() {
        return hour + 1;
    }

    @Override
    public String toString() {
        return "Interval{" + intervalName(hour) + "}";
    }

    @Override
    public int compareTo(Object o) {
        return hour - ((Interval) o).hour;
    }
}
