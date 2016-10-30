package com.shitot.web;

import com.shitot.model.Appointment;
import com.shitot.model.Problem;
import com.shitot.model.Symptom;
import com.shitot.service.AppointmentService;
import com.shitot.to.AppointmentTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping("/rest/appointments")
public class AppointmentRestController {

    @Autowired
    AppointmentService service;

    @RequestMapping(value = "/all/patient-{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Appointment> getByPatientId(@PathVariable("id") int patientId) {
        return service.getAll(patientId);
    }

    @RequestMapping(value = "/all/doctor-{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Appointment> getByDoctorId(@PathVariable("id") int doctorId) {
        return service.getByDoctorId(doctorId);
    }

    @RequestMapping(value = "/all/doctor-{id}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Appointment> getByDoctorIdBetweenDates(@PathVariable("id") int doctorId,
                   @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                   @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return service.getByDoctorIdBetweenDates(doctorId, startDate != null ? startDate : LocalDate.of(1, 1, 1),
            endDate != null ? endDate : LocalDate.of(3000, 1, 1));
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
        service.removeDoctor(id, alt);
    }

    @RequestMapping(value = "/{id}/{doctorId}/{alt}", method = RequestMethod.POST)
    public void setDoctor(@PathVariable int id, @PathVariable int doctorId, @PathVariable boolean alt) {
        service.setDoctor(id, doctorId, alt);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void createOrUpdate(@Valid AppointmentTo appointmentTo) {
        if (appointmentTo.isNew()) {
            service.save(appointmentTo);
        } else service.update(appointmentTo);
    }

    @RequestMapping(value = "/android", method = RequestMethod.POST)
    public @ResponseBody void createOrUpdateAndroid(@RequestBody AppointmentTo appointmentTo) {
        createOrUpdate(appointmentTo);
    }
}
