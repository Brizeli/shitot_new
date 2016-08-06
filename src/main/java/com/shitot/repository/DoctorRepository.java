package com.shitot.repository;

import com.shitot.model.*;

import java.util.List;

/**
 * Created by Next on 21.07.2016.
 */
public interface DoctorRepository {
    Doctor save(Doctor doctor);

    List<Certificate> getAllCertificates();

    List<Specialty> getAllSpecialties();

    List<Qualification> getAllQualifications();

    List<Doctor> getAll();

    Doctor get(int id);

    List<TargetAudience> getAllTargetAudiences();

    void setCertificate(int id, String certificateName);

    void setTargetAudiences(Integer id, String... audienceNames);

    void setSpecialties(Integer id, String... specialtieNames);

    void setQualifications(Integer id, String... qualificationNames);

    List<Doctor> getBySpecialty(String specialty);

    List<Doctor> getByQualification(String qualification);

    List<String> getAllCities();

    List<Doctor> getByCity(String city);
}
