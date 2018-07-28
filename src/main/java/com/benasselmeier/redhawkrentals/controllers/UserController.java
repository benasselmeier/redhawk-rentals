package com.benasselmeier.redhawkrentals.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class UserController {

    // Request path: /home
    @RequestMapping("/home")
    public String index() {
        return "user/home";
    }

    @RequestMapping("/user")
    public String display_user() {
        return "user/profile";
    }
}
