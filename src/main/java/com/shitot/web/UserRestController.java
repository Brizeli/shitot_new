package com.shitot.web;

import com.shitot.model.User;
import com.shitot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.dao.DataIntegrityViolationException;
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

    @Autowired
    private MessageSource messageSource;

    @RequestMapping
    public List<User> getAll() {
        return service.getAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void register(@RequestParam String newlogin, @RequestParam String newpassword) {
        try {
            service.register(new User(newlogin, newpassword));
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException(messageSource.getMessage("exception.duplicate_user", null,
                LocaleContextHolder.getLocale()));
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int id) {
        service.delete(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public void enabled(@PathVariable int id, @RequestParam boolean enabled) {
        service.enable(id, enabled);
    }
}
