package com.shitot;

import com.shitot.model.*;
import com.shitot.repository.DoctorRepository;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.*;

/**
 * Created by Next on 12.07.2016.
 */
public class main {
    private static final List<Doctor> DOCTORS = Arrays.asList(
    );

    public static void main(String[] args) {
//        Doctor doctor = new Doctor(1, "Doctor", "login", "password", "email", "12345684", null, null, null, null, null);
//        System.out.println(doctor);
        try (GenericXmlApplicationContext appCtx = new GenericXmlApplicationContext()) {
            appCtx.load("spring-db.xml");
//            appCtx.load("spring-app.xml", "spring-db.xml", "spring-mvc.xml");
            appCtx.refresh();
            DoctorRepository repository = appCtx.getBean(DoctorRepository.class);
            repository.setSpecialties(3, "Specialty1");
//            Doctor doctor1 = new Doctor(1, "doctor1", "doc1", "1", "doc1@mail", "123456789", "654321", "homeaddress1",
//                                          "lections1", "prefers1", "comments1");
//            Doctor doctor2 = new Doctor(2, "doctor2", "doc2", "2", "doc2@mail", "223456789", "654322", "homeaddress2",
//                                          "lections2", "prefers2", "comments2");
//            repository.save(doctor1);
//            repository.save(doctor2);
//            repository.setCertificate(doctor1.getId(), "Certificate1");
//            repository.setCertificate(doctor2.getId(), "Certificate2");
//            repository.setSpecialties(doctor1.getId(), "Specialty1");
//            repository.setSpecialties(doctor2.getId(), "Specialty1", "Specialty3");
//            repository.setTargetAudiences(doctor1.getId(), "Children", "Teens", "Eldery");
//            repository.setTargetAudiences(doctor2.getId(), "Children", "Adults", "Eldery");
//            repository.setQualifications(doctor1.getId(), "Qualification1");
//            repository.setQualifications(doctor2.getId(), "Qualification1","Qualification2");
        }
    }

    private static void createSchedule(Doctor doc) {
    }

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
