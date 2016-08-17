package com.shitot.to;

import com.shitot.model.*;
import org.springframework.format.annotation.DateTimeFormat;

public class AppointmentTo extends BaseEntity {
    private Integer id;
    private Integer patientId;
    @DateTimeFormat
    private String applyDate;
    @DateTimeFormat
    private String appointmentDate;
    @DateTimeFormat
    private String paymentDate;
    private String paymentAmount;
    private String checkNumber;
    private String description;
    private String[] problems;
    private String[] symptoms;
    private int doctorId;
    private int alternativeDoctorId;

    public AppointmentTo() {
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public String getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(String applyDate) {
        this.applyDate = applyDate;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
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

    public String[] getProblems() {
        return problems;
    }

    public void setProblems(String[] problems) {
        this.problems = problems;
    }

    public String[] getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String[] symptoms) {
        this.symptoms = symptoms;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public int getAlternativeDoctorId() {
        return alternativeDoctorId;
    }

    public void setAlternativeDoctorId(int alternativeDoctorId) {
        this.alternativeDoctorId = alternativeDoctorId;
    }
}
