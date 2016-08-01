package com.shitot.web;

import com.shitot.model.User;
import com.shitot.service.DoctorService;
import com.shitot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Next on 21.07.2016.
 */
@Controller
public class RootController {

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String root(Model model) {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        model.addAttribute("loggedUser", name);
        model.addAttribute("page", "userHomePage");
        return "index";
    }

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
    public String registerUser(@RequestParam String newlogin,@RequestParam String newpassword, Model model) {
        User newUser = userService.register(new User(newlogin, newpassword));
        if (newUser != null) {
            model.addAttribute("message", "Registered");
        } else model.addAttribute("message", "User exists!");
        model.addAttribute("page", "login");
        return "index";
    }

    @RequestMapping(value = "/doctors", method = RequestMethod.GET)
    public String doctorList(Model model) {
        model.addAttribute("page", "doctorList");
        return "index";
    }
}
