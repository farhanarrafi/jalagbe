package com.jalagbe.app.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by rahma on 8/13/2017.
 */
@Entity
@Table(name = "payment", catalog = "jalagbe_db")
public class Payment implements Serializable {

    @Id
    @Column(name = "ID")
    @SequenceGenerator(name = "payment_seq", sequenceName = "payment_seq", allocationSize    = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "payment_seq")
    private Long id;

    @Column(name = "CREATED_ON", nullable = false)
    private String createdOn;

    @Column(name = "UPDATED_ON",  nullable = false)
    private String updatedOn;
    
    @OneToOne(targetEntity=Order.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "ORDER_ID")
    private Order orderId;

    @Column(name = "AMOUNT",  nullable = false)
    private float amount;

    @Column(name = "TRANSACTION_ID",  nullable = false)
    private String transactionId;

    @Column(name = "METHOD",  nullable = false)
    private String method;

    @Column(name = "STATUS",  nullable = false)
    private String status;

    public Payment() {

    }

    public Payment(Long id, String createdOn, String updatedOn, Order orderId, float amount, String transactionId, String method, String status) {
        this.id = id;
        this.createdOn = createdOn;
        this.updatedOn = updatedOn;
        this.orderId = orderId;
        this.amount = amount;
        this.transactionId = transactionId;
        this.method = method;
        this.status = status;
    }

    public Order getOrderId() {
        return orderId;
    }

    public void setOrderId(Order orderId) {
        this.orderId = orderId;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
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
