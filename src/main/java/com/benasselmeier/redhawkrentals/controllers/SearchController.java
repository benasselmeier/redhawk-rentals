/*

Sorting Controller. Returning later.

package com.benasselmeier.redhawkrentals.controllers;

import com.benasselmeier.redhawkrentals.models.Equipment;
import com.benasselmeier.redhawkrentals.models.data.CategoryDao;
import com.benasselmeier.redhawkrentals.models.forms.SearchForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.benasselmeier.redhawkrentals.models.data.EquipmentDao;

import java.util.ArrayList;

@Controller
@RequestMapping("search")
public class SearchController {

    @Autowired
    private EquipmentDao equipmentDao;

    @Autowired
    private CategoryDao categoryDao;

   /* @RequestMapping("/results")
    public String search(Model model, @ModelAttribute SearchForm searchForm, @RequestParam String searchTerm) {

        ArrayList<Equipment> equipment;

        equipment = equipmentDao.findByNameContaining(searchForm.getSearchTerm());

        model.addAttribute("equipment", equipment);

        return "rentals/all";
    }




}
*/