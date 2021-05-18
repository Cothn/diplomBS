package org.atsynthesizer.demo.controller;

import org.atsynthesizer.demo.entity.Audiobook;
import org.atsynthesizer.demo.entity.Comment;
import org.atsynthesizer.demo.entity.Query;
import org.atsynthesizer.demo.entity.User;
import org.atsynthesizer.demo.service.AudiobookService;
import org.atsynthesizer.demo.service.CommentService;
import org.atsynthesizer.demo.service.QueryService;
import org.atsynthesizer.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("query")
public class QueryController {

    private static final int PAGINATION_SIZE = 10;

    @Autowired
    private AudiobookService audiobookService;

    @Autowired
    private UserService userService;

    @Autowired
    private QueryService queryService;

    @RequestMapping(value="/{id}/success", method = RequestMethod.GET)
    public String successQuery(@PathVariable("id") Long id) {
        Query query = queryService.getById(id);

        Audiobook audiobook = query.getAudiobook();
        audiobook.setDistributed(true);
        audiobookService.edit(audiobook);

        queryService.delete(query);
        return "redirect:/query/page";
    }

    @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
    public String deleteQuery(@PathVariable("id") Long id) {
        Query query = queryService.getById(id);
        queryService.delete(query);
        return "redirect:/query/page";
    }

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public String showAllQuery(
            @RequestParam(defaultValue = "0") int pageNum,
            Model model) {

        Pageable page = PageRequest.of(pageNum, PAGINATION_SIZE, Sort.by("sendDateTime").ascending());

        Page<Query> queries = queryService.allQuery(page);

        model.addAttribute("queriesInfos", queries.getContent());
        model.addAttribute("lastPage", queries.getTotalPages());
        model.addAttribute("currentPage", pageNum);

        return "queriesPage";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addQuery(
            @RequestParam(required = true) Long audiobookId,
            @RequestParam(required = true) String oldUrl,
            @AuthenticationPrincipal UserDetails currentUser,
            Model model) {

        Query query = new Query();
        Audiobook audiobook = audiobookService.getById(audiobookId);
        User user = userService.getByNickname(currentUser.getUsername());
        query.setAudiobook(audiobook);
        query.setUser(user);

        Timestamp ts = Timestamp.from(Instant.now());
        query.setSendDateTime(ts);

        if(!queryService.getByUserAndAudiobook(user, audiobook).isPresent()) {
            queryService.add(query);
        }
        if(oldUrl.isEmpty()){
            return "redirect:/audiobook/"+audiobookId;
        }

        return "redirect:"+oldUrl;
    }

}