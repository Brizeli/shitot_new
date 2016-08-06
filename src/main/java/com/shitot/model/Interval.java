package com.shitot.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Set;

/**
 * Created by Next on 12.07.2016.
 */
@Entity(name = "intervals")
public class Interval {

    @Id
    @Min(0)
    @Max(23)
    private int hour;

    @ManyToMany (mappedBy = "intervals", fetch = FetchType.EAGER)
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Interval interval = (Interval) o;

        return hour == interval.hour;

    }

    @Override
    public int hashCode() {
        return hour;
    }

    @Override
    public String toString() {
        return "Interval{" + intervalName(hour) + "}";
    }
}
