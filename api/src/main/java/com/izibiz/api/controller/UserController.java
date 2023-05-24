package com.izibiz.api.controller;


import com.izibiz.api.context.Context;
import com.izibiz.service.service.RoleService;
import com.izibiz.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private Context context;

    public void listUsers() {
        userService.listUsers().forEach(System.out::println);
    }

}
