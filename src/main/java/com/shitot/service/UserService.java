package com.shitot.service;

import com.shitot.model.User;

import java.util.List;

/**
 * Created by Next on 26.07.2016.
 */
public interface UserService {
    void register(User user);

    void delete(int id);

    List<User> getAll();

    void enable(int id, boolean enabled);

    User get(int id);
}
