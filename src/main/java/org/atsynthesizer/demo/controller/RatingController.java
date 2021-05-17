package org.atsynthesizer.demo.controller;

import org.apache.coyote.Response;
import org.atsynthesizer.demo.entity.Audiobook;
import org.atsynthesizer.demo.entity.Rating;
import org.atsynthesizer.demo.entity.User;
import org.atsynthesizer.demo.service.AudiobookService;
import org.atsynthesizer.demo.service.RatingService;
import org.atsynthesizer.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("rating")
public class RatingController {

    @Autowired
    private AudiobookService audiobookService;

    @Autowired
    private UserService userService;

    @Autowired
    private RatingService ratingService;

    @GetMapping("/edit")
    public ResponseEntity<String> editRating(
            @RequestParam(required = true) Long audiobookId,
            @RequestParam(required = true) int rating,
            @AuthenticationPrincipal UserDetails currentUser,
            Model model) {

        Rating ratingObj = new Rating();
        ratingObj.setAudiobookId(audiobookId);
        User user = userService.getByNickname(currentUser.getUsername());
        ratingObj.setUserId(user.getId());
        ratingObj.setValue(rating);
        ratingService.edit(ratingObj);

        Audiobook audiobook = audiobookService.getById(audiobookId);
        return ResponseEntity.ok(audiobook.getRating().toString());
    }




}