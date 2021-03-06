package com.shitot.web;

import com.shitot.model.Appointment;
import com.shitot.model.Problem;
import com.shitot.model.Symptom;
import com.shitot.service.AppointmentService;
import com.shitot.to.AppointmentClientDoctorTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/rest/appointments")
public class AppointmentRestController {
    
    @Autowired
    AppointmentService service;
    
    @RequestMapping
    public List<Appointment> getAll() {
        return service.getAll();
    }
    
    @RequestMapping(value = "/filter", method = RequestMethod.POST)
    public List<Appointment> getBetweenDates(@RequestParam(required = false)
                                             @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate startDate,
                                             @RequestParam(required = false)
                                             @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate endDate) {
        return service.getBetweenDates(startDate != null ? startDate : LocalDate.of(1, 1, 1),
            endDate != null ? endDate : LocalDate.of(3000, 1, 1));
    }
    
    @RequestMapping(value = "/bydoctor", params = "doctorId")
    public List<Appointment> getByDoctorId(@RequestParam int doctorId) {
        return service.getByDoctorId(doctorId);
    }
    
    @RequestMapping(value = "/bydoctordates", method = RequestMethod.POST)
    public List<Appointment> getByDoctorIdBetweenDates(@RequestParam Integer doctorId,
                                                       @RequestParam(required = false)
                                                       @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate startDate,
                                                       @RequestParam(required = false)
                                                       @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate endDate) {
        return service.getByDoctorIdBetweenDates(doctorId, startDate != null ? startDate : LocalDate.of(1, 1, 1),
            endDate != null ? endDate : LocalDate.of(3000, 1, 1));
    }
    
    @RequestMapping("/symptoms")
    public List<Symptom> getAllSymptoms() {
        return service.getAllSymptoms();
    }
    
    @RequestMapping("/problems")
    public List<Problem> getAllProblems() {
        return service.getAllProblems();
    }
    
    @RequestMapping("/{id}")
    public Appointment get(@PathVariable int id) {
        return service.get(id);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int id) {
        service.delete(id);
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
    public void createOrUpdate(@Valid AppointmentClientDoctorTo to) {
        if (to.isNew()) service.save(to);
        else service.update(to);
    }
    
    @RequestMapping(value = "/android", method = RequestMethod.POST)
    public void updateAndroid(@RequestBody AppointmentClientDoctorTo to) {
        service.update(to);
    }
    
    @RequestMapping("/android/{id}")
    public Appointment getAndroid(@PathVariable int id) {
        return service.get(id);
    }
}
