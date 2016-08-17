package com.shitot.service;

import com.shitot.model.Appointment;
import com.shitot.model.Patient;
import com.shitot.model.Problem;
import com.shitot.model.Symptom;
import com.shitot.to.PatientTo;

import java.util.List;

public interface AppointmentService {

    Appointment save(Appointment appointment);

    List<Problem> getAllProblems();

    List<Symptom> getAllSymptoms();

    List<Appointment> getAllByDoctor(int id);

    List<Appointment> getAllByAltDoctor(int id);

    List<Appointment> getAllByDoctorAndAlt(int id);

    List<Appointment> getAll(int patientId);

    List<Appointment> getAll();

    Appointment get(int id);

    void setProblems(int id, String... problems);

    void setSymptoms(int id, String... symptoms);

    void setPatient(int id, int patientId);

    void setDoctor(int id, int doctorId);

    void setAltDoctor(int id, int altDoctorId);

    void removeDoctor(int appointmentId);

    void removeAltDoctor(int appointmentId);

    void setDoctorToAppointment(int appointmentId, int doctorId);

    void setAltDoctorToAppointment(int appointmentId, int doctorId);
}
