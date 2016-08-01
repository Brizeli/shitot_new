package com.shitot.model;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.util.Set;

/**
 * Created by sfh on 31-Jul-16.
 */

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
    @ManyToOne
    private User user;
    @ManyToMany
    private Set<Problem> problems;
    @ManyToMany
    private Set<Symptom>symptoms;
    @ManyToOne
    private Doctor doctor;
    @ManyToOne
    private Doctor alternativeDoctor;
    

}
