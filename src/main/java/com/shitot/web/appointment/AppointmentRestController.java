package com.shitot.web.appointment;

import com.shitot.model.Appointment;
import com.shitot.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/rest/appointments")
public class AppointmentRestController {

    @Autowired
    AppointmentService service;

    @RequestMapping(value = "/all/{id}", method = RequestMethod.GET)
    public List<Appointment> getAppointments(@PathVariable("id") int patientId) {
        List<Appointment> all = service.getAll(patientId);
        return all;
    }

    @RequestMapping(value = "/appointment", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Appointment> getAllAppointments() {
        return service.getAll();
    }

    @RequestMapping(value = "/{id}/{doctorAlt}", method = RequestMethod.DELETE)
    public void removeDoctor(@PathVariable("id") int appointmentId, @PathVariable boolean doctorAlt) {
        if (!doctorAlt) service.removeDoctor(appointmentId);
        else service.removeAltDoctor(appointmentId);
    }

    @RequestMapping(value = "/{appId}/{docAlt}/{doctorId}", method = RequestMethod.POST)
    public void changeDoctor(@PathVariable int doctorId, @PathVariable int appId, @PathVariable boolean docAlt) {
        if (!docAlt) {
            service.setDoctorToAppointment(appId, doctorId);
        } else {
            service.setAltDoctorToAppointment(appId, doctorId);
        }
    }
}
