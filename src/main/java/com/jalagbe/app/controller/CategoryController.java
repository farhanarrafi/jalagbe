package com.jalagbe.app.controller;

import com.jalagbe.app.action.CategoryAction;
import com.jalagbe.app.constant.JalagbeConstant;
import com.jalagbe.app.entity.Category;
import com.jalagbe.app.entity.CategoryImage;
import com.jalagbe.app.model.CategoryModel;
import com.jalagbe.app.service.CategoryImageService;
import com.jalagbe.app.service.CategoryService;
import com.jalagbe.app.validator.CategoryValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

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

    @Autowired
    private CategoryService categoryService;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(categoryValidator);
    }

    @RequestMapping(value = "")
    public ModelAndView execute() {
        ModelAndView model =  new ModelAndView("show-categories");
        try {
            Map<String, ?> categoryResult = categoryAction.execute(categoryService);
            model.addObject("categoryResult", categoryResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return model;
    }

    //admin part

    @RequestMapping(value = "/add", method = {RequestMethod.GET})
    public ModelAndView loadNewCategory() {
        ModelAndView model =  new ModelAndView("upload-category");
        try {
            List<Category> categoryList = categoryService.getAll();
            model.addObject("categoryList", categoryList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return model;
    }

    @RequestMapping(value = "/update/{categoryId:[0-9]+}{slug:.*}", method = RequestMethod.GET)
    public String loadUpdateCategory(@PathVariable("categoryId") long categoryId) {
        return "upload-category";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<?> saveNewCategory(@Valid @ModelAttribute CategoryModel categoryModel) {
        ResponseEntity responseEntity = null;
        try {
            if(categoryAction.executeInsert(categoryModel, categoryService)) {
                responseEntity = new ResponseEntity("Inserted successful", HttpStatus.OK);
            } else {
                responseEntity = new ResponseEntity("500 \nInternal server error!", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            e.printStackTrace();
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
