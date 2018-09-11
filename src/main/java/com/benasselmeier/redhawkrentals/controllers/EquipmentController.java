package com.benasselmeier.redhawkrentals.controllers;

import com.benasselmeier.redhawkrentals.models.Category;
import com.benasselmeier.redhawkrentals.models.Equipment;
import com.benasselmeier.redhawkrentals.models.data.CategoryDao;
import com.benasselmeier.redhawkrentals.models.data.EquipmentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@Controller
@RequestMapping("rentals")
public class EquipmentController {

    @Autowired
    private EquipmentDao equipmentDao;

    @Autowired
    private CategoryDao categoryDao;

    //displays all equipment available for rental

    @RequestMapping("/all")
    public String listAllEquipment(Model model) {

        model.addAttribute("equipment", equipmentDao.findAll());
        model.addAttribute("title", "All Equipment");

        return "rentals/all";
    }

    //add equipment to the catalog

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
                                          @RequestParam int quantity,
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

    //Displays items within a selected category.

    @RequestMapping(value = "categories/all", method = RequestMethod.GET)
    public String listCategories(Model model) {
        model.addAttribute("title", "All Categories");
        model.addAttribute("categories", categoryDao.findAll());
        return "rentals/all-categories";
        }

        @RequestMapping(value= "/search", method = RequestMethod.GET)
    public String displaySearchForm(Model model){

        model.addAttribute("title", "Search");
        return "rentals/search";
    }

    @RequestMapping(value = "/search/results", method = RequestMethod.POST)
    public String processSearchForm(Model model, @RequestParam String searchTerm) {

        model.addAttribute("title", "Search");
        model.addAttribute("searchResults", equipmentDao.findByNameContaining(searchTerm));

        return "rentals/search";
    }
}
