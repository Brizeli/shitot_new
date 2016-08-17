package com.shitot.repository;

import com.shitot.model.*;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Repository
@Transactional
public class AppointmentRepositoryImpl implements AppointmentRepository {

    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    private EntityManager em;

    @Override
    @Transactional
    public Appointment save(Appointment appointment) {
        if (appointment.isNew()) {
            em.persist(appointment);
            return appointment;
        } else {
            return em.merge(appointment);
        }
    }

    @Override
    public List<Problem> getAllProblems() {
        return em.createNamedQuery(Problem.ALL_SORTED, Problem.class).getResultList();
    }

    @Override
    public List<Symptom> getAllSymptoms() {
        return em.createNamedQuery(Symptom.ALL_SORTED, Symptom.class).getResultList();
    }

    @Override
    public List<Appointment> getAllByDoctor(int id) {
        return em.createNamedQuery(Appointment.BY_DOCTOR, Appointment.class)
                 .setParameter("id", id)
                 .getResultList();
    }

    @Override
    public List<Appointment> getAllByAltDoctor(int id) {
        return em.createNamedQuery(Appointment.BY_ALTDOCTOR, Appointment.class)
                 .setParameter("id", id)
                 .getResultList();
    }

    @Override
    public List<Appointment> getAllByDoctorAndAlt(int id) {
        return em.createNamedQuery(Appointment.BY_DOCTOR_AND_ALT, Appointment.class)
                 .setParameter("id", id)
                 .getResultList();
    }
//    public List<Appointment> getAllByDoctorAndAlt(int id) {
//        List<Appointment> l = getAllByDoctor(id);
//        l.addAll(getAllByAltDoctor(id));
//        return l;
//    }

    @Override
    public List<Appointment> getAllByPatient(int id) {
        return em.createNamedQuery(Appointment.BY_PATIENT, Appointment.class)
                 .setParameter("id", id)
                 .getResultList();
    }

    @Override
    public List<Appointment> getAll() {
        return em.createNamedQuery(Appointment.ALL_SORTED, Appointment.class).getResultList();
    }
//    @Override
//    public List getJPQL(String s) {
//        return   em.createQuery(s).getResultList();
//    }

    @Override
    public Appointment get(int id) {
        return em.find(Appointment.class, id);
    }

    @Override
    @Transactional
    public void setProblems(int id, String... problems) {
        Set<Problem> problemSet = new LinkedHashSet<>();
        for (String s : problems) {
            Problem prb = em.find(Problem.class, s);
            if (prb == null) {
                prb = new Problem(s);
                em.persist(prb);
            }
            problemSet.add(prb);
        }
        em.find(Appointment.class, id).setProblems(problemSet);
    }

    @Override
    @Transactional
    public void setSymptoms(int id, String... symptoms) {
        Set<Symptom> symptomSet = new LinkedHashSet<>();
        for (String s : symptoms) {
            Symptom sym = em.find(Symptom.class, s);
            if (sym == null) {
                sym = new Symptom(s);
                em.persist(sym);
            }
            symptomSet.add(sym);
        }
        em.find(Appointment.class, id).setSymptoms(symptomSet);
    }

    @Override
    @Transactional
    public void setPatient(int id, int patientId) {
        em.find(Appointment.class, id).setPatient(em.find(Patient.class, patientId));
    }

    @Override
    @Transactional
    public void setDoctor(int id, int doctorId) {
//        if (em.find(Doctor.class,doctorId)==null)return;
        em.find(Appointment.class, id).setDoctor(em.find(Doctor.class, doctorId));
    }

    @Override
    @Transactional
    public void setAltDoctor(int id, int altDoctorId) {
        em.find(Appointment.class, id).setDoctor(em.find(Doctor.class, altDoctorId));
    }


    @Transactional
    @Override
    public Appointment removeDoctor(int appointmentId) {
        Appointment a = em.find(Appointment.class, appointmentId);
        a.setDoctor(null);
        return save(a);
    }

    @Transactional
    @Override
    public Appointment removeAltDoctor(int appointmentId) {
        Appointment a = em.find(Appointment.class, appointmentId);
        a.setAlternativeDoctor(null);
        return save(a);
    }

    @Override
    @Transactional
    public void setDoctorToAppointment(int appointmentId, int doctorId) {
        Appointment a = em.find(Appointment.class, appointmentId);
        a.setDoctor(em.find(Doctor.class, doctorId));
    }

    @Override
    public void setAltDoctorToAppointment(int appointmentId, int doctorId) {
        Appointment a = em.find(Appointment.class, appointmentId);
        Doctor d = em.find(Doctor.class, doctorId);
        a.setAlternativeDoctor(d);
        save(a);
    }
}
