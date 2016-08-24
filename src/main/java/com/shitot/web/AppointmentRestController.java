package com.shitot.web;

import com.shitot.model.Appointment;
import com.shitot.model.Problem;
import com.shitot.model.Symptom;
import com.shitot.service.AppointmentService;
import com.shitot.to.AppointmentTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/rest/appointments")
public class AppointmentRestController {

    @Autowired
    AppointmentService service;

    @RequestMapping(value = "/all/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Appointment> getAppointments(@PathVariable("id") int patientId) {
        return service.getAll(patientId);
    }

    @RequestMapping(value = "/symptoms", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Symptom> getAllSymptoms() {
        List<Symptom> allSymptoms = service.getAllSymptoms();
        return allSymptoms;
    }

    @RequestMapping(value = "/problems", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Problem> getAllProblems() {
        List<Problem> allProblems = service.getAllProblems();
        return allProblems;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Appointment get(@PathVariable int id) {
        return service.get(id);
    }

    @RequestMapping(value = "/{id}/{alt}", method = RequestMethod.DELETE)
    public void removeDoctor(@PathVariable int id, @PathVariable boolean alt) {
        service.removeDoctor(id,alt);
    }

    @RequestMapping(value = "/{id}/{doctorId}/{alt}", method = RequestMethod.POST)
    public void changeDoctor(@PathVariable int id, @PathVariable int doctorId, @PathVariable boolean alt) {
        service.setDoctor(id, doctorId, alt);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void createOrUpdate(@Valid AppointmentTo appointmentTo) {
        if (appointmentTo.isNew()) {
            service.save(appointmentTo);
        } else service.update(appointmentTo);
    }
}
