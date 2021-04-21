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
public class AudiobookController {

    private AudiobookService audiobookService;

    @Autowired
    public void setAudiobookService(AudiobookService audiobookService) {
        this.audiobookService = audiobookService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String showBankAudiobooks(@RequestParam(defaultValue = "0") int pageNum, Model model) {

        Pageable page = PageRequest.of(pageNum, 10, Sort.by("title").ascending());

        Page<Audiobook> audiobooks = audiobookService.allAudiobooks(page);

        model.addAttribute("audiobooksInfos", audiobooks.getContent());
        model.addAttribute("lastPage", audiobooks.getTotalPages()-1);
        model.addAttribute("currentPage", pageNum);

        return "audiobooksPage";
    }

}
