package com.jalagbe.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by rahma on 8/19/2017.
 */

@Controller
@RequestMapping(value = "/order")
public class OrderController {

    @RequestMapping(value = "")
    public String execute() {

        return "index";
    }
}
