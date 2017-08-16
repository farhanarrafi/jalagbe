package com.jalagbe.app.entity;

import com.jalagbe.app.entity.base.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by rahma on 8/13/2017.
 */

@Entity
@Table(name = "ranking", catalog = "jalagbe_db")
public class Ranking extends BaseEntity implements Serializable {

    @ManyToOne(targetEntity=Product.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCT_ID", nullable = false)
    private Product productId;

    @ManyToOne(targetEntity=User.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID", nullable = false)
    private User userId;

    @Column(name = "RATE", nullable = false)
    private float rate;

    public Ranking() {
        super();
    }

    public Ranking(Product productId, User userId, float rate) {
        this.productId = productId;
        this.userId = userId;
        this.rate = rate;
    }

    public Ranking(Long id, String createdOn, String updatedOn, Product productId, User userId, float rate) {
        super(id, createdOn, updatedOn);
        this.productId = productId;
        this.userId = userId;
        this.rate = rate;
    }

    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

}
