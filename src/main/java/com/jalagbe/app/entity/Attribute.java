package com.jalagbe.app.entity;

import com.jalagbe.app.entity.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.io.Serializable;

/**
 * Created by rahma on 8/14/2017.
 */

@Entity
@Table(name = "attribute", catalog = "jalagbe_db")
public class Attribute extends BaseEntity implements Serializable {

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "TYPE", nullable = false)
    private String type;

    public Attribute() {
        super();
    }

    public Attribute(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public Attribute(Long id, String createdOn, String updatedOn, String name, String type) {
        super(id, createdOn, updatedOn);
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
}
