package org.atsynthesizer.demo.controller;

import org.atsynthesizer.demo.entity.Audiobook;
import org.atsynthesizer.demo.entity.Comment;
import org.atsynthesizer.demo.entity.Rating;
import org.atsynthesizer.demo.entity.User;
import org.atsynthesizer.demo.service.AudiobookService;
import org.atsynthesizer.demo.service.CommentService;
import org.atsynthesizer.demo.service.RatingService;
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
import java.sql.Timestamp;
import java.time.Instant;

@Controller
@RequestMapping("comment")
public class CommentController {

    @Autowired
    private AudiobookService audiobookService;

    @Autowired
    private UserService userService;

    @Autowired
    private CommentService commentService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addComment(
            @ModelAttribute("newComment") Comment newComment,
            @AuthenticationPrincipal UserDetails currentUser,
            Model model) {


        User user = userService.getByNickname(currentUser.getUsername());
        newComment.setUser(user);

        Audiobook audiobook = audiobookService.getById(newComment.getAudiobook().getId());
        newComment.setAudiobook(audiobook);

        Timestamp ts = Timestamp.from(Instant.now());
        newComment.setSendDateTime(ts);
        commentService.add(newComment);


        return "redirect:/audiobook/"+newComment.getAudiobook().getId();
    }







}