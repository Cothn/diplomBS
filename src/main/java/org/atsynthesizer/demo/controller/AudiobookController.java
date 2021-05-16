package org.atsynthesizer.demo.controller;

import org.apache.commons.lang3.RandomStringUtils;
import org.atsynthesizer.demo.entity.*;
import org.atsynthesizer.demo.service.AudiobookFileService;
import org.atsynthesizer.demo.service.AudiobookService;
import org.atsynthesizer.demo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@Controller
@RequestMapping("audiobook")
public class AudiobookController {

    @Autowired
    private AudiobookService audiobookService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private AudiobookFileService audiobookFileService;

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
    public String  addAudiobook(
            @RequestParam(required = true) MultipartFile picture,
            @RequestParam(required = true) MultipartFile audiobookFileStream,
            @RequestParam(required = true) List<String> authors,
            @RequestParam(required = true) List<String> performers,
            @AuthenticationPrincipal UserDetails currentUser,
            @ModelAttribute("audiobookInfo") Audiobook audiobook, Model model) throws IOException {

        if(!picture.isEmpty()) {
            audiobook.setPicturePath(audiobookFileService.saveUploadedFile(picture, currentUser));
            if (audiobook.getPicturePath().isEmpty()) {
                return "redirect:/audiobooks/add";
            }
        }
        if(audiobookFileStream.isEmpty()) {
            String filePath =audiobookFileService.saveUploadedFile(audiobookFileStream, currentUser);
            if (audiobookFileService.saveUploadedFile(picture, currentUser).isEmpty()){
                return "redirect:/audiobooks/add";
            }
            String fileExt = filePath.substring(filePath.lastIndexOf('.'));
            AudiobookFile audiobookFile = new AudiobookFile();
            audiobookFile.setExtension(fileExt);
            audiobookFile.setFilePath(filePath);

            audiobookFile.setSize(audiobookFileService.getFileSize(new File(filePath)));
            audiobook.setAudiobookFile(audiobookFile);
        }
        else{
            return "redirect:/audiobooks/add";
        }
        if(!authors.isEmpty()) {
            for (String author: authors) {

            }
            if (audiobook.getPicturePath().isEmpty()) {
                return "redirect:/audiobooks/add";
            }
        }
        else{
            return "redirect:/audiobooks/add";
        }

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
