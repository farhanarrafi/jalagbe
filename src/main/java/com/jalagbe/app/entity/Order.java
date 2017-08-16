package com.jalagbe.app.entity;

import com.jalagbe.app.entity.base.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by rahma on 8/13/2017.
 */

@Entity
@Table(name = "order", catalog = "jalagbe_db")
public class Order extends BaseEntity implements Serializable {

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
        super();
    }

    public Order(User userId, String tex, float shippingCost, String status) {
        this.userId = userId;
        this.tex = tex;
        this.shippingCost = shippingCost;
        this.status = status;
    }

    public Order(Long id, String createdOn, String updatedOn, User userId, String tex, float shippingCost, String status) {
        super(id, createdOn, updatedOn);
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
}
