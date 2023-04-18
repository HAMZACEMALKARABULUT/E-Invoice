package com.staj.proje.controller;

import com.staj.proje.context.Context;
import com.staj.proje.entity.Role;
import com.staj.proje.entity.User;
import com.staj.proje.service.RoleService;
import com.staj.proje.service.UserService;
import com.staj.proje.utils.InputUtil;
import com.staj.proje.validation.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private Context context;


    public Optional<User> userLoginControl() {
        String mail, password;
        do {
            mail = InputUtil.getInput("Mail Adresi: ");
        }
        while (mail.trim().equals("") || !ValidationUtil.isMail(mail));

        Optional<User> user = userService.findUserBymail(mail);

        if (!user.isPresent()) {
            return Optional.empty();
        }


        do {
            password = InputUtil.getInput("Şifre:");
        }
        while (password.trim().equals("") || !ValidationUtil.isNumber(password));

        if (userService.userAuthentication(user.get(), password)) {
            return user;
        } else {
            return Optional.empty();
        }


    }


    public void registerNewUser() {
        User user = new User();
        String mail, password, name, surname;
        do {
            mail = InputUtil.getInput("Mail Adresi: ");
        }
        while (mail.trim().equals("") || !ValidationUtil.isMail(mail));

        do {
            name = InputUtil.getInput("AD: ");
        }
        while (name.trim().equals("") || !ValidationUtil.isText(name));

        do {
            surname = InputUtil.getInput("SOYAD");
        }
        while (surname.trim().equals("") || !ValidationUtil.isText(surname));

        do {
            password = InputUtil.getInput("Şifre: ");
        }
        while (password.trim().equals("") || !ValidationUtil.isNumber(password));
        user.setName(name);
        user.setSurname(surname);
        user.setMail(mail);
        user.setPassword(password);
        userService.saveUser(user);


    }

    public void listUsers() {
        userService.listUsers().forEach(System.out::println);
    }


    public void addUserRole() {
        roleService.listRoles().forEach(System.out::println);
        String roleId = InputUtil.getInput("Eklemek İstediğiniz kullanıcı rolünün id'sini giriniz .");
        if (ValidationUtil.isNumber(roleId)) {
            List<Role> roleList = new ArrayList<>();
            roleList.add(roleService.findRoleById(Long.parseLong(roleId)));
            User user = context.getCurrentUser().get().getUser();

            user.setRole(roleList);
            userService.saveUser(user);

        } else {
            System.out.println("GEÇERSİZ GİRİŞ .");
        }


    }
}
