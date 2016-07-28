package com.shitot.repository;


import com.shitot.model.*;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.DayOfWeek;
import java.util.*;
@Repository
@Transactional
public class DoctorsModelCreator {

    @PersistenceContext
    private EntityManager em;

    private int NUM_Doctors=10;
    private int NUM_Specs=12;
    private int min_Specs_Doctor = 1;
    private int max_Specs_Doctor = 2;
    private int min_Clinic_Doctor = 1;
    private int max_Clinic_Doctor = 2;
    private int min_workingDays=1;
    private int max_workingDays=6;
    private int min_numintervals=2;
    private int max_numintervals=8;

    private int NUM_City=2;

    public void createModel(){
        int certGen=0;
        int docGen=0;
        int clinGen=0;
        for (int i=0;i<NUM_Doctors;i++){
            Doctor d=new Doctor();
            Certificate cert= new Certificate();
            cert.setName("cert N"+certGen++);
            em.persist(cert);
            d.setCertificate(cert);
            d.setName("Doctor"+docGen++);
            Set<Clinic> cls=new LinkedHashSet<>();
            d.setClinics(cls);
            for(int j=0;j<=min_Clinic_Doctor + Math.random()*(max_Clinic_Doctor-min_Clinic_Doctor+1)-1;j++) {
                Clinic c = new Clinic();
                c.setName("Clinic"+clinGen);
                c.setAddress("address"+clinGen);
                c.setCity("City"+getRndInt(min_Clinic_Doctor,max_Clinic_Doctor));
                em.persist(c);
                c.setDoctor(d);
                List<Slot> slotSet=new ArrayList<>();
                c.setSlots(slotSet);
                for(int j1=0;j1<7;j1++){
                    Slot sl=new Slot();
                    slotSet.add(sl);
                    sl.setDayOfWeek(DayOfWeek.of(j1+1));
                    Set<Interval> ints=new LinkedHashSet<>();
                    for(int j2:getRndIntSet(getRndInt(min_numintervals,max_numintervals),0,Interval.values().length-1)){
                        ints.add(Interval.values()[j2]);
                    }
                    sl.setIntervals(ints);
                    em.persist(sl);
                }
                cls.add(c);
                clinGen++;
            }
            em.persist(d);
        }
    }

    public Iterable<Integer> getRndIntSet(int length, int from,int to){
        //"to" included
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
