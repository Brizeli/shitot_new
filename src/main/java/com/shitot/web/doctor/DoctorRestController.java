package com.shitot.web.doctor;

import com.shitot.model.Doctor;
import com.shitot.model.Qualification;
import com.shitot.model.Specialty;
import com.shitot.to.DoctorTo;
import com.shitot.utils.JsonUtil;
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
public class DoctorRestController extends AbstractDoctorController {

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Doctor> getAll() {
        return super.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Doctor get(@PathVariable int id) {
        return super.get(id);
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
            super.create(JsonUtil.createNewFromTo(doctorTo));
        } else super.update(doctorTo);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/specs", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Specialty> getAllSpecialties() {
        return service.getAllSpecialties();
    }

    @RequestMapping(value = "/quals", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Qualification> getAllQualifications() {
        return service.getAllQualifications();
    }

    @RequestMapping(value = "/by", params = "specialty", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Doctor> getBySpecialty(@RequestParam String specialty) {
        return super.getBySpecialty(specialty);
    }

    @RequestMapping(value = "/by", params = "qualification", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Doctor> getByQualification(@RequestParam String qualification) {
        return super.getByQualification(qualification);
    }
}
