package com.benasselmeier.redhawkrentals.controllers;

import com.benasselmeier.redhawkrentals.models.data.EquipmentDao;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private EquipmentDao equipmentDao;

    @RequestMapping("/all")
    public String listAllEquipment(Model model) {

        model.addAttribute("equipment", equipmentDao.findAll());
        model.addAttribute("title", "All Equipment");

        return "rentals/all";
    }
}
