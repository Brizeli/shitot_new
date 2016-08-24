package com.shitot.service;

import com.shitot.model.User;
import com.shitot.repository.UserRepository;
import com.shitot.utils.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Next on 26.07.2016.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository repository;

    @Override
    public void register(User user) {
        repository.save(user);
    }

    @Override
    public void delete(int id) {
        if (!repository.delete(id)) throw new NotFoundException("Not found user with id=" + id);
    }

    @Override
    public List<User> getAll() {
        return repository.getAll();
    }

    @Override
    @Transactional
    public void enable(int id, boolean enabled) {
        User user = get(id);
        user.setEnabled(enabled);
        repository.save(user);
    }

    @Override
    public User get(int id) {
        return repository.get(id);
    }
}
