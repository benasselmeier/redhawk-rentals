/*

Sorting Controller. Returning later.

package com.benasselmeier.redhawkrentals.controllers;

import com.benasselmeier.redhawkrentals.models.Equipment;
import com.benasselmeier.redhawkrentals.models.data.CategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.benasselmeier.redhawkrentals.models.data.EquipmentDao;

@Controller
@RequestMapping("")
public class SortingController {

    @Autowired
    private EquipmentDao equipmentDao;

    @Autowired
    private CategoryDao categoryDao;

    @RequestMapping("/rentals/all/sort-by=?{sortType}")
    public String sortBy(Model model, @PathVariable String sortType) {

        if (sortType == "alpha"){

        }

        model.addAttribute("sorted equipment", equipmentDao.());
        model.addAttribute("title", "All Equipment");

        return "rentals/all";
    }
}
*/
