package com.shitot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * Created by Next on 01.08.2016.
 */
@MappedSuperclass
@Access(AccessType.FIELD)
public abstract class UserDoctor extends BaseEntity {

    @Column(unique = true, nullable = false)
    @NotEmpty
    protected String login;
    @Column(nullable = false)
    @NotEmpty
    @JsonIgnore
    protected String password;
    protected boolean enabled = true;
    protected String role;

    public UserDoctor() {
    }

    public UserDoctor(Integer id) {
        super(id);
    }

    public UserDoctor(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public UserDoctor(Integer id, String login, String password) {
        super(id);
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
