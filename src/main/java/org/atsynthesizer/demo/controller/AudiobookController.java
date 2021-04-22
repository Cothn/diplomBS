package org.atsynthesizer.demo.controller;

import org.atsynthesizer.demo.entity.Audiobook;
import org.atsynthesizer.demo.entity.Comment;
import org.atsynthesizer.demo.entity.Creator;
import org.atsynthesizer.demo.entity.Genre;
import org.atsynthesizer.demo.service.AudiobookService;
import org.atsynthesizer.demo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@Controller
@RequestMapping("audiobook")
public class AudiobookController {

    private AudiobookService audiobookService;

    @Autowired
    private CommentService commentService;

    @Autowired
    public void setAudiobookService(AudiobookService audiobookService) {
        this.audiobookService = audiobookService;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String  editAudiobook(@ModelAttribute("audiobookInfo") Audiobook audiobook,
                                 Model model) {
        audiobookService.edit(audiobook);

        return "redirect:/audiobooks";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String  addAudiobook(@ModelAttribute("audiobookInfo") Audiobook audiobook,
                                 Model model) {
        Timestamp ts = Timestamp.from(Instant.now());
        audiobook.setAddDate(ts);
        audiobookService.add(audiobook);

        return "redirect:/audiobooks";
    }

    @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
    public String deleteAudiobook(@PathVariable("id") Long id) {
        Audiobook audiobook = audiobookService.getById(id);
        audiobookService.delete(audiobook);
        return "redirect:/audiobooks";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String showAudiobook(@PathVariable("id") Long id, Model model) {

        Audiobook audiobook = audiobookService.getById(id);
        model.addAttribute("audiobookInfo", audiobook);

        Iterable<Comment> comments = commentService.getAllByAudiobookId(id);
        model.addAttribute("commentsInfos", comments);
        return "audiobookDetailsPage";
    }

}
