package com.shitot.web.doctor;

import com.shitot.model.Doctor;
import com.shitot.model.TargetAudience;
import com.shitot.service.DoctorService;
import com.shitot.to.DoctorTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import java.util.List;

/**
 * Created by Next on 21.07.2016.
 */
public class AbstractDoctorController {

    @Autowired
    DoctorService service;

    protected Doctor create(DoctorTo doctor){
        doctor.setId(null);
        return service.save(doctor);
    }

    protected Doctor get(int id) {
        return service.get(id);
    }

    protected void fillListsAttributes(Model model) {
        model.addAttribute("specialtyList", service.getAllSpecialties());
        model.addAttribute("expertList", service.getAllExperiences());
        model.addAttribute("certificateList", service.getAllCertificates());
        model.addAttribute("targetAudienceList", service.getAllTargetAudiences());
    }

    protected List<Doctor> getAll() {
        return service.getAll();
    }

    protected void update(DoctorTo doctor) {
        service.update(doctor);
    }

    protected List<Doctor> getBySpecialty(String specialty) {
        return service.getBySpecialty(specialty);
    }

    public List<Doctor> getByQualification(String qualification) {
        return service.getByQualification(qualification);
    }
}
