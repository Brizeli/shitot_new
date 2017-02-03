package com.shitot.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@NamedQueries({
                  @NamedQuery(name = Appointment.ALL_SORTED, query = "select a from appointments a left join fetch a.doctor d " +
                                                                         "left join fetch a.alternativeDoctor ad order by a.applyDate desc"),
//                  @NamedQuery(name = Appointment.BY_PATIENT, query = "select a from appointments a left join fetch a.doctor d " +
//                                                                         "left join fetch a.alternativeDoctor ad where a.patient.id=:id order by a.applyDate desc"),
                  @NamedQuery(name = Appointment.BY_DOCTOR, query = "select a from appointments a where a.doctor.id=:id " +
                                                                        "order by a.applyDate desc"),
                  @NamedQuery(name = Appointment.BY_ALTDOCTOR, query = "select a from appointments a where a.alternativeDoctor.id=:id " +
                                                                           "order by a.applyDate desc"),
                  @NamedQuery(name = Appointment.BY_DOCTOR_AND_ALT, query = "select distinct a from appointments a where a.id in " +
                                                                                "(select a1.id from appointments a1 where a1.alternativeDoctor.id=:id ) or a.id in " +
                                                                                "(select a2.id from appointments a2 where a2.doctor.id=:id ) order by a.applyDate desc"),
                  @NamedQuery(name = Appointment.BY_DOCTOR_BETWEEN_DATES, query = "select a from appointments a where a.doctor.id=:id and " +
                                                                                      "a.applyDate between :startDate and :endDate order by a.applyDate desc")
})
@Entity(name = "appointments")
public class Appointment extends BaseEntity {
    
    public static final String ALL_SORTED = "Appointment.getAllSorted";
    public static final String BY_DOCTOR = "Appointment.getByDoctor";
    public static final String BY_ALTDOCTOR = "Appointment.getByAltDoctor";
    public static final String BY_DOCTOR_AND_ALT = "Appointment.getByDoctorAndAlt";
    //    public static final String BY_PATIENT = "Appointment.getByPatient";
    public static final String BY_DOCTOR_BETWEEN_DATES = "Appointment.getByDoctorBetweenDates";
    
    //    @ManyToOne
//    private Patient patient;
    private String patName;
    private Integer age;
    private String telNumber;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate applyDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate appointmentDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate paymentDate;
    private String paymentAmount;
    private String checkNumber;
    private String description;
    @ManyToOne
    private User user;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Problem> problems;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Symptom> symptoms;
    @ManyToOne
    private Doctor doctor;
    @ManyToOne
    private Doctor alternativeDoctor;
    private boolean commEstablished = false;
    private boolean sessionStarted = false;
    
    public Appointment() {
    }
    
    public Appointment(String patName, Integer age, String telNumber, LocalDate applyDate, LocalDate appointmentDate,
                       LocalDate paymentDate, String paymentAmount, String checkNumber, String description) {
        this.patName = patName;
        this.age = age;
        this.telNumber = telNumber;
        this.applyDate = applyDate;
        this.appointmentDate = appointmentDate;
        this.paymentDate = paymentDate;
        this.paymentAmount = paymentAmount;
        this.checkNumber = checkNumber;
        this.description = description;
    }
    
    public Appointment(LocalDate applyDate, LocalDate appointmentDate, LocalDate paymentDate, String paymentAmount,
                       String checkNumber, String description, boolean commEstablished, boolean sessionStarted) {
        this.applyDate = applyDate;
        this.appointmentDate = appointmentDate;
        this.paymentDate = paymentDate;
        this.paymentAmount = paymentAmount;
        this.checkNumber = checkNumber;
        this.description = description;
        this.commEstablished = commEstablished;
        this.sessionStarted = sessionStarted;
    }
//    public Patient getPatient() {
//        return patient;
//    }
//
//    public void setPatient(Patient patient) {
//        this.patient = patient;
//    }
    
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
    
    public User getUser() {
        return user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    
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
}
