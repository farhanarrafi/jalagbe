package com.jalagbe.app.validator;

import com.jalagbe.app.model.CategoryModel;
import com.jalagbe.app.model.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.Arrays;

/**
 * Created by rahma on 8/22/2017.
 */

@Component
public class ProductValidator implements Validator {

    @Autowired
    JalagbeValidator jalagbeValidator;

    @Override
    public boolean supports(Class<?> clazz) {
        return ProductModel.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ProductModel productModel = (ProductModel) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "categoryId", "NotEmpty.category.id");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "productName", "NotEmpty.product.name");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "quantity", "NotEmpty.product.quantity");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "originalPrice", "NotEmpty.product.original.price");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "feature", "NotEmpty.product.availability");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "availability", "NotEmpty.product.feature");

        if(!jalagbeValidator.isValidImage(Arrays.asList(productModel.getFiles()))) {
            errors.rejectValue("image", "NotEmpty.product.image");
        }
    }
}
