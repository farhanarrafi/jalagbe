package com.jalagbe.app.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by rahma on 8/13/2017.
 */
@Entity
@Table(name = "product_image", catalog = "jalagbe_db", uniqueConstraints = {
        @UniqueConstraint(columnNames = "FILE_NAME")})
public class ProductImage implements Serializable {

    @Id
    @Column(name = "ID")
    @SequenceGenerator(name = "product_image_seq", sequenceName = "product_image_seq", allocationSize    = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_image_seq")
    private Long id;

    @Column(name = "CREATED_ON", nullable = false)
    private String createdOn;

    @Column(name = "UPDATED_ON",  nullable = false)
    private String updatedOn;
    
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

    public ProductImage(Long id, String createdOn, String updatedOn, Product productId, String fileName, String originalName) {
        this.id = id;
        this.createdOn = createdOn;
        this.updatedOn = updatedOn;
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
