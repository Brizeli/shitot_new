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
    public List<Clinic> getByCitySpecialty(String city, String specialty) {
        return em.createNamedQuery(Clinic.BY_CITY_SPECIALTY, Clinic.class)
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
    public Clinic get(int clinicId) {
        return em.find(Clinic.class, clinicId);
    }

    @Override
    @Transactional
    public void setSlot(int dayOfWeek, int clinicId, int... hours) {
        deleteSlot(dayOfWeek, clinicId);
        Set<Interval> intervalSet = new HashSet<>();
        for (int hour : hours) {
            Interval addingInterval = em.find(Interval.class, hour);
            if (addingInterval == null) {
                em.persist(new Interval(hour));
                addingInterval = em.find(Interval.class, hour);
            }
            intervalSet.add(addingInterval);
        }
        em.persist(new Slot(dayOfWeek, em.find(Clinic.class, clinicId), intervalSet));
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
            em.createNamedQuery(Slot.DELTE_BY_CLINIC, Slot.class)
                .setParameter("id", clinicId)
                .executeUpdate();
            em.remove(deletingClinic);
        }
    }

    @Override
    @Transactional
    public void setClinic(int doctorId, String name, String city, String address) {
        Doctor doctor = em.find(Doctor.class, doctorId);
        if (doctor != null)
            em.persist(new Clinic(name, city, address, doctor));
    }

}
