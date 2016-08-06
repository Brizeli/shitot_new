package com.shitot.to;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by Next on 29.07.2016.
 */
public class DoctorTo {
    private Integer id;
    @NotEmpty
    private String fullName;
    @Email
    @NotEmpty
    private String email;
    private String telNumber;
    private String telHome;
    private String homeAddress;
    private String lections;
    private String preferential;
    private String comments;

    public DoctorTo() {
    }

    public DoctorTo(Integer id, String fullName, String email, String telNumber, String telHome,
                    String homeAddress, String lections, String preferential, String comments) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.telNumber = telNumber;
        this.telHome = telHome;
        this.homeAddress = homeAddress;
        this.lections = lections;
        this.preferential = preferential;
        this.comments = comments;
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

    public boolean isNew() {
        return id == null;
    }
}
