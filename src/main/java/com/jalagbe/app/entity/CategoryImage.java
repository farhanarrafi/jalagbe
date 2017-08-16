package com.jalagbe.app.entity;

import com.jalagbe.app.entity.base.BaseEntity;

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
public class CategoryImage extends BaseEntity implements Serializable {

    @OneToOne(targetEntity=Category.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "CATEGORY_ID", nullable = false)
    private Category categoryId;

    @Column(name = "FILE_NAME", unique = true, nullable = false)
    private String fileName;

    @Column(name = "ORIGINAL_NAME", nullable = false)
    private String originalName;

    public CategoryImage() {
        super();
    }

    public CategoryImage(Category categoryId, String fileName, String originalName) {
        this.categoryId = categoryId;
        this.fileName = fileName;
        this.originalName = originalName;
    }

    public CategoryImage(Long id, String createdOn, String updatedOn, Category categoryId, String fileName, String originalName) {
        super(id, createdOn, updatedOn);
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
}
