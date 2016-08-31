package com.shitot.service;

import com.shitot.model.*;
import com.shitot.repository.DoctorRepository;
import com.shitot.to.DoctorTo;
import com.shitot.utils.JsonUtil;
import com.shitot.utils.exception.NotFoundException;
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
    @Transactional
    public Doctor save(DoctorTo doctorTo) {
        Doctor doctor = repository.save(JsonUtil.createNewFromTo(doctorTo));
        setRegalias(doctor.getId(), doctorTo);
        return doctor;
    }

    @Override
    @Transactional
    public void update(DoctorTo doctorTo) {
        int id = doctorTo.getId();
        Doctor doctor = get(id);
        repository.save(JsonUtil.updateFromTo(doctor, doctorTo));
        setRegalias(id, doctorTo);
    }

    private void setRegalias(Integer id, DoctorTo doctorTo) {
        repository.setSpecialties(id, doctorTo.getSpecialty1(), doctorTo.getSpecialty2());
        repository.setQualifications(id, doctorTo.getQualifications());
        repository.setTargetAudiences(id, doctorTo.getTargetAudiences());
        repository.setCertificate(id, doctorTo.getCertificate(), doctorTo.getFile());
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
    public List<Doctor> getByCity(String city) {
        return repository.getByCity(city);
    }

    @Override
    public void delete(int id) {
        if (!repository.delete(id)) throw new NotFoundException("Not found doctor with id=" + id);
    }

    @Override
    public Doctor getWithCertificate(int id) {
        return repository.getWithCertificate(id);
    }

    @Override
    public List<String> getAllCities() {
        return repository.getAllCities();
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
    public List<TargetAudience> getAllTargetAudiences() {
        return repository.getAllTargetAudiences();
    }
}
