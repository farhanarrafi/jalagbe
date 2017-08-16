package com.jalagbe.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
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
        ModelAndView model = new ModelAndView("temp");
        model.addObject("msg", "hello world");

        return "admin";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String adminLogin() {
        ModelAndView model = new ModelAndView("temp");
        model.addObject("msg", "hello world");

        return "admin";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String newAdmin() {
        ModelAndView model = new ModelAndView("temp");
        model.addObject("msg", "hello world");

        return "admin";
    }

    @RequestMapping(value = "/delete/{adminId:[0-9]+}{slug:.*}", method = RequestMethod.DELETE)
    public String deleteAdmin(@PathVariable("adminId") long adminId) {
        ModelAndView model = new ModelAndView("temp");
        model.addObject("msg", "hello world");

        return "admin";
    }

    @RequestMapping(value = "/update/{adminId:[0-9]+}{slug:.*}", method = RequestMethod.PUT)
    public String updateAdminInfo(Model model, @PathVariable("adminId") long adminId) {

        return "admin";
    }

    @RequestMapping(value = "/adminlist", method = RequestMethod.GET)
    public String getAllAdmin() {

        return "upload-category";
    }
}
