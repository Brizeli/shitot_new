package com.shitot.to;

/**
 * Created by Admin on 30.08.2016.
 */
public class SlotsTo {
    private int clinicId;
    private SlotTo[] slotsTo = new SlotTo[7];


    public SlotsTo() {
    }

    public SlotsTo(int clinicId, SlotTo[] slotsTo) {
        this.clinicId = clinicId;
        this.slotsTo = slotsTo;
    }

    public int getClinicId() {
        return clinicId;
    }

    public void setClinicId(int clinicId) {
        this.clinicId = clinicId;
    }

    public SlotTo[] getSlotsTo() {
        return slotsTo;
    }

    public void setSlotsTo(SlotTo[] slotsTo) {
        this.slotsTo = slotsTo;
    }
}
