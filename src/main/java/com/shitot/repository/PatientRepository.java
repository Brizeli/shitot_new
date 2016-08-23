package com.shitot.repository;

import com.shitot.model.Patient;

import java.util.List;

/**
 * Created by Next on 17.08.2016.
 */
public interface PatientRepository {
    List<Patient> getAll();

    Patient get(int id);

    boolean delete(int id);

    Patient save(Patient patient);
}
