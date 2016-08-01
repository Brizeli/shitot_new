package com.shitot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * Created by Next on 26.07.2016.
 */
@NamedQueries({
                  @NamedQuery(name = User.GET_BY_LOGIN, query = "select u from users u where u.login=:login")
})
@Entity(name = "users")
public class User extends BaseEntity {
    public static final String GET_BY_LOGIN = "User.getByLogin";
    @Column(unique = true)
    String login;
    String password;

    public User() {
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
