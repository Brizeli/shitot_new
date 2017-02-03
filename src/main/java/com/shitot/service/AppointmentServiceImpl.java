package com.shitot.service;

import com.shitot.model.*;
import com.shitot.repository.AppointmentRepository;
import com.shitot.to.AppointmentClientDoctorTo;
import com.shitot.to.AppointmentTo;
import com.shitot.utils.JsonUtil;
import com.shitot.utils.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {
    
    @Autowired
    private AppointmentRepository repository;
    
    @Override
    @Transactional
    public void save(AppointmentClientDoctorTo to) {
        Appointment appointment = repository.save(JsonUtil.createNewFromTo(to));
        setProblemsSymptoms(appointment.getId(),to);
        repository.setDoctors(appointment,to.getDoctorId(),to.getAltdoctorId());
    }
    
    
    @Override
    @Transactional
    public Appointment save(AppointmentTo appointmentTo) {
        Appointment appointment = repository.save(JsonUtil.createNewFromTo(appointmentTo));
        setProblemsSymptomsPatient(appointment.getId(), appointmentTo);
        return appointment;
    }
    
    @Override
    @Transactional
    public void update(AppointmentClientDoctorTo to) {
        int id = to.getId();
        Appointment appointment = get(id);
        repository.save(JsonUtil.updateFromTo(appointment, to));
        setProblemsSymptoms(id, to);
    }
    
    @Override
    @Transactional
    public void update(AppointmentTo appointmentTo) {
        int id = appointmentTo.getId();
        Appointment appointment = get(id);
        repository.save(JsonUtil.updateFromTo(appointment, appointmentTo));
        setProblemsSymptomsPatient(id, appointmentTo);
    }
    
    
    private void setProblemsSymptomsPatient(Integer id, AppointmentTo appointmentTo) {
        repository.setPatient(id, appointmentTo.getPatientId());
        repository.setProblems(id, appointmentTo.getProblems());
        repository.setSymptoms(id, appointmentTo.getSymptoms());
    }
    
    private void setProblemsSymptoms(Integer id, AppointmentClientDoctorTo to) {
        repository.setProblems(id, to.getProblems());
        repository.setSymptoms(id, to.getSymptoms());
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
    public void setDoctor(int id, int doctorId, boolean alt) {
        Appointment appointment = get(id);
        if (appointment == null) throw new NotFoundException("Not found appointment with id " + id);
        repository.setDoctor(appointment, doctorId, alt);
    }
    
    @Override
    public void removeDoctor(int id, boolean alt) {
        if (!repository.removeDoctor(id, alt)) throw new NotFoundException("Not found appointment with id " + id);
    }
    
    @Override
    public List<Appointment> getByDoctorId(int doctorId) {
        return repository.getAllByDoctor(doctorId);
    }
    
    @Override
    public List<Appointment> getByDoctorIdBetweenDates(int doctorId, LocalDate startDate, LocalDate endDate) {
        return repository.getAllByAltDoctorBetweenDates(doctorId, startDate, endDate);
    }
    
    @Override
    public void delete(int id) {
        if (!repository.delete(id)) throw new NotFoundException("Not found appointment with id=" + id);
    }
}
