package com.shitot.service;

import com.shitot.model.*;
import com.shitot.to.DoctorTo;

import java.util.List;

/**
 * Created by Next on 21.07.2016.
 */
public interface DoctorService {

    Doctor save(DoctorTo doctor);

    List<Specialty> getAllSpecialties();

    List<Qualification> getAllExperiences();

    List<Certificate> getAllCertificates();

    List<Doctor> getAll();

    Doctor get(int id);

    List<TargetAudience> getAllTargetAudiences();

    void update(DoctorTo doctorTo);

    List<Doctor> getBySpecialty(String specialty);

    List<Doctor> getByQualification(String qualification);

    List<Qualification> getAllQualifications();

    List<String> getAllCities();

    List<Doctor> getByCity(String city);

    void delete(int id);
}
