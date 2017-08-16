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
@RequestMapping(value = "user")
public class UserController {

    @RequestMapping(value = "")
    public String execute() {
        ModelAndView model = new ModelAndView("temp");
        model.addObject("msg", "hello world");

        return "index";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String userLogin() {
        ModelAndView model = new ModelAndView("temp");
        model.addObject("msg", "hello world");

        return "admin";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String newUser() {
        ModelAndView model = new ModelAndView("temp");
        model.addObject("msg", "hello world");

        return "admin";
    }

    @RequestMapping(value = "/delete/{userId:[0-9]+}{slug:.*}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable("userId") long userId) {
        ModelAndView model = new ModelAndView("temp");
        model.addObject("msg", "hello world");

        return "admin";
    }

    @RequestMapping(value = "/update/{userId:[0-9]+}{slug:.*}", method = RequestMethod.PUT)
    public String updateUserIdInfo(Model model, @PathVariable("userId") long userId) {

        return "admin";
    }

    @RequestMapping(value = "/adminlist", method = RequestMethod.PUT)
    public String getAllUser() {

        return "admin";
    }
}
