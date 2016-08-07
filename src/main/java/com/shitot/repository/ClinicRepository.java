package com.shitot.repository;

import com.shitot.model.*;

import java.util.List;

/**
 * Created by Oleg on 01.08.2016.
 */
public interface ClinicRepository {

    Clinic save(Clinic clinic, Integer doctorId);

    List<String> getAllCities();

    Clinic get(int clinicId, int doctorId);

    boolean delete(int id, int doctorId);

    boolean setSlots(int clinicId, List<Slot> slots);




    List<Slot> getSlotsByClinic(int clinicId);

    Slot getSlotByDayClinic(int dayOfWeek, int clinicId);

    void setSlot(int dayOfWeek, int clinicId, int... hours);

    void deleteSlot(int dayOfWeek, int clinicId);

    void setClinic(Integer id, String name, String city, String address, int doctorId);

}
