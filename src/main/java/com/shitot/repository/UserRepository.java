package com.shitot.repository;

import com.shitot.model.User;

import java.util.List;

/**
 * Created by Next on 26.07.2016.
 */
public interface UserRepository {

//    User login(User user);

    User save(User user);

    boolean delete(int id);

    List<User> getAll();

    User get(int id);
}
