package com.jalagbe.app.model;

import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

/**
 * Created by rahma on 8/22/2017.
 */

public class CategoryModel implements Serializable {
    private String categoryName;

    private MultipartFile[] files;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public MultipartFile[] getFiles() {
        return files;
    }

    public void setFiles(MultipartFile[] files) {
        this.files = files;
    }
}
