package com.shitot.web.doctor;

import com.shitot.model.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Next on 21.07.2016.
 */
@Controller
@RequestMapping(value = "/doctors")
@Scope("session")
public class DoctorController extends AbstractDoctorController {

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String editForCreate(Model model) {
        fillListsAttributes(model);
        model.addAttribute("doctor", new Doctor());
        model.addAttribute("page", "doctorEdit");
        return "index";
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String editForUpdate(HttpServletRequest request, Model model) {
        fillListsAttributes(model);
        Doctor doctor = super.get(getId(request));
        model.addAttribute("doctor", doctor);
        Iterator<Specialty> iterator = doctor.getSpecialties().iterator();
        model.addAttribute("specialty1", iterator.hasNext() ? iterator.next() : "");
        model.addAttribute("specialty2", iterator.hasNext() ? iterator.next() : "");
        model.addAttribute("page", "doctorEdit");
        return "index";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String updateOrCreate(HttpServletRequest request, Doctor doctor) {
        String certificate = request.getParameter("certificate");
        String expert = request.getParameter("expert");
        String specialty1 = request.getParameter("specialty1");
        String specialty2 = request.getParameter("specialty2");
        String[] targets = request.getParameterValues("target");
//        Doctor doctor = new Doctor(id, name, comments, email, lections, login, password, preferential, telAdditional,
//                                      telNumber);
        if (!certificate.isEmpty())
            doctor.setCertificate(new Certificate(certificate));
        if (!expert.isEmpty())
            doctor.setQualifications(Stream.of(expert.split("\\P{LD}+")).map((name) -> new Qualification(name)).collect(Collectors.toSet()));
        if (!specialty1.isEmpty() || !specialty2.isEmpty())
            doctor.setSpecialties(Stream.of(specialty1, specialty2).map(Specialty::new).collect(Collectors.toSet()));
        if (targets!=null)
            doctor.setTargetAudiences(Stream.of(targets).map(TargetAudience::new).collect(Collectors.toSet()));
//        if (doctor.isNew()) super.create(doctor);
//        else super.update(doctor);
        return "redirect:/doctors";
    }

    private int getId(HttpServletRequest request) {
        String paramId = Objects.requireNonNull(request.getParameter("id"));
        return Integer.valueOf(paramId);
    }
}
