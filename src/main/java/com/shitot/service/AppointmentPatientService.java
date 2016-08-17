package com.shitot.service;

import com.shitot.model.Appointment;
import com.shitot.model.Patient;
import com.shitot.model.Problem;
import com.shitot.model.Symptom;
import com.shitot.to.PatientTo;

import java.util.List;


public interface AppointmentPatientService {
    Appointment save(Appointment appointment);
    Patient save(Patient patient);

    List<Problem> getAllProblems();

    List<Symptom> getAllSymptoms();

    List<Appointment> getAllByDoctor(int id);
    List<Appointment> getAllByAltDoctor(int id);
    List<Appointment> getAllByDoctorAndAlt(int id);

    List<Appointment> getAll(int patientId);

    List<Appointment> getAll();
//    List getJPQL(String s);

    List<Patient> getAllPatients();

    Appointment get(int id);
    Patient getPatient(int id);

    void setProblems(int id, String... problems);

    void setSymptoms(int id, String... symptoms);

    void deletePatient(int id);

    void setPatient(int id, int patientId);

    void setDoctor(int id, int doctorId);
    void setAltDoctor(int id, int altDoctorId);


    void update(PatientTo patientTo);
    Patient save(PatientTo patientTo);

    void removeDoctor(int appointmentId);

    void removeAltDoctor(int appointmentId);

    void setDoctorToAppointment(int appointmentId, int doctorId);

    void setAltDoctorToAppointment(int appointmentId, int doctorId);
}
