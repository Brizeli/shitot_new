package com.shitot.service;

import com.shitot.model.Clinic;
import com.shitot.to.SlotsTo;

import java.util.List;
import java.util.Map;

/**
 * Created by Oleg on 02.08.2016.
 */
public interface ClinicService {
    Clinic save(Clinic clinic, Integer doctorId);

    Map<Integer, String> getSlots(int clinicId);

    List<String> getAllCities();

    Clinic get(int clinicId, int doctorId);

    void delete(int id, int doctorId);

    void setClinic(Integer id, String name, String city, String address, int doctorId);

    void update(Clinic clinic, Integer doctorId);

    void setSlots(SlotsTo slots);
}

