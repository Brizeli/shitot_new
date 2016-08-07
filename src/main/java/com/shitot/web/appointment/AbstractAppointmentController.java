package com.shitot.web.appointment;

import com.shitot.model.Appointment;
import com.shitot.model.Doctor;
import com.shitot.service.AppointmentService;
import com.shitot.service.DoctorService;
import com.shitot.to.DoctorTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import java.util.List;


public class AbstractAppointmentController {

    @Autowired
    AppointmentService service;
    @Autowired
    DoctorService serviceDoctor;

    protected Appointment create(Appointment appointment){
        appointment.setId(null);
        return service.save(appointment);
    }

    protected Appointment get(int id) {
        return service.get(id);
    }

    protected void fillListsAttributes(Model model) {
        model.addAttribute("patientList", service.getAllPatients());
        model.addAttribute("problemList", service.getAllProblems());
        model.addAttribute("symptomList", service.getAllSymptoms());
        model.addAttribute("doctorList", serviceDoctor.getAll());
    }

    protected List<Appointment> getAll() {
        return service.getAll();
    }

//    protected void update(DoctorTo doctor) {
//        service.update(doctor);
//    }

    protected List<Doctor> getBySpecialty(String specialty) {
        return serviceDoctor.getBySpecialty(specialty);
    }

    public List<Doctor> getByQualification(String qualification) {
        return serviceDoctor.getByQualification(qualification);
    }
}
