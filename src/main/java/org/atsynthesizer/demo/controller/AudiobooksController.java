package org.atsynthesizer.demo.controller;

import org.atsynthesizer.demo.entity.*;
import org.atsynthesizer.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("audiobooks")
public class AudiobooksController {

    private static int PAGINATION_SIZE = 1;

    private AudiobookService audiobookService;

    @Autowired
    public void setAudiobookService(AudiobookService audiobookService) {
        this.audiobookService = audiobookService;
    }

    @Autowired
    private GenreService genreService;

    @Autowired
    private CreatorService creatorService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String showAllAudiobooks(@RequestParam(defaultValue = "0") int pageNum, Model model) {

        Pageable page = PageRequest.of(pageNum, PAGINATION_SIZE, Sort.by("title").ascending());

        Page<Audiobook> audiobooks = audiobookService.allAudiobooks(page);

        model.addAttribute("audiobooksInfos", audiobooks.getContent());
        model.addAttribute("lastPage", audiobooks.getTotalPages());
        model.addAttribute("currentPage", pageNum);

        return "audiobooksPage";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String getClientEditPage(@PathVariable("id") Long id,
                                    @RequestParam(required = false) String message, Model model) {
        if(!Objects.isNull(message)) {
            model.addAttribute("message", message);
        }

        Audiobook audiobook = audiobookService.getById(id);
        model.addAttribute("audiobookInfo", audiobook);
        Iterable<Genre> genres = genreService.allGenres();
        model.addAttribute("allGenres", genres);
        Iterable<Creator> creators = creatorService.allCreators();
        model.addAttribute("allCreators", creators);
        return "audiobookEditPage";
    }


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getClientAddPage(@RequestParam(required = false) String message, Model model) {
        if(!Objects.isNull(message)) {
            model.addAttribute("message", message);
        }

        Audiobook audiobook = audiobookService.getFirst();
        model.addAttribute("audiobookInfo", audiobook);
        Iterable<Genre> genres = genreService.allGenres();
        model.addAttribute("allGenres", genres);
        Iterable<Creator> creators = creatorService.allCreators();
        model.addAttribute("allCreators", creators);
        return "audiobookAddPage";
    }

}
