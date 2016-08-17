package com.shitot.service;

import com.shitot.model.*;

import java.util.List;

/**
 * Created by Oleg on 02.08.2016.
 */
public interface ClinicService {
    Clinic save(Clinic clinic, Integer doctorId);

    List<Slot> getSlots(int clinicId);

    Slot getDaySlot(int dayOfWeek, int clinicId);

    List<String> getAllCities();

    Clinic get(int clinicId, int doctorId);

    void setSlot(int dayOfWeek, int clinicId, int... hours);

    void deleteSlot(int dayOfWeek, int clinicId);

    void delete(int id, int doctorId);

    void setClinic(Integer id, String name, String city, String address, int doctorId);

    void update(Clinic clinic, Integer doctorId);

    void setSlots(int clinicId, List<Slot> slots);
}

