package com.benasselmeier.redhawkrentals.controllers;

import com.benasselmeier.redhawkrentals.models.Category;
import com.benasselmeier.redhawkrentals.models.data.CategoryRepository;
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
@RequestMapping("category")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    //finds all categories to be displayed

    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("title", "Categories");

        return "category/index";

    }

    //Displays items within a selected category.

    @RequestMapping(value = "view/all", method = RequestMethod.GET)
    public String listCategories(Model model) {
        model.addAttribute("title", "All Categories");
        model.addAttribute("categories", categoryRepository.findAll());
        return "rentals/all-categories";
    }

    //renders the form to add a category

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute(new Category());
        model.addAttribute("title", "Add Category");

        return "category/add";

    }

    //processes the form which adds a category

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(Model model, @ModelAttribute @Valid Category category, Errors errors) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Category");
            model.addAttribute(new Category());
            return "category/add";
        }
        else {
            categoryRepository.save(category);
            return "redirect:";
        }

    }

    //displays an individual category selected from a list by the user.

    @RequestMapping(value = "view/{categoryId}")
    public String displayCategory(Model model, @PathVariable int categoryId) {

        Category cat = categoryRepository.findOne(categoryId);
        model.addAttribute("title", cat.getName());
        model.addAttribute("equipment", cat.getEquipment());
        model.addAttribute("categoryId", cat.getId());
        return "category/view";
    }
}
