package com.jalagbe.app.action;

import com.jalagbe.app.base.action.AbstractJalagbeAction;
import com.jalagbe.app.base.action.JalagbeAction;
import com.jalagbe.app.base.service.JalagbeService;
import com.jalagbe.app.constant.JalagbeConstant;
import com.jalagbe.app.entity.Category;
import com.jalagbe.app.entity.CategoryImage;
import com.jalagbe.app.entity.Product;
import com.jalagbe.app.entity.ProductImage;
import com.jalagbe.app.model.ProductModel;
import com.jalagbe.app.service.ProductImageService;
import com.jalagbe.app.util.JalagbeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by tareq rahman on 8/15/2017.
 */
@Component
public class ProductAction extends AbstractJalagbeAction implements JalagbeAction<ProductModel> {

    @Autowired
    private ProductImageService productImageService;

    @Override
    public boolean executeUpdate(ProductModel model, JalagbeService jalagbeService) {
        return false;
    }

    @Override
    public boolean executeInsert(ProductModel model, JalagbeService jalagbeService) {
        boolean result = false;
        Category category = new Category();
        category.setId(model.getCategoryId());

        Product product = new Product();
        product.setCategoryId(category);
        product.setProductName(model.getProductName());
        product.setQuntity(model.getQuantity());
        product.setAvailability(model.getAvailability());
        product.setOriginalPrice(model.getOriginalPrice());
        product.setDiscountPrice(model.getDiscountPrice());
        product.setDescription(model.getDescription());
        product.setFeature(model.getFeature());
        product.setCreatedOn(super.getDateTime());
        product.setUpdatedOn(super.getDateTime());

        try {
            if(jalagbeService.save(product)) {
                List<MultipartFile> multipartFileList = Arrays.asList(model.getFiles());
                for (MultipartFile file : multipartFileList) {
                    String storeAbleImageName =  JalagbeUtil.getUniqueImageName();
                    ProductImage productImage = new ProductImage();
                    productImage.setFileName(storeAbleImageName);
                    productImage.setProductId(product);
                    productImage.setCreatedOn(super.getDateTime());
                    productImage.setUpdatedOn(super.getDateTime());

                    if(productImageService.save(productImage)) {
                        JalagbeUtil.saveUploadedImages(file, category, storeAbleImageName, JalagbeConstant.PRODUCT_IMAGE_FOLDER);
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
    public boolean executeDelete(long id, JalagbeService productService) {
        return false;
    }

    @Override
    public Map<String, ?> execute(JalagbeService jalagbeService) {
        return null;
    }

    @Override
    protected Map<String, ?> processResponse(Object object) {
        return null;
    }

    @Override
    protected boolean validateRequestParams(Object object) {
        return false;
    }

    private String generateUniqueProductCode(Long categoryId, Long productId, String productName){

        return null;
    }
}
