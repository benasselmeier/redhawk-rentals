package com.benasselmeier.redhawkrentals.controllers;

import com.benasselmeier.redhawkrentals.models.User;
import com.benasselmeier.redhawkrentals.models.data.EquipmentDao;
import com.benasselmeier.redhawkrentals.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("")
public class UserController {

    @Autowired
    private EquipmentDao equipmentDao;

    @Autowired
    private UserDao userDao;

    // Request path: /home
    @RequestMapping("/home")
    public String index(Model model) {

        //will temporarily display a list of all users in the database.
        //this will be removed with the implementation of user logins.

        model.addAttribute("title", "All Users");
        model.addAttribute("users", userDao.findAll());

        return "user/home";
    }

    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
    public String display_user(Model model, @PathVariable int userId) {

        User user = userDao.findOne(userId);
        model.addAttribute("title", user.getName());
        model.addAttribute("rentals", user.getRentals());
        model.addAttribute("userId", user.getId());

        return "user/profile";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String displaySignupForm(Model model) {
        model.addAttribute("title", "Sign Up");
        model.addAttribute(new User());
        return "user/signup";
    }
}
