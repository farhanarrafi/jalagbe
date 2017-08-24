package com.jalagbe.app.validator;

import com.jalagbe.app.model.CategoryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by rahma on 8/22/2017.
 */
@Component
public class CategoryValidator implements Validator {

    @Autowired
    JalagbeValidator jalagbeValidator;

    @Override
    public boolean supports(Class<?> clazz) {
        return CategoryModel.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        CategoryModel categoryModel = (CategoryModel) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "categoryName", "NotEmpty.category.name.category");

        if(!jalagbeValidator.isValidString(categoryModel.getCategoryName())){
            errors.rejectValue("categoryName", "NotEmpty.category.name.category");
        }
    }
}
