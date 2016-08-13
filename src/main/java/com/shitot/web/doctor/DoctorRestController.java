package com.shitot.web.doctor;

import com.shitot.model.*;
import com.shitot.service.DoctorService;
import com.shitot.to.DoctorTo;
import com.shitot.web.ExceptionInfoHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Next on 25.07.2016.
 */
@RestController
@RequestMapping("/rest/doctors")
public class DoctorRestController implements ExceptionInfoHandler {

    @Autowired
    DoctorService service;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Doctor> getAll() {
        return service.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Doctor get(@PathVariable int id) {
        return service.get(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<String> createOrUpdate(@Valid DoctorTo doctorTo, BindingResult result) {
        if (result.hasErrors()) {
            StringBuilder sb = new StringBuilder();
            result.getFieldErrors()
                  .forEach(fe -> sb.append(fe.getField()).append(" ").append(fe.getDefaultMessage()).append("<br>"));
            return new ResponseEntity<>(sb.toString(), HttpStatus.UNPROCESSABLE_ENTITY);
        }
        if (doctorTo.isNew()) {
            service.save(doctorTo);
        } else service.update(doctorTo);
        return new ResponseEntity<>(HttpStatus.OK);
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
