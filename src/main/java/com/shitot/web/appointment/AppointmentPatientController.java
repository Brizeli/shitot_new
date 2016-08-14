package com.shitot.web.appointment;

import com.shitot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;


@Controller
@RequestMapping(value = "/patients")
@Scope("session")
public class AppointmentPatientController extends AbstractAppointmentPatientController {
    @Autowired
    private UserService userService;
    private String loggedUserName;
    private Integer appointmentId;
    private String doctorAlt;


    @RequestMapping( method = RequestMethod.GET)
    public String doctorList(Model model) {
        loggedUserName = SecurityContextHolder.getContext().getAuthentication().getName();
        model.addAttribute("page", "patientListDataTable");
        model.addAttribute("loggedUser", loggedUserName);
        return "index";
    }

    @RequestMapping(value = "/appointment/{patientId}", method = RequestMethod.GET)
    public String ListAppointment(@PathVariable int patientId, Model model ) {
        model.addAttribute("patientId",patientId);
        model.addAttribute("page", "appointmentListDataTable");
        model.addAttribute("loggedUser", loggedUserName);
        return "index";
    }
    @RequestMapping(value = "/appointment/doctorList/params/{appId}/{DoctorAlt}", method = RequestMethod.POST)
    public void addParamAppId(@RequestParam int appId,@RequestParam String DoctorAlt){
        appointmentId=appId;
        doctorAlt=DoctorAlt;
        System.out.println("appointmentId: "+appointmentId+", doctorAlt: "+doctorAlt);
    }

    @RequestMapping(value = "/appointment/doctorList", method = RequestMethod.GET)
    public String doctorListAppointment(Model model ) {
        model.addAttribute("page", "doctorListDataTableAppointment");
        model.addAttribute("loggedUser", loggedUserName);

        return "index";
    }

}
