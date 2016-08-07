package com.shitot.repository;

import com.shitot.model.Clinic;
import com.shitot.model.Doctor;
import com.shitot.model.Interval;
import com.shitot.model.Slot;
import com.shitot.utils.exception.NotFoundException;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.*;

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
        if (!clinic.isNew() && get(clinic.getId(), doctorId) == null) {
            return null;
        }
        clinic.setDoctor(em.getReference(Doctor.class, doctorId));
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
        List<Clinic> clinicList = em.createNamedQuery(Clinic.GET, Clinic.class)
                                    .setParameter("id", id)
                                    .setParameter("doctorId", doctorId)
                                    .getResultList();
        return DataAccessUtils.singleResult(clinicList);
    }

    @Override
    @Transactional
    public boolean delete(int id, int doctorId) {
        return em.createNamedQuery(Clinic.DELETE)
                 .setParameter("id", id)
                 .setParameter("doctorId", doctorId)
                 .executeUpdate() != 0;
    }

    @Override
    @Transactional
    public boolean setSlots(int clinicId, List<Slot> newSlots) {
        Clinic clinic = em.find(Clinic.class, clinicId);
        if (clinic == null) return false;
        Set<Slot> slots = new HashSet<>();
        for (Slot newSlot : newSlots) {
            Set<Interval> intervals = new HashSet<>();
            for (Interval newInterval : newSlot.getIntervals()) {
                Interval interval = em.find(Interval.class, newInterval.getHour());
                if (interval == null) {
                    interval = newInterval;
                    em.persist(interval);
                }
                intervals.add(interval);
            }
            Slot slot = getSlotByDayClinic(newSlot.getDayOfWeek(), clinicId);
            if (slot == null) {
                slot = newSlot;
                slot.setClinic(clinic);
                slot.setIntervals(intervals);
                em.persist(slot);
            } else {
                slot.setIntervals(intervals);
                em.merge(slot);
            }
            slots.add(slot);
        }
        clinic.setSlots(slots);
        return true;
    }

    @Override
    public List<Slot> getSlotsByClinic(int clinicId) {
        return em.createNamedQuery(Slot.BY_CLINIC, Slot.class)
                 .setParameter("id", clinicId)
                 .getResultList();
    }

    @Override
    public Slot getSlotByDayClinic(int dayOfWeek, int clinicId) {
        List<Slot> slots = em.createNamedQuery(Slot.BY_DAY_CLINIC, Slot.class)
                             .setParameter("id", clinicId)
                             .setParameter("dayOfWeek", dayOfWeek)
                             .getResultList();
        return DataAccessUtils.singleResult(slots);
    }

    ////////////////////////////////////////////////////////


    @Override
    @Transactional
    public void setSlot(int dayOfWeek, int clinicId, int... hours) {
        Set<Interval> intervals = new LinkedHashSet<>();
        Arrays.sort(hours);
        int prevHour = hours[0] - 1;
        for (int hour : hours) {
            if (hour == prevHour)
                continue;
            prevHour = hour;
            Interval addingInterval = em.find(Interval.class, hour);
            if (addingInterval == null) {
                addingInterval = new Interval(hour);
                em.persist(addingInterval);
            }
            intervals.add(addingInterval);
        }
        Slot newSlot = getSlotByDayClinic(dayOfWeek, clinicId);
        if (newSlot == null) {
            Clinic clinic = em.find(Clinic.class, clinicId);
            if (clinic == null)
                throw new IllegalArgumentException("Clinic with id " + clinicId + " not found");
            newSlot = new Slot(null, dayOfWeek, em.find(Clinic.class, clinicId));
            newSlot.setIntervals(intervals);
            em.persist(newSlot);
        } else {
            newSlot.setIntervals(intervals);
            em.merge(newSlot);
        }
    }

    @Override
    @Transactional
    public void deleteSlot(int dayOfWeek, int clinicId) {
        Slot deletingSlot = getSlotByDayClinic(dayOfWeek, clinicId);
        if (deletingSlot != null)
            em.remove(deletingSlot);
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
