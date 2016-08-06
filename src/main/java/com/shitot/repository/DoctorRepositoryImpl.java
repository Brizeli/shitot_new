package com.shitot.repository;

import com.shitot.model.*;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Next on 21.07.2016.
 */
@Repository
@Transactional(readOnly = true)
public class DoctorRepositoryImpl implements DoctorRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public Doctor save(Doctor doctor) {
        if (doctor.isNew()) {
            em.persist(doctor);
            return doctor;
        } else return em.merge(doctor);
    }

    @Override
    public List<Certificate> getAllCertificates() {
        return em.createNamedQuery(Certificate.ALL_SORTED, Certificate.class).getResultList();
    }

    @Override
    public List<Specialty> getAllSpecialties() {
        return em.createNamedQuery(Specialty.ALL_SORTED, Specialty.class).getResultList();
    }

    @Override
    public List<Qualification> getAllQualifications() {
        return em.createNamedQuery(Qualification.ALL_SORTED, Qualification.class).getResultList();
    }

    @Override
    public List<TargetAudience> getAllTargetAudiences() {
        return em.createNamedQuery(TargetAudience.ALL_SORTED, TargetAudience.class).getResultList();
    }

    @Override
    public List<Doctor> getAll() {
        return em.createNamedQuery(Doctor.ALL_SORTED, Doctor.class).getResultList();
    }

    @Override
    public Doctor get(int id) {
        return em.find(Doctor.class, id);
    }

    @Override
    @Transactional
    public void setCertificate(int id, String certificateName) {
        Certificate certificate = em.find(Certificate.class, certificateName);
        if (certificate == null) {
            certificate = new Certificate(certificateName);
            em.persist(certificate);
        }
        em.find(Doctor.class, id).setCertificate(certificate);
    }
    
    @Override
    @Transactional
    public void setTargetAudiences(Integer id, String... audienceNames) {
        Set<TargetAudience> targetAudiences = new HashSet<>();
        for (String name : audienceNames) {
            TargetAudience targetAudience = em.find(TargetAudience.class, name);
            if (targetAudience == null) {
                targetAudience = new TargetAudience(name);
                em.persist(targetAudience);
            }
            targetAudiences.add(targetAudience);
        }
        em.find(Doctor.class, id).setTargetAudiences(targetAudiences);
    }

    @Override
    @Transactional
    public void setSpecialties(Integer id, String... specialtieNames) {
        Set<Specialty> specialties = new HashSet<>();
        for (String name : specialtieNames) {
            Specialty specialty = em.find(Specialty.class, name);
            if (specialty == null) {
                specialty = new Specialty(name);
                em.persist(specialty);
            }
            specialties.add(specialty);
        }
        em.find(Doctor.class, id).setSpecialties(specialties);
    }

    @Override
    @Transactional
    public void setQualifications(Integer id, String... qualificationNames) {
        Set<Qualification> qualifications = new HashSet<>();
        for (String name : qualificationNames) {
            Qualification qualification = em.find(Qualification.class, name);
            if (qualification == null) {
                qualification = new Qualification(name);
                em.persist(qualification);
            }
            qualifications.add(qualification);
        }
        em.find(Doctor.class, id).setQualifications(qualifications);
    }

    @Override
    public List<Doctor> getBySpecialty(String specialty) {
        return em.createNamedQuery(Doctor.BY_SPECIALTY, Doctor.class)
                 .setParameter("specialty", specialty)
                 .getResultList();
    }

    @Override
    public List<Doctor> getByQualification(String qualification) {
        return em.createNamedQuery(Doctor.BY_QUALIFICATION, Doctor.class)
                 .setParameter("qualification", qualification)
                 .getResultList();
    }
}
