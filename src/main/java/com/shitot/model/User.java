package com.shitot.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * Created by Next on 26.07.2016.
 */
@NamedQueries({
                  @NamedQuery(name = User.GET_BY_LOGIN, query = "select u from users u where u.login=:login"),
                  @NamedQuery(name = User.ALL_SORTED, query = "select u from users u order by LOWER(u.login)")
})
@Entity(name = "users")
public class User extends UserDoctor {
    public static final String GET_BY_LOGIN = "User.getByLogin";
    public static final String ALL_SORTED = "User.getAllSorted";

    public User() {
    }

    public User(String login, String password) {
        super(login,password);
        this.role = "USER";
    }

    public User(Integer id, String login, String password) {
        super(id,login,password);
        this.role = "USER";
    }
}
