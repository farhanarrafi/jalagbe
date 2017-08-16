package com.jalagbe.app.entity;

import com.jalagbe.app.entity.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.io.Serializable;

/**
 * Created by rahma on 8/13/2017.
 */

@Entity
@Table(name = "admin", catalog = "jalagbe_db", uniqueConstraints = {
        @UniqueConstraint(columnNames = "EMAIL")})
public class Admin  extends BaseEntity implements Serializable {

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "EMAIL", nullable = false, unique = true)
    private String email;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name = "TYPE", nullable = false)
    private int type;

    @Column(name = "STATUS", nullable = false)
    private int status;

    public Admin() {
        super();
    }

    public Admin(String name, String email, String password, int type, int status) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.type = type;
        this.status = status;
    }

    public Admin(Long id, String createdOn, String updatedOn, String name, String email, String password, int type, int status) {
        super(id, createdOn, updatedOn);
        this.name = name;
        this.email = email;
        this.password = password;
        this.type = type;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}
