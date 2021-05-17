package org.atsynthesizer.demo.controller;

import org.apache.commons.lang3.RandomStringUtils;
import org.atsynthesizer.demo.entity.*;
import org.atsynthesizer.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Controller
@RequestMapping("audiobook")
public class AudiobookController {

    @Value("${upload.path}")
    private String UPLOAD_DIR;

    @Autowired
    private AudiobookService audiobookService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private AudiobookFileService audiobookFileService;

    @Autowired
    private UserService userService;

    @Autowired
    private CreatorService creatorService;

    @Autowired
    public void setAudiobookService(AudiobookService audiobookService) {
        this.audiobookService = audiobookService;
    }


    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String  addAudiobook(
            @RequestParam(required = false) MultipartFile picture,
            @RequestParam(required = true) List<String> authors,
            @RequestParam(required = true) List<String> performers,
            @AuthenticationPrincipal UserDetails currentUser,
            @ModelAttribute("audiobookInfo") Audiobook audiobook, Model model) throws IOException {

        if((!picture.isEmpty()) && (picture.getSize() != 0)) {
            audiobook.setPicturePath(audiobookFileService.saveUploadedFile(picture, audiobook.getUser()));
            if (audiobook.getPicturePath().isEmpty()) {
                return "redirect:/audiobooks/add";
            }
        }

        List<Creator> creators = new ArrayList<Creator>();
        if(!authors.isEmpty()) {
            for (String author: authors) {
                Creator creator = new Creator();
                creator.setAuthor(true);
                creator.setTitle(author);
                creators.add(creatorService.add(creator));
            }
        }
        else{
            return "redirect:/audiobooks/edit";
        }
        if(!performers.isEmpty()) {
            for (String performer: performers) {
                Creator creator = new Creator();
                creator.setAuthor(false);
                creator.setTitle(performer);
                creatorService.add(creator);
                creators.add(creatorService.add(creator));
            }
        }
        else{
            return "redirect:/audiobooks/edit";
        }
        audiobook.setAudiobookCreators(creators);

        audiobookService.edit(audiobook);

        return "redirect:/audiobook/"+audiobook.getId();
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String  addAudiobook(
            @RequestParam(required = false) MultipartFile picture,
            @RequestParam(required = true) MultipartFile audiobookFileStream,
            @RequestParam(required = true) List<String> authors,
            @RequestParam(required = true) List<String> performers,
            @AuthenticationPrincipal UserDetails currentUser,
            @ModelAttribute("audiobookInfo") Audiobook audiobook, Model model) throws IOException {

        if((!picture.isEmpty()) && (picture.getSize() != 0))  {
            audiobook.setPicturePath(audiobookFileService.saveUploadedFile(picture, currentUser));
            if (audiobook.getPicturePath().isEmpty()) {
                return "redirect:/audiobooks/add";
            }
        }
        if((!audiobookFileStream.isEmpty()) && (audiobookFileStream.getSize() != 0))  {
            String filePath =audiobookFileService.saveUploadedFile(audiobookFileStream, currentUser);
            if (filePath.isEmpty()){
                return "redirect:/audiobooks/add";
            }
            String fileExt = filePath.substring(filePath.lastIndexOf('.'));
            AudiobookFile audiobookFile = new AudiobookFile();
            audiobookFile.setExtension(fileExt);
            audiobookFile.setFilePath(filePath);
            audiobookFile.setSize(audiobookFileService.getFileSize(new File( UPLOAD_DIR+ filePath)));

            audiobook.setAudiobookFile(audiobookFileService.add(audiobookFile));
        }
        else{
            return "redirect:/audiobooks/add";
        }
        List<Creator> creators = new ArrayList<Creator>();
        if(!authors.isEmpty()) {
            for (String author: authors) {
                Creator creator = new Creator();
                creator.setAuthor(true);
                creator.setTitle(author);
                creators.add(creatorService.add(creator));
            }
        }
        else{
            return "redirect:/audiobooks/add";
        }
        if(!performers.isEmpty()) {
            for (String performer: performers) {
                Creator creator = new Creator();
                creator.setAuthor(false);
                creator.setTitle(performer);
                creatorService.add(creator);
                creators.add(creatorService.add(creator));
            }
        }
        else{
            return "redirect:/audiobooks/add";
        }
        audiobook.setAudiobookCreators(creators);

        User user = userService.getByNickname(currentUser.getUsername());
        audiobook.setUser(user);

        if(user.getRole().getTitle().equals("ROLE_ADMIN")){
            audiobook.setDistributed(true);
        }

        Timestamp ts = Timestamp.from(Instant.now());
        audiobook.setAddDate(ts);
        audiobook.setRating(0d);

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
        audiobook.getComments().sort(Comparator.comparing(Comment::getSendDateTime));
        model.addAttribute("audiobookInfo", audiobook);


        Comment  comment= new Comment();
        model.addAttribute("newComment", comment);
        return "audiobookDetailsPage";
    }

}
