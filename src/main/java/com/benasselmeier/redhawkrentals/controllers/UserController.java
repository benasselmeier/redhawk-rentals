package com.benasselmeier.redhawkrentals.controllers;

import com.benasselmeier.redhawkrentals.models.Equipment;
import com.benasselmeier.redhawkrentals.models.User;
import com.benasselmeier.redhawkrentals.models.data.EquipmentDao;
import com.benasselmeier.redhawkrentals.models.data.UserDao;
import com.benasselmeier.redhawkrentals.models.forms.UserRentalForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

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

        //displays a list of all users in the database.
        //this will be removed with the implementation of user logins.

        model.addAttribute("title", "Continue as:");
        model.addAttribute("users", userDao.findAll());

        return "user/home";
    }

    //Displays a user's overview page as well as their current rentals.

    @RequestMapping(value = "/user/view/{userId}", method = RequestMethod.GET)
    public String display_user(Model model, @PathVariable int userId) {

        User user = userDao.findOne(userId);
        model.addAttribute("title", "Welcome to Redhawk Rentals, " + user.getName());
        model.addAttribute("rentals", user.getRentals());
        model.addAttribute("userId", user.getId());

        return "user/view";
    }

    //Displays the form by which a user can select equipment to rent.

    @RequestMapping(value = "rentals/rent-item/user={userId}", method = RequestMethod.GET)
    public String rentItem (Model model, @PathVariable int userId) {

        User user = userDao.findOne(userId);

        UserRentalForm form = new UserRentalForm(equipmentDao.findAll(),user);

        model.addAttribute("title", "Rent as: " + user.getName());
        model.addAttribute("form", form);

        return "rentals/rent-item";
    }

    @RequestMapping(value = "rentals/rent-item", method = RequestMethod.POST)
    public String rentItem (Model model, @ModelAttribute @Valid UserRentalForm form, Errors errors) {

        if (errors.hasErrors()) {
            model.addAttribute("form", form);
            return "rentals/rent-item";
        }

        Equipment theEquipment = equipmentDao.findOne(form.getItemId());
        User theUser = userDao.findOne(form.getUserId());
        theUser.addItem(theEquipment);
        userDao.save(theUser);
        return "redirect:rent-item/user=" + theUser.getId();
    }

    //allows adding of a new user to the application.

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String displaySignupForm(Model model) {
        model.addAttribute("title", "Add User");
        model.addAttribute(new User());
        return "user/signup";
    }

   @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String processSignupForm (@ModelAttribute @Valid User newUser,
                                     Errors errors,
                                     Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Sign Up");
            return "/signup";
        }

        userDao.save(newUser);
        return "redirect:/home";



    }
}
