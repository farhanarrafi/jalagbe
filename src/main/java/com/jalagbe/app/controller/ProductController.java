package com.jalagbe.app.controller;

import com.jalagbe.app.action.ProductAction;
import com.jalagbe.app.entity.Category;
import com.jalagbe.app.model.ProductModel;
import com.jalagbe.app.service.CategoryService;
import com.jalagbe.app.service.ProductService;
import com.jalagbe.app.validator.ProductValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by tareq rahman on 8/18/2017.
 */

@Controller
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductValidator productValidator;

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductAction productAction;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(productValidator);
    }

    @RequestMapping(value = "")
    public String execute() {
        //return Product
        return "index";
    }

    //admin part

    @RequestMapping(value = "/add", method = {RequestMethod.GET})
    public ModelAndView loadNewCategory() {
        ModelAndView model =  new ModelAndView("upload-product");
        try {
            List<Category> categoryList = categoryService.getAll();
            model.addObject("categoryList", categoryList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return model;
    }

    @RequestMapping(value = "/update/{productId:[0-9]+}{slug:.*}", method = RequestMethod.GET)
    public String loadUpdateProduct(@PathVariable("productId") long productId) {
        return "upload-Product";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<?> multiUploadFileModel(@ModelAttribute ProductModel productModel) {
        ResponseEntity responseEntity;
        if(productAction.executeInsert(productModel, productService)) {
            responseEntity = new ResponseEntity("Inserted successful", HttpStatus.OK);
        } else {
            responseEntity = new ResponseEntity("500 \nInternal server error!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseEntity<?> updateProduct(@ModelAttribute ProductModel model) {

        return new ResponseEntity("Successfully uploaded!", HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{productId:[0-9]+}{slug:.*}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteProduct(@PathVariable("productId") long productId) {

        return new ResponseEntity("Successfully uploaded!", HttpStatus.OK);
    }
}
