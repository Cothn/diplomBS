package org.atsynthesizer.demo.controller;

import org.atsynthesizer.demo.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

    //Мы могли бы расписать эти 2 маппинга отдельно, но смысла дублировать одинаковый код нет.
    // этот метод будет слушать запросы на "/" и "/index"
    @GetMapping(value = {"/home"})
    public String home()  {
        return "redirect:/audiobooks";
    }

    @GetMapping("/admin")
    public String admin() {
        return "redirect:/audiobooks";
    }

    @GetMapping("/user")
    public String user() {
        return "redirect:/audiobooks";
    }

    @GetMapping("/about")
    public String about() {
        return "/about";
    }

    @GetMapping("/login")
    public String login() {
        return "/login";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registrationPage";
    }


}