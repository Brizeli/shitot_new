package com.shitot.service;

import com.shitot.model.Clinic;
import com.shitot.model.Doctor;
import com.shitot.model.Slot;
import com.shitot.repository.ClinicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Oleg on 03.08.2016.
 */
@Service
public class ClinicServiceImpl implements ClinicService{
    
    @Autowired
    ClinicRepository repository;
    
    @Override
    public Clinic save(Clinic clinic) {
        //clinic.setId(null); why?!
        return repository.save(clinic);
    }

    @Override
    public List<Slot> getSlots(int clinicId) {
        return repository.getSlots(clinicId);
    }

    @Override
    public Slot getDaySlot(int dayOfWeek, int clinicId) {
        return repository.getDaySlot(dayOfWeek, clinicId);
    }

    @Override
    public List<Clinic> getByDoctor(int doctorId) {
        return repository.getByDoctor(doctorId);
    }

    @Override
    public List<Doctor> getDoctorByCity(String city) {
        return repository.getDoctorByCity(city);
    }

    @Override
    public List<Doctor> getDoctorByCitySpecialty(String city, String specialty) {
        return repository.getDoctorByCitySpecialty(city, specialty);
    }

    @Override
    public List<String> getAllCities() {
        return repository.getAllCities();
    }

    @Override
    public Clinic get(int clinicId) {
        return repository.get(clinicId);
    }

    @Override
    public void setSlot(int dayOfWeek, int clinicId, int... hours) {
        repository.setSlot(dayOfWeek, clinicId, hours);
    }

    @Override
    public void deleteSlot(int dayOfWeek, int clinicId) {
        repository.deleteSlot(dayOfWeek, clinicId);
    }

    @Override
    public void deleteClinic(int clinicId) {
        repository.deleteClinic(clinicId);
    }

    @Override
    public void setClinic(Integer id, String name, String city, String address, int doctorId) {
        repository.setClinic(id, name, city, address, doctorId);
    }
}
