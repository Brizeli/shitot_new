package com.shitot.web;

import com.shitot.model.User;
import com.shitot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Next on 23.08.2016.
 */
@RestController
@RequestMapping("/rest/users")
public class UserRestController {

    @Autowired
    private UserService service;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getAllUsers() {
        return service.getAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void register(@RequestParam String newlogin, @RequestParam String newpassword, Model model) {
        try {
            service.register(new User(newlogin, newpassword));
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("User with this login already exists");
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int id) {
        service.delete(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public void enabled(@PathVariable("id") int id, @RequestParam("enabled") boolean enabled) {
        service.enable(id, enabled);
    }
}
