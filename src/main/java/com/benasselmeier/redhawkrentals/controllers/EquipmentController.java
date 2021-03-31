package com.benasselmeier.redhawkrentals.controllers;

import com.benasselmeier.redhawkrentals.models.Category;
import com.benasselmeier.redhawkrentals.models.Equipment;
import com.benasselmeier.redhawkrentals.models.data.CategoryRepository;
import com.benasselmeier.redhawkrentals.models.data.EquipmentRepository;
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
    private EquipmentRepository equipmentRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    //displays all equipment available for rental

    @RequestMapping("/all")
    public String listAllEquipment(Model model) {

        model.addAttribute("equipment", equipmentRepository.findAll());
        model.addAttribute("title", "All Equipment");

        return "rentals/all";
    }

    //add equipment to the catalog

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String displayAddEquipmentForm(Model model) {
        model.addAttribute("title", "Add Equipment");
        model.addAttribute(new Equipment());
        model.addAttribute("categories", categoryRepository.findAll());
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

        Category cat = categoryRepository.findOne(categoryId);
        newEquipment.setCategory(cat);
        equipmentRepository.save(newEquipment);
        return "redirect:/rentals/add";
    }

     //Search functionality

        @RequestMapping(value= "/search", method = RequestMethod.GET)
    public String displaySearchForm(Model model){

        model.addAttribute("title", "Search");
        return "rentals/search";
    }

    @RequestMapping(value = "/search/results", method = RequestMethod.POST)
    public String processSearchForm(Model model, @RequestParam String searchTerm) {

        model.addAttribute("title", "Search");
        model.addAttribute("searchResults", equipmentRepository.findByNameContaining(searchTerm));

        return "rentals/search";
    }
}
