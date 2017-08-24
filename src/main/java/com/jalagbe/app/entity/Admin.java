package com.jalagbe.app.entity;


import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by rahma on 8/13/2017.
 */

@Entity
@Table(name = "admin", catalog = "jalagbe_db", uniqueConstraints = {
        @UniqueConstraint(columnNames = "EMAIL")})
public class Admin implements Serializable {

    @Id
    @Column(name = "ID")
    @SequenceGenerator(name = "admin_seq", sequenceName = "admin_seq", allocationSize    = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "admin_seq")
    private Long id;

    @Column(name = "CREATED_ON", nullable = false)
    private String createdOn;

    @Column(name = "UPDATED_ON",  nullable = false)
    private String updatedOn;

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

    public Admin(Long id, String createdOn, String updatedOn, String name, String email, String password, int type, int status) {
        this.id = id;
        this.createdOn = createdOn;
        this.updatedOn = updatedOn;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public String getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(String updatedOn) {
        this.updatedOn = updatedOn;
    }
}
