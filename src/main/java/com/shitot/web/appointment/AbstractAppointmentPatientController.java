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
    protected Integer appointmentId;
    protected String doctorAlt;

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


    protected List<Appointment> getAllAppointment() {
        return service.getAll();
    }
    protected List<Appointment> getAllAppointment(int patientId) {
        return service.getAll(patientId);
    }
    protected List<Patient> getAllPatients(){
        return service.getAllPatients();
    }
    protected void update(PatientTo patientTo) {
        service.update(patientTo);
    }
    protected Patient getPatient(int id){
        return service.getPatient(id);
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

    public void removeDoctorFromAppointment(int appointmentId) {
        service.removeDoctor(appointmentId);
    }

    public void removeAltDoctorFromAppointment(int appointmentId) {
        service.removeAltDoctor(appointmentId);
    }

    public void setDoctorToAppointment(int appointmentId, int doctorId) {
        service.setDoctorToAppointment(appointmentId, doctorId);
    }

    public void setAltDoctorToAppointment(int appointmentId, int doctorId) {
        service.setAltDoctorToAppointment(appointmentId, doctorId);
    }
}
