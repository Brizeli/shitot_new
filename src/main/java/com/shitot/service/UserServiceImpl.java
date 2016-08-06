package com.shitot.service;

import com.shitot.model.User;
import com.shitot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by Next on 26.07.2016.
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository repository;

    @Override
    public User register(User user) {
        User result = null;
        try {
            result = repository.register(user);
        } catch (Exception e) {
        }
        return result;
    }
}
