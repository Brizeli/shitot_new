package com.shitot.repository;


import com.shitot.model.*;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.time.LocalDate;
import java.util.*;

@Repository
@Transactional
public class DoctorsModelCreator {

    @PersistenceContext
    private EntityManager em;

    private int maxAppo;
    private int maxSymptoms;
    private int maxProblem;
    private int maxsymbyapp;
    private int maxprobyapp;
    private int numPatient;
    private int numDoctors;
    private int numSpecs;
    private int numQual;
    private int minSpecsDoctor;
    private int maxSpecsDoctor;
    private String[] Cts={"Raanana","Haifa","Tel Aviv","Hercliya","Gorelovo"};

    private int NUM_City=2;

    public DoctorsModelCreator() {
        maxAppo = 1000;
        maxSymptoms = 20;
        maxProblem = 20;
        maxsymbyapp = 4;
        maxprobyapp = 4;
        numPatient = 1400;
        numDoctors =200;
        numSpecs = 12;
        numQual = 40;
        minSpecsDoctor = 1;
        maxSpecsDoctor = 2;
    }


    public void createModel(){
        int certGen=0;
        int docGen=0;
        int clinGen=0;
        for(int i = 0; i< numSpecs; i++)em.persist(new Specialty("Spec"+(i+1)));
        for(int i = 0; i< numQual; i++)em.persist(new Qualification("Qual"+(i+1)));
        em.persist(TargetAudience.ADULTS);
        em.persist(TargetAudience.CHILDREN);
        em.persist(TargetAudience.ELDERY);
        em.persist(TargetAudience.TEENS);
//        for (int i = 0; i < 24; i++) em.persist(new Interval(i));
        TargetAudience[] tga={TargetAudience.ADULTS,TargetAudience.CHILDREN,TargetAudience.ELDERY,TargetAudience.TEENS};
        for (int i = 0; i< numDoctors; i++){
            Doctor d=new Doctor();
            d.setFullName("Doctor"+ ++docGen);
            d.setLogin("DoctorLogin"+ docGen);
            setDoctorsNullableStrings(d,docGen);
            Certificate crt=new Certificate();
            crt.setName("Cert"+ ++certGen);
            em.persist(crt);
            d.setCertificate(crt);
            Set<Qualification> docQ= new LinkedHashSet<>();
            for(int j:getRndIntSet(getRndInt(0, numQual),1, numQual))docQ.add(em.find(Qualification.class,"Qual"+j));
            d.setQualifications(docQ);
            Set<Specialty> docS= new LinkedHashSet<>();
            for(int j:getRndIntSet(getRndInt(minSpecsDoctor, maxSpecsDoctor),1, numSpecs))docS.add(em.find(Specialty.class,"Spec"+j));
            d.setSpecialties(docS);
            Set<TargetAudience> docA= new LinkedHashSet<>();
            for(int j:getRndIntSet(getRndInt(1,4),0,3))docA.add(tga[j]);
            d.setTargetAudiences(docA);
            Set<Clinic> cls=new LinkedHashSet<>();
            for (int j : getRndIntSet( getRndInt(1,2),0,Cts.length-1)) {
                Clinic cl=new Clinic();
                cl.setName("Clinic"+ ++clinGen);
                cl.setCity(Cts[j]);
                cl.setAddress("Address"+clinGen);
                Map<Integer, String> slots=new HashMap<>();
                for (int k :getRndIntSet(getRndInt(1,7),0,6)) {
                    slots.put(k, "7 - 13");
                }
                cl.setSlots(slots);
                em.persist(cl);
                cl.setDoctor(d);
                cls.add(cl);
            }
            d.setClinics(cls);
            em.persist(d);
        }
        createModelAppo();
        createUsers();
    }

    private void createUsers() {
        User oper1=new User("oper1","123");
        oper1.setEnabled(true);
        oper1.setRole("USER");
        em.persist(oper1);
//        CREATE VIEW users_doctors AS SELECT login,password,enabled,role FROM users UNION SELECT login,password,enabled,role FROM doctors;
    }

    public void createModelAppo(){
        int symGen=0;
        for (int i = 0; i < maxSymptoms ; i++) {
            Symptom s = new Symptom("Symptom"+ ++symGen);
            em.persist(s);
        }
        int proGen=0;
        for (int i = 0; i < maxProblem ; i++) {
            Problem s = new Problem("Problem"+ ++proGen);
            em.persist(s);
        }
        int patGen=0;
        for (int i = 0; i < numPatient ; i++) {
            Patient s = new Patient("Patient"+ ++patGen,getRndInt(1,80),"052XXXXXXX");
            em.persist(s);
        }
        for (int i = 0; i < maxAppo ; i++) {
            Appointment appo=new Appointment(
                    LocalDate.parse(getRndInt(2000,2016)+"-0"+getRndInt(1,9)+"-"+getRndInt(10,28)),
                    LocalDate.parse(getRndInt(2000,2016)+"-0"+getRndInt(1,9)+"-"+getRndInt(10,28)),
                    LocalDate.parse(getRndInt(2000,2016)+"-0"+getRndInt(1,9)+"-"+getRndInt(10,28)),
                    "300$","43","blah-blah-blah", false, false
            );
            Set<Problem> problems=new LinkedHashSet<>();
            Set<Symptom>symptoms=new LinkedHashSet<>();
            for (int j:getRndIntSet(getRndInt(1,maxsymbyapp),1,maxSymptoms)){
                symptoms.add(em.find(Symptom.class,"Symptom"+j));
            }
            appo.setSymptoms(symptoms);
            for (int j:getRndIntSet(getRndInt(1,maxprobyapp),1,maxProblem)){
                problems.add(em.find(Problem.class,"Problem"+j));
            }
            appo.setProblems(problems);
            String ss="select d from doctors d where d.email='DtrEmail"+getRndInt(1, numDoctors)+"@gmail.com'";
            Query q = em.createQuery(ss);
//            System.out.println(ss);
            Doctor d = (Doctor)q.getSingleResult();
            appo.setDoctor(d);
            if(getRndInt(1,7)!=1){
                q = em.createQuery("select d from doctors d where d.email='DtrEmail"+getRndInt(1, numDoctors)+"@gmail.com'");
                d = (Doctor)q.getSingleResult();
                appo.setAlternativeDoctor(d);
            }
            q = em.createQuery("select d from patients d where d.name='Patient"+ getRndInt(1,numPatient)+"'");
            Patient p=(Patient)q.getSingleResult();
            appo.setPatient(p);
            em.persist(appo);
        }
    }

    private void setDoctorsNullableStrings(Doctor d,int docGen){
        d.setPassword("DoctorPwd"+ docGen);
        d.setEmail("DtrEmail"+docGen+"@gmail.com");
        d.setTelNumber("telN"+ docGen);
        d.setHomeAddress("DoctorHome"+docGen);
        d.setLections("Lection of "+docGen);
        d.setPreferential("prefer"+docGen);
        d.setComments("Comm"+docGen);
        d.setRole("DOCTOR");
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
