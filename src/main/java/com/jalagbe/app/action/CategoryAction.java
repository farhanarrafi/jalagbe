package com.jalagbe.app.action;

import com.jalagbe.app.constant.JalagbeConstant;
import com.jalagbe.app.base.action.AbstractBaseAction;
import com.jalagbe.app.base.action.BaseAction;
import com.jalagbe.app.entity.Category;
import com.jalagbe.app.entity.CategoryImage;
import com.jalagbe.app.model.CategoryModel;
import com.jalagbe.app.model.JalagbeResponse;
import com.jalagbe.app.service.CategoryImageService;
import com.jalagbe.app.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by rahma on 8/21/2017.
 */

@Component
public class CategoryAction extends AbstractBaseAction implements BaseAction<CategoryModel>{

    @Autowired
    private CategoryService categoryService;

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
    public boolean executeUpdate(CategoryModel categoryModel) {
        return false;
    }

    @Override
    public boolean executeInsert(CategoryModel model) {
        boolean result = false;
        JalagbeResponse response = new JalagbeResponse();
        Category category = new Category();
        category.setCategoryName(model.getCategoryName());
        category.setParentId(model.getParentId());
        category.setCreatedOn(super.getDateTime());
        category.setUpdatedOn(super.getDateTime());

        try {
            if(categoryService.save(category)) {
                List<MultipartFile> multipartFileList = Arrays.asList(model.getFiles());
                for (MultipartFile file : multipartFileList) {
                    String storeAbleImageName = getUniqueImageName();
                    CategoryImage categoryImage = new CategoryImage();
                    categoryImage.setFileName(storeAbleImageName);
                    categoryImage.setCategoryId(category);
                    categoryImage.setCreatedOn(super.getDateTime());
                    categoryImage.setUpdatedOn(super.getDateTime());

                    if(categoryImageService.save(categoryImage)) {
                        this.saveUploadedImages(file, category, storeAbleImageName);
                        result = true;
                    } else {
                        result = false;
                        //delete the category from DB
                    }
                }
            }
        } catch (Exception e) {
            result = false;
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean executeDelete(long id) {
        return false;
    }

    @Override
    public Map<String, ?> execute() {
        return null;
    }

    private void saveUploadedImages(MultipartFile file, Category category, String storeAbleImageName) {
        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(JalagbeConstant.CATEGORY_IMAGE_FOLDER  + storeAbleImageName);
            Files.write(path, bytes);
            CategoryImage categoryImage = new CategoryImage();
            categoryImage.setFileName(storeAbleImageName);
            categoryImage.setCategoryId(category);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getUniqueImageName(){
        DateFormat dateFormat =new SimpleDateFormat("dd-MM-yy HH-mm-ss.SSS");
        Date date = new Date();
        String dateName =dateFormat.format(date) ;
        String trimFirst  = dateName.replaceAll("[ :.+-]", "").trim();
        String name = trimFirst +".jpg";
        return  name;
    }

}
