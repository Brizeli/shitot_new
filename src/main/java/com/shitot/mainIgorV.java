package com.shitot;

import com.shitot.repository.DoctorRepository;
import com.shitot.repository.DoctorsModelCreator;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Created by Next on 12.07.2016.
 */
public class mainIgorV {

    public static void main(String[] args) {

        try (GenericXmlApplicationContext appCtx = new GenericXmlApplicationContext()) {
            appCtx.load("spring-db.xml");
            appCtx.refresh();
            DoctorsModelCreator dmc = appCtx.getBean(DoctorsModelCreator.class);
            DoctorRepository dr = appCtx.getBean(DoctorRepository.class);
            dmc.createModel();
            System.out.println("end");
        }
    }
}

