package com.shitot.repository;

import com.shitot.model.Clinic;
import com.shitot.model.Doctor;
import com.shitot.to.SlotTo;
import com.shitot.to.SlotsTo;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.Integer.min;

/**
 * Created by Oleg on 01.08.2016.
 */
@Repository
@Transactional(readOnly = true)
public class ClinicRepositoryImpl implements ClinicRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public Clinic save(Clinic clinic, Integer doctorId) {
        Doctor doctor = em.getReference(Doctor.class, doctorId);
        if (doctor == null)
            return null;
        clinic.setDoctor(doctor);
        if (clinic.isNew()) {
            em.persist(clinic);
            return clinic;
        } else return em.merge(clinic);
    }

    @Override
    public List<String> getAllCities() {
        return em.createNamedQuery(Clinic.ALL_CITIES_SORTED, String.class).getResultList();
    }

    @Override
    public Clinic get(int id, int doctorId) {
        return em.find(Clinic.class, id);
    }

    @Override
    @Transactional
    public boolean delete(int id, int doctorId) {
        Clinic deleted = em.find(Clinic.class, id);
        if (deleted == null) return false;
        em.remove(deleted);
        return true;
    }

    @Override
    @Transactional
    public boolean setSlots(SlotsTo slotsTo) {
        Clinic clinic = em.find(Clinic.class, slotsTo.getClinicId());
        if (clinic == null) return false;
        HashMap<Integer, String> newSlots = new HashMap<>();
        SlotTo[] newSlotsTo = slotsTo.getSlotsTo();
        //array of 0..7 elements. If day #i is a working day newSlotsTo.isWorkDay return true,
        // newSlotsTo[i].getIntervals()
        for (int i = 0, newSlotsCnt = min(7, newSlotsTo.length); i < newSlotsCnt; ++i) {
            if (newSlotsTo[i] != null && newSlotsTo[i].isWorkDay())
                    newSlots.put(i, newSlotsTo[i].getIntervals());
        }
        clinic.setSlots(newSlots);
        em.merge(clinic);
        return true;
    }

    @Override
    public Map<Integer, String> getSlotsByClinic(int clinicId) {
        Clinic clinic = em.find(Clinic.class, clinicId);
        if (clinic == null)
            return null;
        return clinic.getSlots();
    }

    ////////////////////////////////////////////////////////

    @Override
    @Transactional
    public void setClinic(Integer id, String name, String city, String address, int doctorId) {
        Doctor doctor = em.find(Doctor.class, doctorId);
        if (doctor == null)
            throw new IllegalArgumentException("Doctor with id " + id + " not found");
        Clinic clinic;
        if (id == null || (clinic = em.find(Clinic.class, id)) == null)
            em.persist(new Clinic(id, name, city, address, doctor));
        else {
            clinic.setName(name);
            clinic.setCity(city);
            clinic.setAddress(address);
            clinic.setDoctor(doctor);
            em.merge(clinic);
        }
    }
}
