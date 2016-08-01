package com.shitot.repository;


import com.shitot.model.*;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.DayOfWeek;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;
import java.lang.reflect.*;
@Repository
@Transactional
public class DoctorsModelCreator {

    @PersistenceContext
    private EntityManager em;

    private int NUM_Doctors=10;
    private int NUM_Specs=12;
    private int NUM_Qual=100;
    private int min_Specs_Doctor = 1;
    private int max_Specs_Doctor = 2;
    private int min_Clinic_Doctor = 1;
    private int max_Clinic_Doctor = 2;
    private int min_workingDays=1;
    private int max_workingDays=6;
    private int min_numintervals=2;
    private int max_numintervals=8;
    private String[] Cts={"Raanana","Haifa","Tel Aviv","Hercliya","Gorelovo"};

    private int NUM_City=2;

    public void createModel(){
        int certGen=0;
        int docGen=0;
        int clinGen=0;
        for(int i=0;i<NUM_Specs;i++)em.persist(new Specialty("Spec"+(i+1)));
        for(int i=0;i<NUM_Qual;i++)em.persist(new Qualification("Qual"+(i+1)));
        em.persist(TargetAudience.ADULTS);
        em.persist(TargetAudience.CHILDREN);
        em.persist(TargetAudience.ELDERY);
        em.persist(TargetAudience.TEENS);
        em.persist(Slot.MONDAY);
        em.persist(Slot.TUESDAY);
        em.persist(Slot.WEDNESDAY);
        em.persist(Slot.THURSDAY);
        em.persist(Slot.FRIDAY);
        em.persist(Slot.SATURDAY);
        em.persist(Slot.SUNDAY);
        try{
            Class IntervalC=Class.forName("com.shitot.model.Interval");
            for (Field f:IntervalC.getDeclaredFields()) {
                em.persist(f.get);
            }
        }catch (Exception e){
            e.printStackTrace();
        }


        Slot[] days ={Slot.MONDAY,Slot.TUESDAY,Slot.WEDNESDAY,Slot.THURSDAY,Slot.FRIDAY,Slot.SATURDAY,Slot.SUNDAY};
        TargetAudience[] tga={TargetAudience.ADULTS,TargetAudience.CHILDREN,TargetAudience.ELDERY,TargetAudience.TEENS};
        for (int i=0;i<NUM_Doctors;i++){
            Doctor d=new Doctor();
//            @NotEmpty
//            public String fullName;
            d.setFullName("Doctor"+ ++docGen);
//            @Column(unique = true, nullable = false)
//            @NotEmpty
//            private String login;
            d.setLogin("DoctorLogin"+ docGen);
            //1 of 5 retain null
            if(getRndInt(1,5)!=1)setDoctorsNullableStrings(d,docGen);
            Certificate crt=new Certificate();
            crt.setName("Cert"+ ++certGen);
            em.persist(crt);
            d.setCertificate(crt);
//            @OneToOne(fetch = FetchType.EAGER)
//            private Certificate certificate;
            Set<Qualification> docQ= new LinkedHashSet<>();
            for(int j:getRndIntSet(getRndInt(0,NUM_Qual),1,NUM_Qual))docQ.add(em.find(Qualification.class,"Qual"+j));
            d.setQualifications(docQ);
//            @ManyToMany(fetch = FetchType.EAGER)
//            private Set<Qualification> qualifications;
            Set<Specialty> docS= new LinkedHashSet<>();
            for(int j:getRndIntSet(getRndInt(min_Specs_Doctor,max_Specs_Doctor),1,NUM_Specs))docS.add(em.find(Specialty.class,"Spec"+j));
            d.setSpecialties(docS);
//            @ManyToMany(fetch = FetchType.EAGER)
//            private Set<Specialty> specialties;
            Set<TargetAudience> docA= new LinkedHashSet<>();
            for(int j=0;j<getRndInt(1,4);j++)docA.add(tga[j]);
            d.setTargetAudiences(docA);
//            @ManyToMany(fetch = FetchType.EAGER)
//            private Set<TargetAudience> targetAudiences;
            Set<Clinic> cls=new LinkedHashSet<>();
            for (int j = 0; j < getRndInt(1,2); j++) {
                Clinic cl=new Clinic();
//                private String name;
                cl.setName("Clinic"+ ++clinGen);
//                @NotEmpty
//                private String city;
                cl.setCity(Cts[getRndInt(0,Cts.length-1)]);
//                private String address;
                cl.setAddress("Address"+clinGen);
//                @OneToMany(mappedBy = "clinic", fetch = FetchType.EAGER)
//                private Set<Slot> slots;
                Set<Slot> slots=new LinkedHashSet<>();
                for (int k = 0; k < 7 ; k++) {
                   Slot sl=new Slot();
                    sl.setDayOfWeek(DayOfWeek.of(k));
                    Set<Interval>rvals=new LinkedHashSet<>();
                    for (int l : getRndIntSet(0,0,0)) {

                    }
                    sl.setIntervals(rvals);
                    em.persist(sl);
                    sl.setClinic(cl);
                }
                cl.setSlots(slots);
//
//                @ManyToOne
//                private Doctor doctor;
                em.persist(cl);
                cl.setDoctor(d);
                cls.add(cl);
            }
            d.setClinics(cls);
//
//            @OneToMany(mappedBy = "doctor", fetch = FetchType.EAGER)
//            private Set<Clinic> clinics;

            em.persist(d);
        }
    }

    private void setDoctorsNullableStrings(Doctor d,int docGen){
        //            private String password;
        d.setPassword("DoctorPwd"+ docGen);
//            @Column(unique = true)
//            private String email;
        d.setEmail("DtrEmail"+docGen);
//            private String telNumber;
        d.setTelNumber("telN"+ docGen);
//            private String telHome;
        d.setHomeAddress("DoctorHome"+docGen);
//            private String homeAddress;
        d.setLections("Lection of "+docGen);
//            private String lections;
        d.setPreferential("prefer"+docGen);
//            private String preferential;
        d.setComments("Comm"+docGen);
//            private String comments;


    }

    public Iterable<Integer> getRndIntSet(int length, int from,int to){
        //"to" included // sorted
        if ((to<from)||(length>to-from+1))return null;
        //sorted is very important
        Set<Integer> arr=new TreeSet<>();
        for(int i=0;i<length;i++){
            int k=from+(int)Math.floor(Math.random()*(to-from+1-i));
            for(int j: arr){
                if(j<=k)k++;
            }
            arr.add(k);
        }
        return arr;
    }
    public int getRndInt(int from,int to){
        return getRndIntSet(1,from,to).iterator().next();
    }


}
