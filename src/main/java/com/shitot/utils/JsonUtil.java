package com.shitot.utils;

import com.shitot.model.Clinic;
import com.shitot.model.Doctor;
import com.shitot.to.DoctorTo;

/**
 * Created by Next on 29.07.2016.
 */
public class JsonUtil {
    public static Doctor updateFromTo(Doctor doctor, DoctorTo doctorTo) {
        doctor.setFullName(doctorTo.getFullName());
        doctor.setLogin(doctorTo.getLogin());
        doctor.setPassword(doctorTo.getPassword());
        doctor.setEmail(doctorTo.getEmail());
        doctor.setTelNumber(doctorTo.getTelNumber());
        doctor.setTelHome(doctorTo.getTelHome());
        doctor.setHomeAddress(doctorTo.getHomeAddress());
        doctor.setLections(doctorTo.getLections());
        doctor.setPreferential(doctorTo.getPreferential());
        doctor.setComments(doctorTo.getComments());
        return doctor;
    }

    public static Doctor createNewFromTo(DoctorTo doctorTo) {
        Doctor doctor = new Doctor(doctorTo.getFullName(), doctorTo.getLogin(), doctorTo.getPassword(),
                                      doctorTo.getEmail(), doctorTo.getTelNumber(), doctorTo.getTelHome(),
                                      doctorTo.getHomeAddress(), doctorTo.getLections(), doctorTo.getPreferential(),
                                      doctorTo.getComments());
        return doctor;
    }

}
