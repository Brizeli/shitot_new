package com.shitot.service;

import com.shitot.model.*;
import com.shitot.repository.AppointmentPatientRepository;
import com.shitot.to.DoctorTo;
import com.shitot.to.PatientTo;
import com.shitot.utils.JsonUtil;
import com.shitot.utils.JsonUtilAppointmentPatient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(readOnly = true)
public class AppointmentPatientServiceImpl implements AppointmentPatientService {

    @Autowired
    AppointmentPatientRepository repository;

    @Override
    public Appointment save(Appointment appointment) {
        return repository.save(appointment);
    }

    @Override
    public Patient save(Patient patient) {
        return repository.save(patient);
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
    public List<Appointment> getAll(int patientId) {
        return repository.getAllByPatient(patientId);
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
    public Patient getPatient(int id) {
        return repository.getPatient(id);
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

    @Override
    @Transactional
    public Patient save(PatientTo patientTo) {
        Patient patient = repository.save(JsonUtilAppointmentPatient.createNewFromTo(patientTo));
        Integer id = patient.getId();
        return patient;
    }

    @Override
    public void removeDoctor(int appointmentId) {
        repository.removeDoctor(appointmentId);
    }

    @Override
    public void removeAltDoctor(int appointmentId) {
        repository.removeAltDoctor(appointmentId);
    }

    @Override
    @Transactional
    public void update(PatientTo patientTo) {
        Integer id = patientTo.getId();
        Patient patient = getPatient(id);
        repository.save(JsonUtilAppointmentPatient.updateFromTo(patient, patientTo));
    }

}
