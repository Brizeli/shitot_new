package com.shitot.web.patient;

import com.shitot.model.Patient;
import com.shitot.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Next on 17.08.2016.
 */
@RestController
@RequestMapping("/rest/patients")
public class PatientRestController {

    @Autowired
    PatientService service;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Patient> getAllPatients() {
        return service.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int id) {
        service.delete(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Patient getPatient(@PathVariable int id) {
        return service.get(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void createOrUpdate(@Valid Patient patient) {
        if (patient.isNew()) {
            service.save(patient);
        } else service.update(patient);
    }
}
