package com.shitot.to;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class AppointmentClientDoctorTo {
    private Integer id;
    @NotNull
    private Integer patientId;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate applyDate;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate appointmentDate;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate paymentDate;
    private String paymentAmount;
    private String checkNumber;
    private String description;
    
    private String patName;
    private int age;
    private String telNumber;
    
    private String[] problems = {};
    private String[] symptoms = {};
    
    private int doctorId;
    private int altdoctorId;
    
    private boolean commEstablished;
    private boolean sessionStarted;
    
    public AppointmentClientDoctorTo() {
    }
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public Integer getPatientId() {
        return patientId;
    }
    
    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
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
    
    public boolean isCommEstablished() {
        return commEstablished;
    }
    
    public void setCommEstablished(boolean commEstablished) {
        this.commEstablished = commEstablished;
    }
    
    public boolean isSessionStarted() {
        return sessionStarted;
    }
    
    public void setSessionStarted(boolean sessionStarted) {
        this.sessionStarted = sessionStarted;
    }
    
    public boolean isNew() {
        return id == null;
    }
    
    public String getPatName() {
        return patName;
    }
    
    public void setPatName(String patName) {
        this.patName = patName;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public String getTelNumber() {
        return telNumber;
    }
    
    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }
    
    public int getDoctorId() {
        return doctorId;
    }
    
    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }
    
    public int getAltdoctorId() {
        return altdoctorId;
    }
    
    public void setAltdoctorId(int altdoctorId) {
        this.altdoctorId = altdoctorId;
    }
}
