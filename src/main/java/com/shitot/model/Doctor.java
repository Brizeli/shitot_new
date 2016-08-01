package com.shitot.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.*;

/**
 * Created by Next on 12.07.2016.
 */
@NamedQueries({
                  @NamedQuery(name = Doctor.ALL_SORTED, query = "select d from doctors d order by d.fullName")
})
@Entity(name = "doctors")
public class Doctor extends BaseEntity {

    public static final String ALL_SORTED = "Doctor.getAllSorted";

    @NotEmpty
    public String fullName;

    @Column(unique = true, nullable = false)
    @NotEmpty
    private String login;
    private String password;
    @Column(unique = true)
    private String email;
    private String telNumber;
    private String telHome;
    private String homeAddress;
    private String lections;
    private String preferential;
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

    public Doctor(Integer id, String fullName, String login, String password, String email, String telNumber, String telHome,
                  String homeAddress, String lections, String preferential, String comments) {
        super(id);
        this.fullName = fullName;
        this.login = login;
        this.password = password;
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
        this(null, comments, email, lections, login, fullName, password, telNumber, homeAddress, preferential, telHome);
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
                   '}';
    }
}
