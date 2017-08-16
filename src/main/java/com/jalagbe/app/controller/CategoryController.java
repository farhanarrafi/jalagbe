package com.jalagbe.app.controller;

import com.jalagbe.app.entity.Category;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * Created by tareq rahman on 8/18/2017.
 */

@Controller
@RequestMapping(value = "category")
public class CategoryController {

    @RequestMapping(value = "")
    public String execute() {
        ModelAndView model = new ModelAndView("temp");
        model.addObject("msg", "hello world");

        return "index";
    }

    //admin part

    @RequestMapping(value = "/add", method = {RequestMethod.POST,RequestMethod.GET})
    public String newCategory(@Valid @RequestBody Category category, Errors errors) {
//        if(model != null) {
//
//        }
//        model.addAttribute("notifyMsg", "inserted successfully");
        return "upload-category";
    }

    @RequestMapping(value = "/delete/{categoryId:[0-9]+}{slug:.*}", method = RequestMethod.DELETE)
    public String deleteCategory(@PathVariable("categoryId") long categoryId) {
        ModelAndView model = new ModelAndView("temp");
        model.addObject("msg", "hello world");

        return "admin";
    }

    @RequestMapping(value = "/update/{categoryId:[0-9]+}{slug:.*}", method = RequestMethod.PUT)
    public String updateCategory(Model model, @PathVariable("categoryId") long categoryId) {

        return "admin";
    }

    @RequestMapping(value = "/catrgorylist", method = RequestMethod.GET)
    public String getAllCategory() {

        return "admin";
    }
}
