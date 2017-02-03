package com.shitot.repository;

import com.shitot.model.*;

import java.time.LocalDate;
import java.util.List;


public interface AppointmentRepository {

    Appointment save(Appointment appointment);

    List<Problem> getAllProblems();

    List<Symptom> getAllSymptoms();

    List<Appointment> getAllByDoctor(int id);

    List<Appointment> getAllByAltDoctor(int id);

    List<Appointment> getAllByDoctorAndAlt(int id);

    List<Appointment> getAllByPatient(int id);

    List<Appointment> getAll();

    Appointment get(int id);

    void setProblems(int id, String... problems);

    void setSymptoms(int id, String... symptoms);

    void setPatient(int id, int patientId);

    void setDoctor(Appointment appointment, int doctorId, boolean alt);

    boolean removeDoctor(int id, boolean alt);

    List<Appointment> getAllByAltDoctorBetweenDates(int doctorId, LocalDate startDate, LocalDate endDate);
    
    void setDoctors(Appointment appointment, Integer doctorId, Integer altdoctorId);
    
    boolean delete(int id);
    
    List<Appointment> getFiltered(LocalDate startDate, LocalDate endDate);
}
