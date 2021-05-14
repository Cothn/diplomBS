package org.atsynthesizer.demo.controller;

import org.atsynthesizer.demo.entity.Audiobook;
import org.atsynthesizer.demo.entity.Comment;
import org.atsynthesizer.demo.entity.User;
import org.atsynthesizer.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Objects;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/me", method = RequestMethod.GET)
    public String getMyUserPage(Model model, @AuthenticationPrincipal UserDetails currentUser) {
        User user = userService.getByNickname(currentUser.getUsername());

        model.addAttribute("userInfo", user);
        return "userPage";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getUserPage(Model model, @AuthenticationPrincipal UserDetails currentUser,
                              @PathVariable("id") Long id) {
        User user = userService.getById(id);

        model.addAttribute("userInfo", user);
        return "userPage";
    }

    @RequestMapping(value = "/me/edit", method = RequestMethod.GET)
    public String getUserEditPage(Model model, @RequestParam(name = "error", required = false) Byte error, @AuthenticationPrincipal UserDetails currentUser) {
        User user = userService.getByNickname(currentUser.getUsername());
        if (!Objects.isNull(error)) {

            switch (error){
                case 1:
                    model.addAttribute("errorMessage", "Пароли не совпадают");
                    break;
                case 2:
                    model.addAttribute("errorMessage", "Пользователь с таким именем уже существует");
                    break;
            }
        }
        model.addAttribute("userInfo", user);
        return "userEditPage";
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("userForm") @Valid User userForm, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "redirect:/registration";
        }
        if (!userForm.getPassword().equals(userForm.getPasswordConfirm())){
            model.addAttribute("errorMessage", "Пароли не совпадают");
            return "registrationPage";
        }
        if (!userService.add(userForm)){
            model.addAttribute("errorMessage", "Пользователь с таким именем уже существует");
            return "registrationPage";
        }

        return "redirect:/login";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.PUT)
    public String editUser(@RequestBody User userForm) {

        if (!userForm.getPassword().equals(userForm.getPasswordConfirm())){
            return "redirect:/user/me/edit?error=1";
        }
        if (!userService.edit(userForm)){
            return "redirect:/user/me/edit?error=2";
        }

        return "redirect:/user/me";
    }


}