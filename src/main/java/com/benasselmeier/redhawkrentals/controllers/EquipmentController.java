package com.benasselmeier.redhawkrentals.controllers;

import com.benasselmeier.redhawkrentals.models.Category;
import com.benasselmeier.redhawkrentals.models.Equipment;
import com.benasselmeier.redhawkrentals.models.data.CategoryDao;
import com.benasselmeier.redhawkrentals.models.data.EquipmentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

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

    @Autowired
    private CategoryDao categoryDao;

    @RequestMapping("/all")
    public String listAllEquipment(Model model) {

        model.addAttribute("equipment", equipmentDao.findAll());
        model.addAttribute("title", "All Equipment");

        return "rentals/all";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String displayAddEquipmentForm(Model model) {
        model.addAttribute("title", "Add Equipment");
        model.addAttribute(new Equipment());
        model.addAttribute("categories", categoryDao.findAll());
        return "rentals/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String processAddEquipmentForm(@ModelAttribute
                                          @Valid Equipment newEquipment,
                                          Errors errors,
                                          @RequestParam int categoryId,
                                          Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Equipment");
            return "rentals/add";
        }

        Category cat = categoryDao.findOne(categoryId);
        newEquipment.setCategory(cat);
        equipmentDao.save(newEquipment);
        return "redirect:/rentals/add";
    }
}
