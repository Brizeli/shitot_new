package com.shitot.repository;

import com.shitot.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Next on 26.07.2016.
 */
@Repository
@Transactional(readOnly = true)
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public User login(User user) {
        User result = em.createNamedQuery(User.GET_BY_LOGIN, User.class)
                        .setParameter("login", user.getLogin())
                        .getSingleResult();
        if (user.getPassword().equals(result.getPassword()))
            return result;
        return null;
    }

    @Override
    @Transactional
    public User register(User user) {
        List<User> result = em.createNamedQuery(User.GET_BY_LOGIN, User.class)
                              .setParameter("login", user.getLogin())
                              .getResultList();
        if (result.size() == 0) {
            em.persist(user);
            return user;
        }
        return null;
    }
}
