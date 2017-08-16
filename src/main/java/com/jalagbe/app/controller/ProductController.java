package com.jalagbe.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by tareq rahman on 8/18/2017.
 */

@Controller
@RequestMapping(value = "product")
public class ProductController {

    @RequestMapping(value = "")
    public String execute() {
        ModelAndView model = new ModelAndView("temp");
        model.addObject("msg", "hello world");

        return "index";
    }

    @RequestMapping(value = "/add", method = {RequestMethod.POST, RequestMethod.GET})
    public String newProduct() {

        return "upload-product";
    }

    @RequestMapping(value = "/delete/{productId:[0-9]+}{slug:.*}", method = RequestMethod.DELETE)
    public String deleteProduct(@PathVariable("productId") long productId) {
        ModelAndView model = new ModelAndView("temp");
        model.addObject("msg", "hello world");

        return "admin";
    }

    @RequestMapping(value = "/update/{productId:[0-9]+}{slug:.*}", method = RequestMethod.PUT)
    public String updateProduct(Model model, @PathVariable("productId") long productId) {

        return "admin";
    }

    @RequestMapping(value = "/productlist", method = RequestMethod.PUT)
    public String getAllProduct() {

        return "admin";
    }
}
