package com.shitot.to;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Size;

/**
 * Created by Next on 29.07.2016.
 */
public class DoctorTo {
    private Integer id;
    @NotEmpty
    private String fullName;
    private String login;
    private String password;
    @Email
    @NotEmpty
    private String email;
    private String telNumber;
    private String telHome;
    private String homeAddress;
    @Size(max = 1000, message = " must be shorter than 1000 characters")
    private String lections;
    @Size(max = 1000, message = " must be shorter than 1000 characters")
    private String preferential;
    @Size(max = 1000, message = " must be shorter than 1000 characters")
    private String comments;

    private String specialty1 = "";
    private String specialty2 = "";

    private String[] qualifications = {};
    private String[] targetAudiences = {};

    private String certificate="";

    private MultipartFile file;

    public DoctorTo() {
    }

    public boolean isNew() {
        return id == null;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    public String getTelHome() {
        return telHome;
    }

    public void setTelHome(String telHome) {
        this.telHome = telHome;
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

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }


    public String getSpecialty1() {
        return specialty1;
    }

    public void setSpecialty1(String specialty1) {
        this.specialty1 = specialty1;
    }

    public String getSpecialty2() {
        return specialty2;
    }

    public void setSpecialty2(String specialty2) {
        this.specialty2 = specialty2;
    }

    public String[] getQualifications() {
        return qualifications;
    }

    public void setQualifications(String[] qualifications) {
        this.qualifications = qualifications;
    }

    public String[] getTargetAudiences() {
        return targetAudiences;
    }

    public void setTargetAudiences(String[] targetAudiences) {
        this.targetAudiences = targetAudiences;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
