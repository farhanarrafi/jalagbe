package com.jalagbe.app.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by rahma on 8/14/2017.
 */

@Entity
@Table(name = "category_image", catalog = "jalagbe_db", uniqueConstraints = {
        @UniqueConstraint(columnNames = "FILE_NAME")})
public class CategoryImage implements Serializable {

    @Id
    @Column(name = "ID")
    @SequenceGenerator(name = "category_image_seq", sequenceName = "category_image_seq", allocationSize    = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_image_seq")
    private Long id;

    @Column(name = "CREATED_ON", nullable = false)
    private String createdOn;

    @Column(name = "UPDATED_ON",  nullable = false)
    private String updatedOn;

    @OneToOne(targetEntity=Category.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "CATEGORY_ID", nullable = false)
    private Category categoryId;

    @Column(name = "FILE_NAME", unique = true, nullable = false)
    private String fileName;

    @Column(name = "ORIGINAL_NAME")
    private String originalName;

    public CategoryImage() {
        super();
    }

    public CategoryImage(Long id, String createdOn, String updatedOn, Category categoryId, String fileName, String originalName) {
        this.id = id;
        this.createdOn = createdOn;
        this.updatedOn = updatedOn;
        this.categoryId = categoryId;
        this.fileName = fileName;
        this.originalName = originalName;
    }

    public Category getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Category categoryId) {
        this.categoryId = categoryId;
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
