package com.jalagbe.app.util;

import com.jalagbe.app.constant.JalagbeConstant;
import com.jalagbe.app.entity.Category;
import com.jalagbe.app.model.CategoryModel;

/**
 * Created by rahma on 9/10/2017.
 */
public class Mapper {
    public static CategoryModel from(Category category){
        CategoryModel categoryModel = new CategoryModel();
        categoryModel.setId(category.getId());
        categoryModel.setImageId(category.getCategoryImage().getId());
        categoryModel.setCategoryName(category.getCategoryName());
        categoryModel.setImageName(category.getCategoryImage().getFileName());
        categoryModel.setCreatedOn(category.getCreatedOn());
        categoryModel.setUpdatedOn(category.getUpdatedOn());
        Long parenCategoryId = category.getParentId() == null ? 0 : category.getParentId().getId();
        String parenCategoryName = category.getParentId() == null ? "" : category.getParentId().getCategoryName();
        categoryModel.setParentId(parenCategoryId);
        categoryModel.setParentCategoryName(parenCategoryName);
        categoryModel.setImage(JalagbeUtil.readImages(JalagbeConstant.CATEGORY_IMAGE_FOLDER, category.getCategoryImage().getFileName()));
        return categoryModel;
    }

    public static Category from(CategoryModel categoryModel) {
        return null;
    }
}
