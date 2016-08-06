package com.shitot.repository;

import com.shitot.model.*;

import java.util.List;

/**
 * Created by Oleg on 01.08.2016.
 */
public interface ClinicRepository {
    Clinic save(Clinic clinic);

    List<Slot> getSlots(int clinicId);

    Slot getDaySlot(int dayOfWeek, int clinicId);

    List<Doctor> getDoctorByCitySpecialty(String city, String specialty);

    List<Doctor> getDoctorByCity(String city);

    List<Clinic> getByDoctor(int doctorId);

    List<String> getAllCities();

    Clinic get(int clinicId);

    void setSlot(int dayOfWeek, int clinicId, int... hours);

    void deleteSlot(int dayOfWeek, int clinicId);

    void deleteClinic(int clinicId);

    void setClinic(Integer id, String name, String city, String address, int doctorId);

}
