package com.shitot.web;

import com.shitot.model.*;
import com.shitot.service.DoctorService;
import com.shitot.to.DoctorTo;
import com.shitot.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.MediaType;
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

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Doctor> getAll() {
        List<Doctor> all = service.getAll();
        return all;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Doctor get(@PathVariable int id) {
        return service.get(id);
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

    @RequestMapping(value = "/certs", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Certificate> getAllCertificates() {
        return service.getAllCertificates();
    }

    @RequestMapping(value = "/specs", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Specialty> getAllSpecialties() {
        return service.getAllSpecialties();
    }

    @RequestMapping(value = "/quals", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Qualification> getAllQualifications() {
        return service.getAllQualifications();
    }

    @RequestMapping(value = "/targets", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TargetAudience> getAllTargetAudiences() {
        return service.getAllTargetAudiences();
    }

    @RequestMapping(value = "/by", params = "specialty", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Doctor> getBySpecialty(@RequestParam String specialty) {
        return service.getBySpecialty(specialty);
    }

    @RequestMapping(value = "/by", params = "qualification", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Doctor> getByQualification(@RequestParam String qualification) {
        return service.getByQualification(qualification);
    }

    @RequestMapping(value = "/by", params = "city", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Doctor> getByCity(@RequestParam String city) {
        return service.getByCity(city);
    }
}
