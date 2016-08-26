package com.shitot.service;

import com.shitot.model.Patient;

import java.util.List;

/**
 * Created by Next on 17.08.2016.
 */
public interface PatientService {
    Patient save(Patient patient);

    void update(Patient patient);

    List<Patient> getAll();

    Patient get(int id);

    void delete(int id);
}
