package com.shitot.web.clinic;

import com.shitot.model.Clinic;
import com.shitot.model.Doctor;
import com.shitot.model.Slot;
import com.shitot.service.ClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Oleg on 03.08.2016.
 */
@RestController
@RequestMapping("/rest/clinics")
public class ClinicRestController {

    @Autowired
    ClinicService service;

//    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//    public String getOK(@RequestParam("param1") Integer iParam) {
//        if (iParam == null)
//            return "null";
//        return String.valueOf(iParam + 1);
//    }

    @RequestMapping(value = "/slots/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Slot> getSlots(@PathVariable int id) {
        return service.getSlots(id);
    }

    @RequestMapping(value = "/dayslot/{dayofweek}/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Slot getDaySlot(@PathVariable int dayofweek, @PathVariable int id) {
        return service.getDaySlot(dayofweek, id);
    }

    @RequestMapping(value = "/bydoctor/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Clinic> getByDoctor(@PathVariable int id) {
        return service.getByDoctor(id);
    }

    @RequestMapping(value = "/doctorbycity/{city}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Doctor> getDoctorByCity(@PathVariable String city) {
        return service.getDoctorByCity(city);
    }

    @RequestMapping(value = "/doctorbycityspecialty/{city}/{specialty}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Doctor> getByCitySpecialty(@PathVariable String city, @PathVariable String specialty) {
        return service.getDoctorByCitySpecialty(city, specialty);
    }

    @RequestMapping(value = "/allcities", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> getAllCities() {
        return service.getAllCities();
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Clinic get(@PathVariable int id) {
        return service.get(id);
    }

    @RequestMapping(value = "/setslot/{day}/{id}/{hours}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String setSlot(@PathVariable int day,@PathVariable int id, @PathVariable String hours  ) {
        String hoursString[] = hours.split(",");
        int hourseInt[] = new int[hoursString.length];
        for(int i = 0; i < hoursString.length; ++i)
            hourseInt[i] = Integer.parseInt(hoursString[i]);
        service.setSlot(day, id, hourseInt);
        return "OK";
    }

    @RequestMapping(value = "/deleteslot/{day}/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String deleteSlot(@PathVariable int day,@PathVariable int id) {
        service.deleteSlot(day, id);
        return "OK";
    }

    @RequestMapping(value = "/deleteclinic/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String deleteClinic(@PathVariable int id) {
        service.deleteClinic(id);
        return "OK";
    }

    @RequestMapping(value = "/setclinic", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String setClinic(@RequestParam("id") Integer id, @RequestParam("name") String name,
            @RequestParam("city") String city, @RequestParam("address") String address,
            @RequestParam("doctorId") int doctorId) {
        service.setClinic(id, name, city, address, doctorId);
        return id + "<br>" + city + "<br>" + name + "<br>" + address;
    }
}
