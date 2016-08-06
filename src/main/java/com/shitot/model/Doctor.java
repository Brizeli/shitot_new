package com.shitot.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.*;

/**
 * Created by Next on 12.07.2016.
 */
@NamedQueries({
                  @NamedQuery(name = Doctor.ALL_SORTED, query = "select d from doctors d order by d.fullName"),
                  @NamedQuery(name = Doctor.BY_SPECIALTY, query = "select d from doctors d join d.specialties s where s.name=:specialty order by d.fullName"),
                  @NamedQuery(name = Doctor.BY_QUALIFICATION, query = "select d from doctors d join d.qualifications s where s.name=:qualification order by d.fullName"),
})
@Entity(name = "doctors")
public class Doctor extends UserDoctor {

    public static final String ALL_SORTED = "Doctor.getAllSorted";
    public static final String BY_SPECIALTY = "Doctor.getBySpecialty";
    public static final String BY_QUALIFICATION = "Doctor.getByQualification";

    @NotEmpty
    private String fullName;

    @Column(unique = true)
    @Email
    @NotEmpty
    private String email;
    private String telNumber;
    private String telHome;
    private String homeAddress;
    @Column(length = 1000)
    private String lections;
    @Column(length = 1000)
    private String preferential;
    @Column(length = 1000)
    private String comments;

    @OneToOne(fetch = FetchType.EAGER)
    private Certificate certificate;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Qualification> qualifications;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Specialty> specialties;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<TargetAudience> targetAudiences;

    @OneToMany(mappedBy = "doctor", fetch = FetchType.EAGER)
    private Set<Clinic> clinics;

    public Doctor() {
    }

    public Doctor(Integer id, String fullName, String login, String password, String email, String telNumber,
                  String telHome,
                  String homeAddress, String lections, String preferential, String comments) {
        super(id, login, password);
        this.role = "DOCTOR";
        this.fullName = fullName;
        this.email = email;
        this.telNumber = telNumber;
        this.telHome = telHome;
        this.homeAddress = homeAddress;
        this.lections = lections;
        this.preferential = preferential;
        this.comments = comments;
    }

    public Doctor(String fullName, String login, String password, String email, String telNumber, String telHome,
                  String homeAddress, String lections, String preferential, String comments) {
        this(null, fullName, login, password, email, telNumber, telHome, homeAddress, lections, preferential, comments);
    }

    public Certificate getCertificate() {
        return certificate;
    }

    public void setCertificate(Certificate certificate) {
        this.certificate = certificate;
    }

    public Set<Clinic> getClinics() {
        return clinics;
    }

    public void setClinics(Set<Clinic> clinics) {
        this.clinics = clinics;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getLections() {
        return lections;
    }

    public void setLections(String lections) {
        this.lections = lections;
    }

    public String getPreferential() {
        return preferential;
    }

    public void setPreferential(String preferential) {
        this.preferential = preferential;
    }

    public Set<Qualification> getQualifications() {
        return qualifications;
    }

    public void setQualifications(Set<Qualification> qualifications) {
        this.qualifications = qualifications;
    }

    public Set<Specialty> getSpecialties() {
        return specialties;
    }

    public void setSpecialties(Set<Specialty> specialties) {
        this.specialties = specialties;
    }

    public Set<TargetAudience> getTargetAudiences() {
        return targetAudiences;
    }

    public void setTargetAudiences(Set<TargetAudience> targetAudiences) {
        this.targetAudiences = targetAudiences;
    }

    public String getTelHome() {
        return telHome;
    }

    public void setTelHome(String telHome) {
        this.telHome = telHome;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                   "fullName='" + fullName + '\'' +
                   ", login='" + login + '\'' +
                   ", password='" + password + '\'' +
                   ", email='" + email + '\'' +
                   ", homeAddress='" + homeAddress + '\'' +
                   ", telNumber='" + telNumber + '\'' +
                   ", telHome='" + telHome + '\'' +
                   ", lections='" + lections + '\'' +
                   ", preferential='" + preferential + '\'' +
                   ", comments='" + comments + '\'' +
                   ", role='" + role + '\'' +
                   '}';
    }
}
