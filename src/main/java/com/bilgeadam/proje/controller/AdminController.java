package com.bilgeadam.proje.controller;

import com.bilgeadam.proje.dto.FoodDto;
import com.bilgeadam.proje.dto.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminController {

    @RequestMapping(value = "/dashboard", method = {RequestMethod.GET, RequestMethod.POST})
    public String showDashboardPage() {

        return "admin/Dashboard";
    }

    @RequestMapping(value = "/manage-roles", method = {RequestMethod.GET, RequestMethod.POST})
    public String showManageRolesPage() {

        return "admin/ManageRoles";
    }

    @RequestMapping(value = "/manage-user", method = {RequestMethod.GET, RequestMethod.POST})
    public String showManageUserPage() {

        return "admin/ManageUser";
    }

    @RequestMapping(value = "/add-user", method = {RequestMethod.GET, RequestMethod.POST})
    public String showAddUserPage(@ModelAttribute(value = "user") UserDto userDto) {

        return "admin/AddUser";
    }

    @RequestMapping(value = "/manage-food", method = {RequestMethod.GET, RequestMethod.POST})
    public String showManageFoodPage() {

        return "admin/ManageFood";
    }

    @RequestMapping(value = "/add-food", method = {RequestMethod.GET, RequestMethod.POST})
    public String showAddFoodPage(@ModelAttribute("food") FoodDto foodDto) {

        return "admin/AddFood";
    }
}
