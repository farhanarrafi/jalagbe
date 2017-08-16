package com.jalagbe.app.entity;

import com.jalagbe.app.entity.base.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by rahma on 8/13/2017.
 */
@Entity
@Table(name = "product_image", catalog = "jalagbe_db", uniqueConstraints = {
        @UniqueConstraint(columnNames = "FILE_NAME")})
public class ProductImage extends BaseEntity implements Serializable {

    @ManyToOne(targetEntity=Product.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCT_ID", nullable = false)
    private Product productId;

    @Column(name = "FILE_NAME", unique = true,  nullable = false)
    private String fileName;

    @Column(name = "ORIGINAL_NAME", nullable = false)
    private String originalName;

    public ProductImage() {
        super();
    }

    public ProductImage(Product productId, String fileName, String originalName) {
        this.productId = productId;
        this.fileName = fileName;
        this.originalName = originalName;
    }

    public ProductImage(Long id, String createdOn, String updatedOn, Product productId, String fileName, String originalName) {
        super(id, createdOn, updatedOn);
        this.productId = productId;
        this.fileName = fileName;
        this.originalName = originalName;
    }

    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

}
