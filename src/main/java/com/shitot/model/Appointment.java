package com.shitot.model;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.util.Set;

@Entity(name="appointment")
public class Appointment extends BaseEntity {

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
    @ManyToMany
    private Set<Problem> problems;
    @ManyToMany
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
}
