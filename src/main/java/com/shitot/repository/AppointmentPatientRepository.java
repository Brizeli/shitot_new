package com.shitot.repository;

import com.shitot.model.*;

import java.util.List;


public interface AppointmentPatientRepository {
    Appointment save(Appointment appointment);

    List<Problem> getAllProblems();

    List<Symptom> getAllSymptoms();

    List<Appointment> getAllByDoctor(int id);
    List<Appointment> getAllByAltDoctor(int id);
    List<Appointment> getAllByDoctorAndAlt(int id);

    List<Appointment> getAllByPatient(int id);

    List<Appointment> getAll();
//    List getJPQL(String s);

    List<Patient> getAllPatients();

    Appointment get(int id);
    Patient getPatient(int id);

    void setProblems(int id,String... problems);

    void setSymptoms(int id,String... symptoms);

    void setPatient(int id, int patientId);

    void setDoctor(int id, int doctorId);
    void setAltDoctor(int id, int altDoctorId);


    void deletePatient(int id);

    Patient save(Patient patient);
}
