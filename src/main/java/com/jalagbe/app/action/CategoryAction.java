package com.jalagbe.app.action;

import com.jalagbe.app.JalagbeConstant;
import com.jalagbe.app.base.action.AbstractBaseAction;
import com.jalagbe.app.base.action.BaseAction;
import com.jalagbe.app.entity.Category;
import com.jalagbe.app.entity.CategoryImage;
import com.jalagbe.app.model.CategoryModel;
import com.jalagbe.app.model.JalagbeResponse;
import com.jalagbe.app.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
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



    @Override
    protected Map<String, ?> processResponse(Object object) {
        return null;
    }

    @Override
    protected boolean validateRequestParams(Object object) {
        return false;
    }

    @Override
    public Map<String, ?> execute() {
        return null;
    }

    @Override
    public JalagbeResponse execute(CategoryModel model, HttpServletRequest request) {
        //logger.debug("Multiple file upload! With UploadModel");
        Category category = new Category();
        category.setCategoryName(model.getCategoryName());
        category.setParentId(model.getParentId());

        saveUploadedImages(Arrays.asList(model.getFiles()), category, request);

        return null;
    }

    private void saveUploadedImages(List<MultipartFile> files, Category category, HttpServletRequest request) {

        for (MultipartFile file : files) {

            if (file.isEmpty()) {
                continue; //next pls
            }
            //resourceLoader.getResource("resources/images/"+product.getProductId()+".png").getFile());
            try {
                byte[] bytes = file.getBytes();
                String originalFileName =  file.getOriginalFilename();
                //String filePath = request.getSession().getServletContext().getRealPath(JalagbeConstant.CATEGORY_IMAGE_FOLDER );
                Path path = Paths.get(JalagbeConstant.CATEGORY_IMAGE_FOLDER  + originalFileName);
                Files.write(path, bytes);
                CategoryImage categoryImage = new CategoryImage();
                categoryImage.setFileName(originalFileName);
                categoryImage.setCategoryId(category);

            } catch (IOException e) {
                e.printStackTrace();
            }



        }

    }

    private String getImageNameForUpload(){
        DateFormat dateFormat =new SimpleDateFormat("dd-MM-yy HH-mm-ss.SSS");
        Date date = new Date();
        String dateName =dateFormat.format(date) ;
        String trimFirst  = dateName.replaceAll("[ :.+-]", "").trim();
        String name = trimFirst +".jpg";
        return  name;
    }


}
