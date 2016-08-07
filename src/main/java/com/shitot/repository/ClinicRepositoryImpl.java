package com.shitot.repository;

import com.shitot.model.Clinic;
import com.shitot.model.Doctor;
import com.shitot.model.Interval;
import com.shitot.model.Slot;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    public Clinic save(Clinic clinic) {
        if (clinic.isNew()) {
            em.persist(clinic);
            return clinic;
        } else return em.merge(clinic);
    }

    @Override
    public List<Slot> getSlots(int clinicId) {
        return em.createNamedQuery(Slot.BY_CLINIC, Slot.class)
            .setParameter("id", clinicId)
            .getResultList();
    }

    @Override
    public Slot getDaySlot(int dayOfWeek, int clinicId) {
        List<Slot> result = em.createNamedQuery(Slot.BY_DAY_CLINIC, Slot.class)
            .setParameter("id", clinicId)
            .setParameter("dayOfWeek", dayOfWeek)
            .getResultList();
        if (result.isEmpty())
            return null;
        return result.get(0);
    }

    @Override
    public List<Doctor> getDoctorByCitySpecialty(String city, String specialty) {
        return em.createNamedQuery(Clinic.DOCTOR_BY_CITY_SPECIALTY, Doctor.class)
            .setParameter("city", city)
            .setParameter("specialty", specialty)
            .getResultList();
    }

    @Override
    public List<Clinic> getByDoctor(int doctorId) {
        return em.createNamedQuery(Clinic.BY_DOCTOR, Clinic.class)
            .setParameter("id", doctorId)
            .getResultList();
    }

    @Override
    public List<Doctor> getDoctorByCity(String city) {
        return em.createNamedQuery(Clinic.DOCTOR_BY_CITY, Doctor.class)
            .setParameter("city", city)
            .getResultList();
    }

    @Override
    public List<String> getAllCities() {
        return em.createNamedQuery(Clinic.ALL_CITIES).getResultList();
    }

    @Override
    public Clinic get(int clinicId) {
        return em.find(Clinic.class, clinicId);
    }

    @Override
    @Transactional
    public void setSlot(int dayOfWeek, int clinicId, int... hours) {
        Set<Interval> intervals = new HashSet<>();
        for (int hour : hours) {
            intervals.add(new Interval(hour));
        }
        if (intervals.isEmpty())
            deleteSlot(dayOfWeek, clinicId);
        else {
            Slot newSlot = getDaySlot(dayOfWeek, clinicId);
            if (newSlot == null) {
                Clinic clinic = em.find(Clinic.class, clinicId);
                if (clinic == null)
                    throw new IllegalArgumentException("Clinic with id " + clinicId + " not found");
                newSlot = new Slot(null, dayOfWeek, em.find(Clinic.class, clinicId), intervals);
                em.persist(newSlot);
            } else {
                newSlot.setIntervals(intervals);
                em.merge(newSlot);
            }
        }
    }

    @Override
    @Transactional
    public void deleteSlot(int dayOfWeek, int clinicId) {
        Slot deletingSlot = getDaySlot(dayOfWeek, clinicId);
        if (deletingSlot != null)
            em.remove(deletingSlot);
    }

    @Override
    @Transactional
    public void deleteClinic(int clinicId) {
        Clinic deletingClinic = em.find(Clinic.class, clinicId);
        if (deletingClinic != null) {
            em.remove(deletingClinic);
        }
    }

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
