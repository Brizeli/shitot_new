package com.shitot;

import com.shitot.model.Clinic;
import com.shitot.model.Doctor;
import com.shitot.repository.DoctorsModelCreator;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Next on 12.07.2016.
 */
public class main {
    private static final List<Doctor> DOCTORS = Arrays.asList(
    );

    public static void main(String[] args) {
        try (GenericXmlApplicationContext appCtx = new GenericXmlApplicationContext()) {
            appCtx.load("spring-db.xml");
            appCtx.refresh();
            DoctorsModelCreator dmc =appCtx.getBean( DoctorsModelCreator.class);
//            DoctorRepository dr=appCtx.getBean(DoctorRepository.class);
            dmc.createModel();
        }
    }

    private static void createSchedule(Doctor doc) {
    }

    // unable 2 clinics in same city?
    private static void addClinic(Doctor doc, Clinic clinic) {
        for (Clinic c : doc.getClinics()) {
            if (clinic.getCity().equals(c.getCity())) {
                System.out.println("Can't add clinic. City.");
                return;
            }
        }
//        doc.getClinics().stream().forEach();
    }
}
