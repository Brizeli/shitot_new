package com.shitot.web.appointment;

import com.shitot.model.Appointment;
import com.shitot.model.Patient;
import com.shitot.to.PatientTo;
import com.shitot.utils.JsonUtil;
import com.shitot.utils.JsonUtilAppointmentPatient;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/rest/patients")
public class AppointmentPatientRestController extends AbstractAppointmentPatientController {

    @RequestMapping(value="/appointment", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Appointment> getAllAppointment() {
        return super.getAllAppointment();
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Patient> getAllPatients() {
        return super.getAllPatients();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int id) {
        System.out.println(id+"arc");
        super.deletePatient(id);
    }
//
//    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//    public Doctor get(@PathVariable int id) {
//        return super.get(id);
//    }
//
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<String> createOrUpdate(@Valid PatientTo patientTo, BindingResult result) {
        if (result.hasErrors()) {
            StringBuilder sb = new StringBuilder();
            result.getFieldErrors()
                  .forEach(fe -> sb.append(fe.getField()).append(" ").append(fe.getDefaultMessage()).append("<br>"));
            return new ResponseEntity<>(sb.toString(), HttpStatus.UNPROCESSABLE_ENTITY);
        }
        if (patientTo.isNew()) {
            super.create(JsonUtilAppointmentPatient.createNewFromTo(patientTo));
        } else super.update(patientTo);
        return new ResponseEntity<>(HttpStatus.OK);
    }
//
//    @RequestMapping(value = "/specs", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//    public List<Specialty> getAllSpecialties() {
//        return service.getAllSpecialties();
//    }
//
//    @RequestMapping(value = "/by", params = "specialty", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//    public List<Doctor> getBySpecialty(@RequestParam String specialty) {
//        return super.getBySpecialty(specialty);
//    }
//
//    @RequestMapping(value = "/by", params = "qualification", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//    public List<Doctor> getByQualification(@RequestParam String qualification) {
//        return super.getByQualification(qualification);
//    }
}
