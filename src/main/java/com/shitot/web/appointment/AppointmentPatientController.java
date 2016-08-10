package com.shitot.web.appointment;

import com.shitot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping(value = "/patients")
@Scope("session")
public class AppointmentPatientController extends AbstractAppointmentPatientController {
    @Autowired
    private UserService userService;
    private String loggedUserName;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String doctorList(Model model) {
        loggedUserName = SecurityContextHolder.getContext().getAuthentication().getName();
        model.addAttribute("page", "patientListDataTable");
        model.addAttribute("loggedUser", loggedUserName);
        return "index";
    }

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