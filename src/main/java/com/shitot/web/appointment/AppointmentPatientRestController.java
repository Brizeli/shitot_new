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
//        System.out.println(id+"arc");
        super.deletePatient(id);
    }
    @RequestMapping(value = "/appointmentDoctor/{appointmentId}", method = RequestMethod.DELETE)
    public void removeDoctor(@PathVariable int appointmentId) {
        super.removeDoctorFromAppointment(appointmentId);
    }
    @RequestMapping(value = "/appointmentDoctor/{doctorId}/{appId}/{docAlt}", method = RequestMethod.POST)
    public ResponseEntity<String> changeDoctor(@PathVariable int doctorId,@PathVariable int appId,@PathVariable String docAlt) {
        doctorAlt=docAlt;
        appointmentId=appId;
        if(doctorAlt.equals("Doctor")) {
            super.setDoctorToAppointment(appointmentId,doctorId);
            System.out.println(appointmentId+" - "+doctorId);

        }else{
            super.setAltDoctorToAppointment(appointmentId,doctorId);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @RequestMapping(value = "/appointmentAltDoctor/{appointmentId}", method = RequestMethod.DELETE)
    public void removeAltDoctor(@PathVariable int appointmentId) {
        super.removeAltDoctorFromAppointment(appointmentId);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Patient getPatient(@PathVariable int id) {
//        System.out.println(id+"arc");
        return super.getPatient(id);
    }
    @RequestMapping(value = "/appointment/{patientId}", method = RequestMethod.GET)
    public List<Appointment> getAppointments(@PathVariable int patientId) {
        return super.getAllAppointment(patientId);
    }

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

}
