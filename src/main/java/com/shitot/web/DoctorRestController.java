package com.shitot.web;

import com.shitot.model.*;
import com.shitot.service.DoctorService;
import com.shitot.to.DoctorTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Next on 25.07.2016.
 */
@RestController
@RequestMapping("/rest/doctors")
public class DoctorRestController {

    @Autowired
    DoctorService service;

    @Autowired
    private MessageSource messageSource;

    @RequestMapping
    public List<Doctor> getAll() {
        List<Doctor> all = service.getAll();
        return all;
    }
    
    @RequestMapping("/{id}")
    public Doctor getWithCertificate(@PathVariable int id) {
        return service.getWithCertificate(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void createOrUpdate(@Valid DoctorTo doctorTo) {
        if (doctorTo.isNew()) {
            try {
                service.save(doctorTo);
            } catch (DataIntegrityViolationException e) {
                throw new DataIntegrityViolationException(messageSource.getMessage("exception.duplicate_doctor", null,
                    LocaleContextHolder.getLocale()));
            }
        } else service.update(doctorTo);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int id) {
        service.delete(id);
    }

    @RequestMapping("/certs")
    public List<Certificate> getAllCertificates() {
        return service.getAllCertificates();
    }

    @RequestMapping("/specs")
    public List<Specialty> getAllSpecialties() {
        return service.getAllSpecialties();
    }

    @RequestMapping("/quals")
    public List<Qualification> getAllQualifications() {
        return service.getAllQualifications();
    }

    @RequestMapping("/targets")
    public List<TargetAudience> getAllTargetAudiences() {
        return service.getAllTargetAudiences();
    }

    @RequestMapping(value = "/by", params = "specialty")
    public List<Doctor> getBySpecialty(@RequestParam String specialty) {
        return service.getBySpecialty(specialty);
    }

    @RequestMapping(value = "/by", params = "qualification")
    public List<Doctor> getByQualification(@RequestParam String qualification) {
        return service.getByQualification(qualification);
    }

    @RequestMapping(value = "/by", params = "city")
    public List<Doctor> getByCity(@RequestParam String city) {
        return service.getByCity(city);
    }
}
