package com.shitot.repository;

import com.shitot.model.Clinic;
import com.shitot.to.SlotsTo;

import java.util.List;
import java.util.Map;

/**
 * Created by Oleg on 01.08.2016.
 */
public interface ClinicRepository {

    Clinic save(Clinic clinic, Integer doctorId);

    List<String> getAllCities();

    Clinic get(int clinicId, int doctorId);

    boolean delete(int id, int doctorId);

    boolean setSlots(SlotsTo slotsTo);

    Map<Integer, String> getSlotsByClinic(int clinicId);

    void setClinic(Integer id, String name, String city, String address, int doctorId);
}
