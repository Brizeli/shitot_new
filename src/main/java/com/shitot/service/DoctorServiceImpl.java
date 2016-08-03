package com.shitot.service;

import com.shitot.model.*;
import com.shitot.repository.DoctorRepository;
import com.shitot.to.DoctorTo;
import com.shitot.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Next on 21.07.2016.
 */
@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    DoctorRepository repository;

    @Override
    public List<Doctor> getAll() {
        return repository.getAll();
    }

    @Override
    public Doctor get(int id) {
        return repository.get(id);
    }

    @Override
    public List<TargetAudience> getAllTargetAudiences() {
        return repository.getAllTargetAudiences();
    }

    @Override
    @Transactional
    public void update(DoctorTo doctorTo) {
        Doctor doctor = get(doctorTo.getId());
        repository.save(JsonUtil.updateFromTo(doctor, doctorTo));
    }

    @Override
    public List<Doctor> getBySpecialty(String specialty) {
        return repository.getBySpecialty(specialty);
    }

    @Override
    public List<Doctor> getByQualification(String qualification) {
        return repository.getByQualification(qualification);
    }

    @Override
    public List<Qualification> getAllQualifications() {
        return repository.getAllQualifications();
    }

    @Override
    public List<Certificate> getAllCertificates() {
        return repository.getAllCertificates();
    }

    @Override
    public List<Specialty> getAllSpecialties() {
        return repository.getAllSpecialties();
    }

    @Override
    public List<Qualification> getAllExperiences() {
        return repository.getAllQualifications();
    }

    @Override
    public Doctor save(Doctor doctor) {
        doctor.setId(null);
        return repository.save(doctor);
    }
}
