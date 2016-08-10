package com.shitot.web.appointment;

import com.shitot.model.Appointment;
import com.shitot.model.Doctor;
import com.shitot.model.Patient;
import com.shitot.service.AppointmentPatientService;
import com.shitot.service.DoctorService;
import com.shitot.to.PatientTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import java.util.List;


public class AbstractAppointmentPatientController {

    @Autowired
    AppointmentPatientService service;
    @Autowired
    DoctorService serviceDoctor;

    protected Appointment create(Appointment appointment){
        appointment.setId(null);
        return service.save(appointment);
    }
    protected Patient create(Patient patient){
        patient.setId(null);
        return service.save(patient);
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

    protected List<Appointment> getAllAppointment() {
        return service.getAll();
    }
    protected List<Patient> getAllPatients(){
        return service.getAllPatients();
    }
    protected void update(PatientTo patientTo) {
        service.update(patientTo);
    }

    protected void deletePatient(int id){
        service.deletePatient(id);
    }
    protected List<Doctor> getBySpecialty(String specialty) {
        return serviceDoctor.getBySpecialty(specialty);
    }

    public List<Doctor> getByQualification(String qualification) {
        return serviceDoctor.getByQualification(qualification);
    }
}
