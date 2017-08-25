package com.jalagbe.app.controller;

import com.jalagbe.app.model.ProductModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by tareq rahman on 8/18/2017.
 */

@Controller
@RequestMapping(value = "/product")
public class ProductController {

    @RequestMapping(value = "")
    public String execute() {
        //return Product
        return "index";
    }

    //admin part

    @RequestMapping(value = "/add", method = {RequestMethod.GET})
    public String loadNewProduct() {
        return "upload-product";
    }

    @RequestMapping(value = "/update/{productId:[0-9]+}{slug:.*}", method = RequestMethod.GET)
    public String loadUpdateProduct(@PathVariable("productId") long productId) {
        return "upload-Product";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<?> multiUploadFileModel(@ModelAttribute ProductModel model) {

        return new ResponseEntity("Successfully uploaded!", HttpStatus.OK);
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
