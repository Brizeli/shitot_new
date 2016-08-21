package com.shitot.service;

import com.shitot.model.Appointment;
import com.shitot.model.Problem;
import com.shitot.model.Symptom;
import com.shitot.to.AppointmentTo;

import java.util.List;

public interface AppointmentService {

    Appointment save(AppointmentTo appointment);

    List<Problem> getAllProblems();

    List<Symptom> getAllSymptoms();

    List<Appointment> getAllByDoctor(int id);

    List<Appointment> getAllByAltDoctor(int id);

    List<Appointment> getAllByDoctorAndAlt(int id);

    List<Appointment> getAll(int patientId);

    List<Appointment> getAll();

    Appointment get(int id);

    void setDoctor(int id, int doctorId);

    void setAltDoctor(int id, int altDoctorId);

    void removeDoctor(int appointmentId);

    void removeAltDoctor(int appointmentId);

    void update(AppointmentTo appointmentTo);
}
