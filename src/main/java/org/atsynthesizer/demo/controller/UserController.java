package org.atsynthesizer.demo.controller;

import org.atsynthesizer.demo.entity.User;
import org.atsynthesizer.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registrationPage";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String getEditPage(Model model) {
        model.addAttribute("userForm", new User());

        return "editUserPage";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("userForm") @Valid User userForm, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "registrationPage";
        }
        if (!userForm.getPassword().equals(userForm.getPasswordConfirm())){
            model.addAttribute("passwordError", "Пароли не совпадают");
            return "registrationPage";
        }
        if (!userService.add(userForm)){
            model.addAttribute("usernameError", "Пользователь с таким именем уже существует");
            return "registrationPage";
        }

        return "redirect:/login";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editUser(@ModelAttribute("userForm") @Valid User userForm, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "editUserPage";
        }
        if (!userForm.getPassword().equals(userForm.getPasswordConfirm())){
            model.addAttribute("passwordError", "Пароли не совпадают");
            return "editUserPage";
        }
        if (!userService.edit(userForm)){
            model.addAttribute("usernameError", "Пользователь с таким именем уже существует");
            return "editUserPage";
        }

        return "redirect:/userPage";
    }
}