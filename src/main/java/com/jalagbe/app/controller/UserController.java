package com.jalagbe.app.controller;

import com.jalagbe.app.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by tareq rahman on 8/18/2017.
 */

@Controller
@RequestMapping(value = "user")
public class UserController {

    @RequestMapping(value = "")
    public String execute() {
        //return User
        return "index";
    }

    //admin part

    @RequestMapping(value = "/add", method = {RequestMethod.GET})
    public String loadNewUser() {
        return "upload-User";
    }

    @RequestMapping(value = "/update/{userId:[0-9]+}{slug:.*}", method = RequestMethod.GET)
    public String loadUpdateUser(@PathVariable("userId") long userId) {
        return "upload-User";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<?> multiUploadFileModel(@RequestBody User model) {

        return new ResponseEntity("Successfully uploaded!", HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseEntity<?> updateUser(@RequestBody User model) {

        return new ResponseEntity("Successfully uploaded!", HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{userId:[0-9]+}{slug:.*}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteUser(@PathVariable("userId") long userId) {

        return new ResponseEntity("Successfully uploaded!", HttpStatus.OK);
    }
}
