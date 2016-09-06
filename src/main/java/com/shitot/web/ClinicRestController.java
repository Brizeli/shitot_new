package com.shitot.web;

import com.shitot.model.Clinic;
import com.shitot.service.ClinicService;
import com.shitot.to.SlotsTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * Created by Oleg on 03.08.2016.
 */
@RestController
@RequestMapping("/rest/clinics")
public class ClinicRestController {

    @Autowired
    private ClinicService service;

    @RequestMapping(value = "/cities", method = RequestMethod.GET)
    public List<String> getAllCities() {return service.getAllCities();}

    @RequestMapping(value = "/{id}/{doctorId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Clinic get(@PathVariable int id, @PathVariable int doctorId) {
        return service.get(id, doctorId);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void createOrUpdate(@Valid Clinic clinic, @RequestParam Integer doctorId) {
        if (clinic.isNew()) {
            service.save(clinic, doctorId);
        } else service.update(clinic, doctorId);
    }

    @RequestMapping(value = "/{id}/{doctorId}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int id, @PathVariable int doctorId) {
        service.delete(id, doctorId);
    }

    @RequestMapping(value = "/setslots", method = RequestMethod.POST)
    public void updateSlots(@Valid SlotsTo slotsTo) {
        service.setSlots(slotsTo);
    }

    @RequestMapping(value = "/{id}/slots", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<Integer, String> getSlots(@PathVariable int id) {
        return service.getSlots(id);
    }
///////////////////////////////////////////////////////////////////////////////


    @RequestMapping(value = "/setclinic", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String setClinic(@RequestParam("id") Integer id, @RequestParam("name") String name,
                            @RequestParam("city") String city, @RequestParam("address") String address,
                            @RequestParam("doctorId") int doctorId) {
        service.setClinic(id, name, city, address, doctorId);
        return id + "<br>" + city + "<br>" + name + "<br>" + address;
    }


//    @RequestMapping(value = "/dayslot/{dayofweek}/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//    public Slot getDaySlot(@PathVariable int dayofweek, @PathVariable int id) {
//        return service.getDaySlot(dayofweek, id);
//    }
//
//    @RequestMapping(value = "/setslot/{day}/{id}/{hours}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//    public String setSlot(@PathVariable int day, @PathVariable int id, @PathVariable String hours) {
//        String hoursString[] = hours.split(",");
//        int hourseInt[] = new int[hoursString.length];
//        for (int i = 0; i < hoursString.length; ++i)
//            hourseInt[i] = Integer.parseInt(hoursString[i]);
//        service.setSlot(day, id, hourseInt);
//        return "OK";
//    }
//
//    @RequestMapping(value = "/deleteslot/{day}/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//    public String deleteSlot(@PathVariable int day, @PathVariable int id) {
//        service.deleteSlot(day, id);
//        return "OK";
//    }
}
