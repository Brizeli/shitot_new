package com.shitot.service;

import com.shitot.model.Appointment;
import com.shitot.model.Problem;
import com.shitot.model.Symptom;
import com.shitot.to.AppointmentClientDoctorTo;
import com.shitot.to.AppointmentTo;

import java.time.LocalDate;
import java.util.List;

public interface AppointmentService {
    void save(AppointmentClientDoctorTo to);

    Appointment save(AppointmentTo appointment);

    void update(AppointmentClientDoctorTo to);
    
    List<Problem> getAllProblems();

    List<Symptom> getAllSymptoms();

    List<Appointment> getAllByDoctor(int id);

    List<Appointment> getAllByAltDoctor(int id);

    List<Appointment> getAllByDoctorAndAlt(int id);

    List<Appointment> getAll(int patientId);

    List<Appointment> getAll();

    Appointment get(int id);

    void update(AppointmentTo appointmentTo);

    void setDoctor(int id, int doctorId, boolean alt);

    void removeDoctor(int id, boolean alt);

    List<Appointment> getByDoctorId(int doctorId);
    
    List<Appointment> getByDoctorIdBetweenDates(int doctorId, LocalDate startDate, LocalDate endDate);
    
    void delete(int id);
    
    List<Appointment> getBetweenDates(LocalDate startDate, LocalDate endDate);
}
