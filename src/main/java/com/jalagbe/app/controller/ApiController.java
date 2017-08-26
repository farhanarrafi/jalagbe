package com.jalagbe.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by tareq rahman on 8/26/2017.
 */
@Controller
public class ApiController {

    @RequestMapping("/wwwcheck")
    public String execute() {

        return "temp";
    }
}
