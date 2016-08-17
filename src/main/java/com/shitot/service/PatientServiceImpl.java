package com.shitot.service;

import com.shitot.model.Patient;
import com.shitot.repository.PatientRepository;
import com.shitot.utils.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Next on 17.08.2016.
 */
@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    PatientRepository repository;

    @Override
    public Patient save(Patient patient) {
        return repository.save(patient);
    }

    @Override
    public void update(Patient patient) {
        Patient saved = repository.save(patient);
        if (saved == null) throw new NotFoundException("Not found patient with id " + patient.getId());
    }

    @Override
    public List<Patient> getAll() {
        return repository.getAll();
    }

    @Override
    public Patient get(int id) {
        return repository.get(id);
    }

    @Override
    public void delete(int id) {
        repository.delete(id);
    }
}
