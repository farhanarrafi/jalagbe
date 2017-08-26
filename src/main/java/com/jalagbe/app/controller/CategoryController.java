package com.jalagbe.app.controller;

import com.jalagbe.app.action.CategoryAction;
import com.jalagbe.app.model.CategoryModel;
import com.jalagbe.app.validator.CategoryValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by tareq rahman on 8/18/2017.
 */

@Controller
@RequestMapping(value = "/category")
public class CategoryController {

    @Autowired
    private CategoryValidator categoryValidator;

    @Autowired
    private CategoryAction categoryAction;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(categoryValidator);
    }

    @RequestMapping(value = "")
    public String execute() {
        //return category
        return "index";
    }

    //admin part

    @RequestMapping(value = "/add", method = {RequestMethod.GET})
    public String loadNewCategory() {
        return "upload-category";
    }

    @RequestMapping(value = "/update/{categoryId:[0-9]+}{slug:.*}", method = RequestMethod.GET)
    public String loadUpdateCategory(@PathVariable("categoryId") long categoryId) {
        return "upload-category";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<?> saveNewCategory(@Valid @ModelAttribute CategoryModel categoryModel) {
        ResponseEntity responseEntity;
        if(categoryAction.executeInsert(categoryModel)) {
            responseEntity = new ResponseEntity("Inserted successful", HttpStatus.OK);
        } else {
            responseEntity = new ResponseEntity("Internal server error!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseEntity<?> updateCategory(@ModelAttribute CategoryModel model) {

        return new ResponseEntity("Successfully uploaded!", HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{categoryId:[0-9]+}{slug:.*}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteCategory(@PathVariable("categoryId") long categoryId) {

        return new ResponseEntity("Successfully uploaded!", HttpStatus.OK);
    }
}
