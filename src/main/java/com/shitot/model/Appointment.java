package com.shitot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;
@NamedQueries({
        @NamedQuery(name = Appointment.ALL_SORTED, query = "select a from appointments a order by a.applyDate desc"),
        @NamedQuery(name = Appointment.BY_DOCTOR, query = "select a from appointments a join a.doctor d where d.id=:id order by a.applyDate desc"),
        @NamedQuery(name = Appointment.BY_ALTDOCTOR, query = "select a from appointments a join a.alternativeDoctor d where d.id=:id order by a.applyDate desc"),
        @NamedQuery(name = Appointment.BY_PATIENT, query = "select a from appointments a join a.patient d where d.id=:id order by a.applyDate desc"),
        @NamedQuery(name = Appointment.BY_DOCTOR_AND_ALT, query = "select distinct a from appointments a where a.id in " +
                "(select a1.id from appointments a1 join a1.alternativeDoctor d where d.id=:id ) or a.id in " +
                "(select a2.id from appointments a2 join a2.doctor d1 where d1.id=:id ) order by a.applyDate desc")
})
@Entity(name="appointments")
public class Appointment extends BaseEntity {

    public static final String ALL_SORTED = "Appointment.getAllSorted";
    public static final String BY_DOCTOR = "Appointment.getByDoctor";
    public static final String BY_ALTDOCTOR = "Appointment.getByAltDoctor";
    public static final String BY_DOCTOR_AND_ALT = "Appointment.getByDoctorAndAlt";
    public static final String BY_PATIENT = "Appointment.getByPatient";

    @ManyToOne
    private Patient patient;
    private LocalDate applyDate;
    private LocalDate appointmentDate;
    private LocalDate paymentDate;
    private String paymentAmount;
//    private Currency paymentAmount;
    private String checkNumber;
    private String description;
//    @ManyToOne
//    private User user;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Problem> problems;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Symptom>symptoms;
    @ManyToOne
    private Doctor doctor;
    @ManyToOne
    private Doctor alternativeDoctor;

    public Appointment() {
    }

    public Appointment(LocalDate applyDate, LocalDate appointmentDate, LocalDate paymentDate, String paymentAmount, String checkNumber, String description) {
        this.applyDate = applyDate;
        this.appointmentDate = appointmentDate;
        this.paymentDate = paymentDate;
        this.paymentAmount = paymentAmount;
        this.checkNumber = checkNumber;
        this.description = description;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public LocalDate getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(LocalDate applyDate) {
        this.applyDate = applyDate;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(String paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public String getCheckNumber() {
        return checkNumber;
    }

    public void setCheckNumber(String checkNumber) {
        this.checkNumber = checkNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public User getUser() {
//        return user;
//    }

//    public void setUser(User user) {
//        this.user = user;
//    }

    public Set<Problem> getProblems() {
        return problems;
    }

    public void setProblems(Set<Problem> problems) {
        this.problems = problems;
    }

    public Set<Symptom> getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(Set<Symptom> symptoms) {
        this.symptoms = symptoms;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Doctor getAlternativeDoctor() {
        return alternativeDoctor;
    }

    public void setAlternativeDoctor(Doctor alternativeDoctor) {
        this.alternativeDoctor = alternativeDoctor;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "patient=" + patient +
                ", applyDate=" + applyDate +
                ", appointmentDate=" + appointmentDate +
                ", paymentDate=" + paymentDate +
                ", paymentAmount='" + paymentAmount + '\'' +
                ", checkNumber='" + checkNumber + '\'' +
                ", description='" + description + '\'' +
                ", problems=" + problems +
                ", symptoms=" + symptoms +
                ", doctor=" + doctor +
                ", alternativeDoctor=" + alternativeDoctor +
                '}';
    }
}
