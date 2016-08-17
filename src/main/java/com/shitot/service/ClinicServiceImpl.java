package com.shitot.service;

import com.shitot.model.Clinic;
import com.shitot.model.Slot;
import com.shitot.repository.ClinicRepository;
import com.shitot.utils.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Oleg on 03.08.2016.
 */
@Service
public class ClinicServiceImpl implements ClinicService {

    @Autowired
    ClinicRepository repository;

    @Override
    public List<String> getAllCities() {
        return repository.getAllCities();
    }

    @Override
    public Clinic get(int id, int doctorId) {
        return repository.get(id, doctorId);
    }

    @Override
    public Clinic save(Clinic clinic, Integer doctorId) {
        return repository.save(clinic, doctorId);
    }

    @Override
    public void update(Clinic clinic, Integer doctorId) {
        Clinic saved = repository.save(clinic, doctorId);
        if (saved == null)
            throw new NotFoundException("Not found clinic with id=" + clinic.getId());
    }

    @Override
    public void delete(int id, int doctorId) {
        if (!repository.delete(id, doctorId)) throw new NotFoundException("Not found clinic with id=" + id);
    }

    @Override
    public void setSlots(int clinicId, List<Slot> slots) {
        if (!repository.setSlots(clinicId, slots))
            throw new NotFoundException("Clinic with id " + clinicId + " not found");
    }

    @Override
    public List<Slot> getSlots(int clinicId) {
        return repository.getSlotsByClinic(clinicId);
    }

    /////////////////////////////////////////////////////////////////


    @Override
    public Slot getDaySlot(int dayOfWeek, int clinicId) {
        return repository.getSlotByDayClinic(dayOfWeek, clinicId);
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
    public void setClinic(Integer id, String name, String city, String address, int doctorId) {
        repository.setClinic(id, name, city, address, doctorId);
    }
}
