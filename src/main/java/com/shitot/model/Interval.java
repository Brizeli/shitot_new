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

    private String name;

    private String start;

    private String end;

    @ManyToMany (mappedBy = "intervals", fetch = FetchType.EAGER)
    private Set<Slot> slots;

    public Interval() {
    }

    public Interval(int hour) {
        this.hour = hour;
        start = String.format("%02d", hour);
        end = String.format("%02d", (hour + 1) % 24);
        name = start + " - " + end;
    }

    public Interval(int hour, String name, String start, String end) {
        this.hour = hour;
        this.name = name;
        this.start = start;
        this.end = end;
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

    public void setSlot(Slot slot) {
        this.slots.add(slot);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
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
        return "Interval{" + name + "}";
    }
}
