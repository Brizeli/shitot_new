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
    public Doctor save(DoctorTo doctorTo) {
        Doctor doctor = repository.save(JsonUtil.createNewFromTo(doctorTo));
        Integer id = doctor.getId();
        repository.setSpecialties(id, doctorTo.getSpecialty1(), doctorTo.getSpecialty2());
        repository.setQualifications(id, doctorTo.getQualifications());
        repository.setTargetAudiences(id, doctorTo.getTargetAudiences());
        repository.setCertificate(id, doctorTo.getCertificate());
        return doctor;
    }

    @Override
    @Transactional
    public void update(DoctorTo doctorTo) {
        Integer id = doctorTo.getId();
        Doctor doctor = get(id);
        repository.save(JsonUtil.updateFromTo(doctor, doctorTo));
        repository.setSpecialties(id, doctorTo.getSpecialty1(), doctorTo.getSpecialty2());
        repository.setQualifications(id, doctorTo.getQualifications());
        repository.setTargetAudiences(id, doctorTo.getTargetAudiences());
        repository.setCertificate(id, doctorTo.getCertificate());
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
    public List<String> getAllCities() {
        return null;
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
}
