package com.shitot.utils;

import com.shitot.model.Doctor;
import com.shitot.model.Patient;
import com.shitot.to.DoctorTo;
import com.shitot.to.PatientTo;

/**
 * Created by Next on 29.07.2016.
 */
public class JsonUtilAppointmentPatient {
    public static Patient updateFromTo(Patient patient, PatientTo patientTo) {
        patient.setAge(patientTo.getAge());
        patient.setName(patientTo.getName());
        patient.setTelNumber(patientTo.getTelNumber());
        return patient;
    }

    public static Patient createNewFromTo(PatientTo patientTo) {
        return new Patient(patientTo.getName(),patientTo.getAge(),patientTo.getTelNumber());
    }

}
