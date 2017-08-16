package com.jalagbe.app.entity;

import com.jalagbe.app.entity.base.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by rahma on 8/13/2017.
 */
@Entity
@Table(name = "payment", catalog = "jalagbe_db")
public class Payment extends BaseEntity implements Serializable {

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
        super();
    }

    public Payment(Order orderId, float amount, String transactionId, String method, String status) {
        this.orderId = orderId;
        this.amount = amount;
        this.transactionId = transactionId;
        this.method = method;
        this.status = status;
    }

    public Payment(Long id, String createdOn, String updatedOn, Order orderId, float amount, String transactionId, String method, String status) {
        super(id, createdOn, updatedOn);
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
}
