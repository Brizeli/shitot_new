package com.shitot.web;

import com.shitot.model.User;
import com.shitot.service.PatientService;
import com.shitot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Next on 21.07.2016.
 */
@Controller
public class RootController {

    @Autowired
    private UserService userService;
    @Autowired
    private PatientService patientService;

    private static Integer appointmentId;
    private static String doctorAlt;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String root(Model model) {
        model.addAttribute("loggedUser", getLoggedUserName());
        model.addAttribute("page", "userHomePage");
        return "index";
    }

    private String getLoggedUserName() {return SecurityContextHolder.getContext().getAuthentication().getName();}

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model,
                        @RequestParam(required = false) boolean error,
                        @RequestParam(required = false) String message) {
        model.addAttribute("error", error);
        model.addAttribute("message", message);
        model.addAttribute("page", "login");
        return "index";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerUser(@RequestParam String newlogin, @RequestParam String newpassword, Model model) {
        User newUser = userService.register(new User(newlogin, newpassword));
        if (newUser != null) {
            model.addAttribute("message", "Registered");
        } else model.addAttribute("message", "User exists!");
        model.addAttribute("loggedUser", getLoggedUserName());
        model.addAttribute("page", "login");
        return "index";
    }

    @RequestMapping(value = "/doctors", method = RequestMethod.GET)
    public String doctorList(Model model, boolean doctorAlt, Integer appointmentId) {
        model.addAttribute("appointmentId", appointmentId);
        model.addAttribute("doctorAlt", doctorAlt);
        model.addAttribute("page", "doctorListDataTable");
        model.addAttribute("loggedUser", getLoggedUserName());
        return "index";
    }

    @RequestMapping(value = "/patients", method = RequestMethod.GET)
    public String patientList(Model model) {
        model.addAttribute("page", "patientListDataTable");
        model.addAttribute("loggedUser", getLoggedUserName());
        return "index";
    }
    @RequestMapping(value = "/appointments",method = RequestMethod.GET)
    public String appointmentList(Model model, @RequestParam int id){
        model.addAttribute("patientId",id);
        model.addAttribute("page","appointmentListDataTable");
        model.addAttribute("loggedUser", getLoggedUserName());
        return "index";
    }
}
