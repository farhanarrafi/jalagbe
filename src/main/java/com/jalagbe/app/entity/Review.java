package com.jalagbe.app.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by rahma on 8/13/2017.
 */

@Entity
@Table(name = "review", catalog = "jalagbe_db")
public class Review implements Serializable {

    @Id
    @Column(name = "ID")
    @SequenceGenerator(name = "review_seq", sequenceName = "review_seq", allocationSize    = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "review_seq")
    private Long id;

    @Column(name = "CREATED_ON", nullable = false)
    private String createdOn;

    @Column(name = "UPDATED_ON",  nullable = false)
    private String updatedOn;
    
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

    public Review(Long id, String createdOn, String updatedOn, Product productId, User userId, String comment) {
        this.id = id;
        this.createdOn = createdOn;
        this.updatedOn = updatedOn;
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
