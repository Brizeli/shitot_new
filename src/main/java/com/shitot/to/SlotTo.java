package com.shitot.to;

import javax.validation.constraints.Size;

/**
 * Created by Admin on 01.09.2016.
 */
public class SlotTo {
    private boolean workDay;

    @Size(max = 255, message = " must be shorter than 255 characters")
    private String intervals;

    public SlotTo() {
    }

    public SlotTo(boolean workDay, String intervals) {
        this.workDay = workDay;
        this.intervals = intervals;
    }

    public boolean isWorkDay() {
        return workDay;
    }

    public void setWorkDay(boolean workDay) {
        this.workDay = workDay;
    }

    public String getIntervals() {
        return intervals;
    }

    public void setIntervals(String intervals) {
        this.intervals = intervals;
    }
}
