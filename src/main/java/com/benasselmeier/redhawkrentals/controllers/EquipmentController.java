package com.benasselmeier.redhawkrentals.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("rentals")
public class EquipmentController {

    @RequestMapping("/home")
    public String index(Model model) {

        //add the list of equipment that is currently rented to the user to the model to be displayed here.

        return "rentals/home";
    }

    @RequestMapping("/all")
    public String list_equipment(Model model) {
        model.addAttribute("equipment", equipmentDao.findall());

        return "rentals/all";
    }
}
