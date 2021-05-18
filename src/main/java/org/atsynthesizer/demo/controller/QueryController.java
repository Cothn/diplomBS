package org.atsynthesizer.demo.controller;

import org.atsynthesizer.demo.entity.Audiobook;
import org.atsynthesizer.demo.entity.Comment;
import org.atsynthesizer.demo.entity.User;
import org.atsynthesizer.demo.service.AudiobookService;
import org.atsynthesizer.demo.service.CommentService;
import org.atsynthesizer.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@Controller
@RequestMapping("query")
public class QueryController {

    @Autowired
    private AudiobookService audiobookService;

    @Autowired
    private UserService userService;

    @Autowired
    private CommentService commentService;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addComment(
            @RequestParam(required = true) Long audiobookId,
            @RequestParam(required = true) String oldUrl,
            @AuthenticationPrincipal UserDetails currentUser,
            Model model) {



        if(oldUrl.isEmpty()){
            return "redirect:/audiobook/"+audiobookId;
        }

        return "redirect:"+oldUrl;
    }







}