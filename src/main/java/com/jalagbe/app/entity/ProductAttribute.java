package com.jalagbe.app.entity;

import com.jalagbe.app.entity.base.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by rahma on 8/14/2017.
 */

@Entity
@Table(name = "product_attribute" , catalog = "jalagbe_db")
public class ProductAttribute extends BaseEntity implements Serializable {

    @ManyToOne(targetEntity=Attribute.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "ATTRIBUTE_ID", nullable = false)
    private Attribute attributeId;

    @ManyToOne(targetEntity=Product.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCT_ID", nullable = false)
    private Product productId;

    public ProductAttribute() {
        super();
    }

    public ProductAttribute(Attribute attributeId, Product productId) {
        this.attributeId = attributeId;
        this.productId = productId;
    }

    public ProductAttribute(Long id, String createdOn, String updatedOn, Attribute attributeId, Product productId) {
        super(id, createdOn, updatedOn);
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

}
