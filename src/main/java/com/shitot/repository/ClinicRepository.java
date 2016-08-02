package com.shitot.repository;

import com.shitot.model.Clinic;
import com.shitot.model.Slot;

import java.util.List;

/**
 * Created by Oleg on 01.08.2016.
 */
public interface ClinicRepository {
    Clinic save(Clinic clinic);

    List<Slot> getSlots(int clinicId);

    Slot getDaySlot(int dayOfWeek, int clinicId);

    List<Clinic> getByCitySpecialty(String city, String specialty);

    List<Clinic> getByDoctor(int doctorId);

    Clinic get(int clinicId);

    void setSlot(int dayOfWeek, int clinicId, int... hours);

    void setClinic(int doctorId, String name, String city, String address);

}
