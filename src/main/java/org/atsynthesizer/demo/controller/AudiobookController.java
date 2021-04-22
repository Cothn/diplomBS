package org.atsynthesizer.demo.controller;

import org.atsynthesizer.demo.entity.Audiobook;
import org.atsynthesizer.demo.service.AudiobookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("audiobook")
public class AudiobookController {

    private AudiobookService audiobookService;

    @Autowired
    public void setAudiobookService(AudiobookService audiobookService) {
        this.audiobookService = audiobookService;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String  editAudiobook(@ModelAttribute("audiobookInfo") Audiobook audiobook, Model model) {

        audiobookService.edit(audiobook);

        return "redirect:/audiobooks";
    }

    
    /*
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String showBankAudiobooks(@RequestParam(defaultValue = "0") int pageNum, Model model) {

        Pageable page = PageRequest.of(pageNum, 10, Sort.by("title").ascending());

        Page<Audiobook> audiobooks = audiobookService.allAudiobooks(page);

        model.addAttribute("audiobooksInfos", audiobooks.getContent());
        model.addAttribute("lastPage", audiobooks.getTotalPages());
        model.addAttribute("currentPage", pageNum);

        return "audiobooksPage";
    }*/

}
