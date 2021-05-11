package org.atsynthesizer.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    //Мы могли бы расписать эти 2 маппинга отдельно, но смысла дублировать одинаковый код нет.
    // этот метод будет слушать запросы на "/" и "/index"
    @GetMapping(value = {"/", "/index"})
    public String index() {
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

}