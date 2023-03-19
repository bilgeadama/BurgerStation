package com.bilgeadam.proje.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class AdminController {

    @RequestMapping(value = "/manage-roles" ,method = {RequestMethod.GET,RequestMethod.POST})
    public String showManageRoles(){

        return "admin/ManageRoles";
    }

    @RequestMapping(value = "/manage-roles" ,method = {RequestMethod.GET,RequestMethod.POST})
    public String showManageUser(){

        return "admin/ManageUser";
    }

    @PostMapping(value = "/add-user")
    public String addUser(){

        return "admin/AddUSer";
    }
}
