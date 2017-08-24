package com.jalagbe.app.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by rahma on 8/13/2017.
 */

@Entity
@Table(name = "order", catalog = "jalagbe_db")
public class Order implements Serializable {

    @Id
    @Column(name = "ID")
    @SequenceGenerator(name = "order_seq", sequenceName = "order_seq", allocationSize    = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_seq")
    private Long id;

    @Column(name = "CREATED_ON", nullable = false)
    private String createdOn;

    @Column(name = "UPDATED_ON",  nullable = false)
    private String updatedOn;
    
    @ManyToOne(targetEntity=User.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User userId;

    @Column(name = "TEX",  nullable = false)
    private String tex;

    @Column(name = "SHIPPING_COST",  nullable = false)
    private float shippingCost;

    @Column(name = "STATUS",  nullable = false)
    private String status;

    public Order() {
        
    }

    public Order(Long id, String createdOn, String updatedOn, User userId, String tex, float shippingCost, String status) {
        this.id = id;
        this.createdOn = createdOn;
        this.updatedOn = updatedOn;
        this.userId = userId;
        this.tex = tex;
        this.shippingCost = shippingCost;
        this.status = status;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public String getTex() {
        return tex;
    }

    public void setTex(String tex) {
        this.tex = tex;
    }

    public float getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(float shippingCost) {
        this.shippingCost = shippingCost;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
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
