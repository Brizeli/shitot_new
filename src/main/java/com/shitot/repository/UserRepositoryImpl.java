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
//    @Override
//    public User login(User user) {
//        User result = em.createNamedQuery(User.GET_BY_LOGIN, User.class)
//                        .setParameter("login", user.getLogin())
//                        .getSingleResult();
//        if (user.getPassword().equals(result.getPassword()))
//            return result;
//        return null;
//    }

    @Override
    @Transactional
    public User save(User user) {
        if (user.isNew()) {
            em.persist(user);
            return user;
        } else return em.merge(user);
    }

    @Override
    @Transactional
    public boolean delete(int id) {
        User user = em.find(User.class, id);
        if (user == null) return false;
        em.remove(user);
        return true;
    }

    @Override
    public List<User> getAll() {
        return em.createNamedQuery(User.ALL_SORTED, User.class).getResultList();
    }

    @Override
    public User get(int id) {
        return em.find(User.class, id);
    }
}
