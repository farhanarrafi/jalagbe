package com.jalagbe.app.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
/**
 * Created by rahma on 8/22/2017.
 */

@Component
public class ProductValidator implements Validator {

    @Autowired
    JalagbeValidator jalagbeValidator;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
