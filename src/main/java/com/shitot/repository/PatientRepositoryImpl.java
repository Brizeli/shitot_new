package com.shitot.repository;

import com.shitot.model.Patient;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Next on 17.08.2016.
 */
@Repository
public class PatientRepositoryImpl implements PatientRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Patient> getAll() {
        return em.createNamedQuery(Patient.ALL_SORTED, Patient.class).getResultList();
    }

    @Override
    public Patient get(int id) {
        return em.find(Patient.class, id);
    }


    @Override
    @Transactional
    public boolean delete(int id) {
        Patient p = em.find(Patient.class, id);
        if (p == null) return false;
        em.remove(p);
        return true;
    }

    @Transactional
    @Override
    public Patient save(Patient patient) {
        if (patient.isNew()) {
            em.persist(patient);
            return patient;
        } else return em.merge(patient);
    }
}
