package com.jalagbe.app.action;

import com.jalagbe.app.base.service.JalagbeService;
import com.jalagbe.app.constant.JalagbeConstant;
import com.jalagbe.app.base.action.AbstractJalagbeAction;
import com.jalagbe.app.base.action.JalagbeAction;
import com.jalagbe.app.entity.Category;
import com.jalagbe.app.entity.CategoryImage;
import com.jalagbe.app.model.CategoryModel;
import com.jalagbe.app.service.CategoryImageService;
import com.jalagbe.app.util.JalagbeUtil;
import com.jalagbe.app.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

/**
 * Created by rahma on 8/21/2017.
 */

@Component
public class CategoryAction extends AbstractJalagbeAction implements JalagbeAction<CategoryModel> {

    @Autowired
    private CategoryImageService categoryImageService;

    @Override
    protected Map<String, ?> processResponse(Object object) {
        return null;
    }

    @Override
    protected boolean validateRequestParams(Object object) {
        return false;
    }

    @Override
    public boolean executeUpdate(CategoryModel categoryModel, JalagbeService jalagbeService) {
        return false;
    }

    @Override
    public boolean executeInsert(CategoryModel model, JalagbeService categoryService) throws Exception {
        boolean result = false;
        Category category = new Category();
        category.setCategoryName(model.getCategoryName());
        category.setCreatedOn(super.getDateTime());
        category.setUpdatedOn(super.getDateTime());

        if(!"notSelected".equals(model.getParentId())) {
            Category parentCategory = new Category();
            parentCategory.setId(model.getParentId());
            category.setParentId(parentCategory);
        }

        try {
            if(categoryService.save(category)) {
                MultipartFile multipartFile = model.getFiles();
                String storeAbleImageName =  JalagbeUtil.getUniqueImageName();
                CategoryImage categoryImage = new CategoryImage();
                categoryImage.setFileName(storeAbleImageName);
                categoryImage.setCategoryId(category);
                categoryImage.setCreatedOn(super.getDateTime());
                categoryImage.setUpdatedOn(super.getDateTime());

                if(categoryImageService.save(categoryImage)) {
                    JalagbeUtil.saveUploadedImages(multipartFile, category, storeAbleImageName, JalagbeConstant.CATEGORY_IMAGE_FOLDER);
                    result = true;
                } else {
                    result = false;
                    //delete the category from DB
                }
            }
        } catch (Exception e) {
            result = false;
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean executeDelete(long id, JalagbeService jalagbeService) {
        return false;
    }

    @Override
    public Map<String, ?> execute(JalagbeService jalagbeService) throws Exception {
        Map<String, Object> result = new HashMap<>();
        List<CategoryModel> categoryModelList = new ArrayList<>();
        List<Category> categoryList = jalagbeService.getAll();
        CategoryModel categoryModel;
        for (Category category : categoryList){
            categoryModel = Mapper.from(category);
            categoryModelList.add(categoryModel);
        }
        result.put("categoryList", categoryModelList);
        result.put("imageFolder", JalagbeConstant.CATEGORY_IMAGE_FOLDER);
        return result;
    }

}
