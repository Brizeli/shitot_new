package com.shitot.model;

import javax.persistence.Embeddable;

/**
 * Created by Next on 12.07.2016.
 */
@Embeddable
public class Interval implements Comparable{

    private int hour = 0;

    public static boolean validate(int hour) {
        return hour >= 0 && hour <= 23;
    }

    public Interval() {
    }

    public Interval(int hour) {
        setHour(hour);
    }

    public static String intervalEnd(int hour) {
        return validate(hour) ? String.format("%02d", hour) : "";
    }

    public static String intervalStart(int hour) {
        return validate(hour) ? String.format("%02d", (hour + 1) % 24) : "";
    }

    public static String intervalName(int hour) {
        return validate(hour) ? String.format("%02d - %02d", hour, (hour + 1) % 24) : "";
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        if (validate(hour))
            this.hour = hour;
        else
            throw new IllegalArgumentException("hour muse be in range 0..23");
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
