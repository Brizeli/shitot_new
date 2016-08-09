package com.shitot.service;

import com.shitot.model.*;
import com.shitot.repository.AppointmentRepository;
import com.shitot.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Repository
@Transactional(readOnly = true)
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    AppointmentRepository repository;

    @Override
    public Appointment save(Appointment appointment) {
        return repository.save(appointment);
    }

    @Override
    public List<Problem> getAllProblems() {
        return repository.getAllProblems();
    }

    @Override
    public List<Symptom> getAllSymptoms() {
        return repository.getAllSymptoms();
    }

    @Override
    public List<Appointment> getAllByDoctor(int id) {
        return repository.getAllByDoctor(id);
    }

    @Override
    public List<Appointment> getAllByAltDoctor(int id) {
        return repository.getAllByAltDoctor(id);
    }

    @Override
    public List<Appointment> getAllByDoctorAndAlt(int id) {
        return repository.getAllByDoctorAndAlt(id);
    }

    @Override
    public List<Appointment> getAllByPatient(int id) {
        return repository.getAllByPatient(id);
    }

    @Override
    public List<Appointment> getAll() {
        return repository.getAll();
    }

    @Override
    public List<Patient> getAllPatients() {
        return repository.getAllPatients();
    }

    @Override
    public Appointment get(int id) {
        return repository.get(id);
    }

    @Override
    @Transactional
    public void setProblems(int id, String... problems) {
        repository.setProblems(id, problems);
    }

    @Override
    @Transactional
    public void setSymptoms(int id, String... symptoms) {
        repository.setSymptoms(id, symptoms);
    }

    @Transactional
    @Override
    public void deletePatient(int id) {
        repository.deletePatient(id);
    }

    @Override
    @Transactional
    public void setPatient(int id, int patientId) {
        repository.setPatient(id, patientId);
    }

    @Override
    @Transactional
    public void setDoctor(int id, int doctorId) {
        repository.setDoctor(id, doctorId);
    }

    @Override
    @Transactional
    public void setAltDoctor(int id, int altDoctorId){
        repository.setAltDoctor( id,  altDoctorId);
    }
}
