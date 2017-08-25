package com.jalagbe.app.controller;

import com.jalagbe.app.model.UploadModel;
import com.jalagbe.app.service.CategoryService;
import com.jalagbe.app.validator.CategoryValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by tareq rahman on 8/18/2017.
 */

@Controller
@RequestMapping(value = "category")
public class CategoryController {

    @Autowired
    private CategoryValidator categoryValidator;

    @Autowired
    private CategoryService categoryService;

//    @InitBinder
//    protected void initBinder(WebDataBinder binder) {
//        binder.setValidator(categoryValidator);
//    }

    @RequestMapping(value = "")
    public String execute() {
        ModelAndView model = new ModelAndView("temp");
        model.addObject("msg", "hello world");

        return "index";
    }

    //admin part

    @RequestMapping(value = "/add", method = {RequestMethod.GET})
    public String newCategory() {

//        if(model != null) {
//
//        }
//        model.addAttribute("notifyMsg", "inserted successfully");
        return "upload-category";
    }

//    @RequestMapping(value = "/save", method = RequestMethod.POST)
//    @ResponseBody
//    public CategoryResponse saveCategory(@Valid @RequestBody final CategoryModel categoryModel) {
//        CategoryResponse result = new CategoryResponse();
//        result.setMsg("working");
//        return result;
//    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<?> multiUploadFileModel(@ModelAttribute UploadModel model) {

        String n = "";
        return new ResponseEntity("Successfully uploaded!", HttpStatus.OK);

    }


    @RequestMapping(value = "/delete/{categoryId:[0-9]+}{slug:.*}", method = RequestMethod.DELETE)
    public String deleteCategory(@PathVariable("categoryId") long categoryId) {
        ModelAndView model = new ModelAndView("temp");
        model.addObject("msg", "hello world");

        return "admin";
    }

    @RequestMapping(value = "/update/{categoryId:[0-9]+}{slug:.*}", method = RequestMethod.POST)
    public String updateCategory(Model model, @PathVariable("categoryId") long categoryId) {

        return "admin";
    }

    @RequestMapping(value = "/sav", method = RequestMethod.POST )
    public String getAllCategory() {
        String s = "";
        return "admin";
    }
}
