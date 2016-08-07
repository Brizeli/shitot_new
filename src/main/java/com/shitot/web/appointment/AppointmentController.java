package com.shitot.web.appointment;

import com.shitot.model.Doctor;
import com.shitot.model.Specialty;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Iterator;
import java.util.Objects;


@Controller
@RequestMapping(value = "/doctors")
@Scope("session")
public class AppointmentController extends AbstractAppointmentController {

//    @RequestMapping(value = "/create", method = RequestMethod.GET)
//    public String editForCreate(Model model) {
//        fillListsAttributes(model);
//        model.addAttribute("doctor", new Doctor());
//        model.addAttribute("page", "doctorEdit");
//        return "index";
//    }
//
//    @RequestMapping(value = "/update", method = RequestMethod.GET)
//    public String editForUpdate(HttpServletRequest request, Model model) {
//        fillListsAttributes(model);
//        Doctor doctor = super.get(getId(request));
//        model.addAttribute("doctor", doctor);
//        Iterator<Specialty> iterator = doctor.getSpecialties().iterator();
//        model.addAttribute("specialty1", iterator.hasNext() ? iterator.next() : "");
//        model.addAttribute("specialty2", iterator.hasNext() ? iterator.next() : "");
//        model.addAttribute("page", "doctorEdit");
//        return "index";
//    }
//
//    private int getId(HttpServletRequest request) {
//        String paramId = Objects.requireNonNull(request.getParameter("id"));
//        return Integer.valueOf(paramId);
//    }
}
