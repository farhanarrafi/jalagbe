package com.jalagbe.app.entity;

import com.jalagbe.app.entity.base.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by rahma on 8/13/2017.
 */

@Entity
@Table(name = "review", catalog = "jalagbe_db")
public class Review extends BaseEntity implements Serializable {

    @ManyToOne(targetEntity=Product.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCT_ID", nullable = false)
    private Product productId;

    @ManyToOne(targetEntity=User.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID", nullable = false)
    private User userId;

    @Column(name = "COMMENT", nullable = false)
    private String comment;

    public Review() {
        super();
    }

    public Review(Product productId, User userId, String comment) {
        this.productId = productId;
        this.userId = userId;
        this.comment = comment;
    }

    public Review(Long id, String createdOn, String updatedOn, Product productId, User userId, String comment) {
        super(id, createdOn, updatedOn);
        this.productId = productId;
        this.userId = userId;
        this.comment = comment;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
