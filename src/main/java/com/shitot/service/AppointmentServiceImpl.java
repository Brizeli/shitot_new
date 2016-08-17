package com.shitot.service;

import com.shitot.model.*;
import com.shitot.repository.AppointmentRepository;
import com.shitot.to.PatientTo;
import com.shitot.utils.JsonUtilAppointmentPatient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepository repository;

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
    public List<Appointment> getAll(int patientId) {
        return repository.getAllByPatient(patientId);
    }

    @Override
    public List<Appointment> getAll() {
        return repository.getAll();
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
    public void setAltDoctor(int id, int altDoctorId) {
        repository.setAltDoctor(id, altDoctorId);
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
    public void setDoctorToAppointment(int appointmentId, int doctorId) {
        repository.setDoctorToAppointment(appointmentId, doctorId);
    }

    @Override
    public void setAltDoctorToAppointment(int appointmentId, int doctorId) {
        repository.setAltDoctorToAppointment(appointmentId, doctorId);
    }
}
