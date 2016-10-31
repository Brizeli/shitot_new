package com.shitot.utils;

import com.shitot.model.Appointment;
import com.shitot.model.Doctor;
import com.shitot.to.AppointmentTo;
import com.shitot.to.DoctorTo;

/**
 * Created by Next on 29.07.2016.
 */
public class JsonUtil {
    public static Doctor updateFromTo(Doctor doctor, DoctorTo doctorTo) {
        doctor.setFullName(doctorTo.getFullName());
//        doctor.setLogin(doctorTo.getLogin());
//        doctor.setPassword(doctorTo.getPassword());
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
        return new Doctor(doctorTo.getFullName(), doctorTo.getLogin(), doctorTo.getPassword(),
                                      doctorTo.getEmail(), doctorTo.getTelNumber(), doctorTo.getTelHome(),
                                      doctorTo.getHomeAddress(), doctorTo.getLections(), doctorTo.getPreferential(),
                                      doctorTo.getComments());
    }

    public static Appointment createNewFromTo(AppointmentTo appointmentTo) {
        return new Appointment(appointmentTo.getApplyDate(), appointmentTo.getAppointmentDate(),
                                                     appointmentTo.getPaymentDate(), appointmentTo.getPaymentAmount(),
                                                     appointmentTo.getCheckNumber(), appointmentTo.getDescription(),
                appointmentTo.isCommEstablished(), appointmentTo.isSessionStarted());
    }

    public static Appointment updateFromTo(Appointment appointment, AppointmentTo appointmentTo) {
        appointment.setApplyDate(appointmentTo.getApplyDate());
        appointment.setAppointmentDate(appointmentTo.getAppointmentDate());
        appointment.setPaymentDate(appointmentTo.getPaymentDate());
        appointment.setPaymentAmount(appointmentTo.getPaymentAmount());
        appointment.setCheckNumber(appointmentTo.getCheckNumber());
        appointment.setDescription(appointmentTo.getDescription());
        appointment.setCommEstablished(appointmentTo.isCommEstablished());
        appointment.setSessionStarted(appointmentTo.isSessionStarted());
        return appointment;
    }
}
