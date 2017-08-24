package com.jalagbe.app.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by rahma on 8/14/2017.
 */

@Entity
@Table(name = "attribute", catalog = "jalagbe_db")
public class Attribute implements Serializable {

    @Id
    @Column(name = "ID")
    @SequenceGenerator(name = "attribute_seq", sequenceName = "attribute_seq", allocationSize    = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "attribute_seq")
    private Long id;

    @Column(name = "CREATED_ON", nullable = false)
    private String createdOn;

    @Column(name = "UPDATED_ON",  nullable = false)
    private String updatedOn;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "TYPE", nullable = false)
    private String type;

    public Attribute() {
        super();
    }

    public Attribute(Long id, String createdOn, String updatedOn, String name, String type) {
        this.id = id;
        this.createdOn = createdOn;
        this.updatedOn = updatedOn;
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
