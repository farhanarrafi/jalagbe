package com.jalagbe.app.controller;

import com.jalagbe.app.entity.Admin;
import com.jalagbe.app.model.CategoryModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by tareq rahman on 8/18/2017.
 */

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    @RequestMapping(value = "")
    public String execute() {
        //return category
        return "admin";
    }

    //admin part

    @RequestMapping(value = "/add", method = {RequestMethod.GET})
    public String loadNewAdmin() {
        return "upload-category";
    }

    @RequestMapping(value = "/update/{adminId:[0-9]+}{slug:.*}", method = RequestMethod.GET)
    public String loadUpdateAdmin(@PathVariable("adminId") long adminId) {
        return "upload-category";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<?> saveAdmin(@ModelAttribute Admin model) {

        return new ResponseEntity("Successfully uploaded!", HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseEntity<?> updateAdmin(@ModelAttribute Admin model) {

        return new ResponseEntity("Successfully uploaded!", HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{categoryId:[0-9]+}{slug:.*}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteAdmin(@PathVariable("categoryId") long categoryId) {

        return new ResponseEntity("Successfully uploaded!", HttpStatus.OK);
    }
}
