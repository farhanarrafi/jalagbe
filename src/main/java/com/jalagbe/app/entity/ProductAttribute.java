package com.jalagbe.app.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by rahma on 8/14/2017.
 */

@Entity
@Table(name = "product_attribute" , catalog = "jalagbe_db")
public class ProductAttribute implements Serializable {

    @Id
    @Column(name = "ID")
    @SequenceGenerator(name = "product_attribute_seq", sequenceName = "product_attribute_seq", allocationSize    = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_attribute_seq")
    private Long id;

    @Column(name = "CREATED_ON", nullable = false)
    private String createdOn;

    @Column(name = "UPDATED_ON",  nullable = false)
    private String updatedOn;
    
    @ManyToOne(targetEntity=Attribute.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "ATTRIBUTE_ID", nullable = false)
    private Attribute attributeId;

    @ManyToOne(targetEntity=Product.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCT_ID", nullable = false)
    private Product productId;

    public ProductAttribute() {
        super();
    }

    public ProductAttribute(Long id, String createdOn, String updatedOn, Attribute attributeId, Product productId) {
        this.id = id;
        this.createdOn = createdOn;
        this.updatedOn = updatedOn;
        this.attributeId = attributeId;
        this.productId = productId;
    }

    public Attribute getAttributeId() {
        return attributeId;
    }

    public void setAttributeId(Attribute attributeId) {
        this.attributeId = attributeId;
    }

    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
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
