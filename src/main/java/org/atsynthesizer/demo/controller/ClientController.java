package com.example.demo.controller;

import com.example.demo.entity.*;
import com.example.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("clients")
public class ClientController {

    private ClientService clientService;

    @Autowired
    public void setClientService(ClientService clientService) {

        this.clientService = clientService;
    }

    private TownService townService;

    @Autowired
    public void setTownService(TownService townService) {

        this.townService = townService;
    }

    private DisabilityService disabilityService;

    @Autowired
    public void setDisabilityService(DisabilityService disabilityService) {

        this.disabilityService = disabilityService;
    }

    private FamilyStatusService  familyStatusService;

    @Autowired
    public void setFamilyStatusService(FamilyStatusService familyStatusService) {
        this.familyStatusService = familyStatusService;
    }

    private NationalityService nationalityService;

    @Autowired
    public void setNationalityService(NationalityService nationalityService) {
        this.nationalityService = nationalityService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String showBankClients(@RequestParam(defaultValue = "1") int page, Model model) {
        List<Client> clients = clientService.allClients(page);

        int clientsCount = clientService.getClientsCount();
        int pagesCount = (clientsCount + 9)/10;
        ArrayList<Boolean> pages= new ArrayList<>(pagesCount);
        for(int i = 0; i<pagesCount; i++) pages.add(true);
        model.addAttribute("clientsInfos", clients);
        model.addAttribute("pages", pages);


        return "clientsPage";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addPage( @RequestParam(required = false) String message, Model model) {
        if(!Objects.isNull(message)) {
            model.addAttribute("message", message);
        }

        List<Town> towns = townService.allTowns();
        model.addAttribute("allTowns", towns);

        List<FamilyStatus> familyStatuses = familyStatusService.allFamilyStatuses();
        model.addAttribute("allFamilyStatuses", familyStatuses);

        List<Disability> disabilities = disabilityService.allDisabilities();
        model.addAttribute("allDisabilities", disabilities);

        List<Nationality> nationalities = nationalityService.allNationalities();
        model.addAttribute("allNationalities", nationalities);

        return "clientAddPage";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String  addClient(@ModelAttribute("clientInfo") Client client) {
        Boolean pensioner= client.getPensioner();
        client.setPensioner(!Objects.isNull(pensioner));
        if(client.getMonthlyIncome().isEmpty())
            client.setMonthlyIncome(null);

        if(clientService.checkByPassport(client)){
            return "redirect:add"+"?message=passport must be unique";
        }
        else if(clientService.checkByIdentifyNumber(client)){
            return "redirect:add"+"?message=identifyNumber must be unique";
        }
        clientService.add(client);
        return "redirect:/clients";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String getClientEditPage(@PathVariable("id") int id,
                                    @RequestParam(required = false) String message, Model model) {
        if(!Objects.isNull(message)) {
            model.addAttribute("message", message);
        }

        Client client = clientService.getById(id);

        model.addAttribute("clientInfo", client);

        List<Town> towns = townService.allTowns();
        model.addAttribute("allTowns", towns);

        List<FamilyStatus> familyStatuses = familyStatusService.allFamilyStatuses();
        model.addAttribute("allFamilyStatuses", familyStatuses);

        List<Disability> disabilities = disabilityService.allDisabilities();
        model.addAttribute("allDisabilities", disabilities);

        List<Nationality> nationalities = nationalityService.allNationalities();
        model.addAttribute("allNationalities", nationalities);

        return "clientEditPage";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String  editClient(@ModelAttribute("clientInfo") Client client, Model model) {
        Boolean pensioner= client.getPensioner();
        client.setPensioner(!Objects.isNull(pensioner));
        if(client.getMonthlyIncome().isEmpty())
            client.setMonthlyIncome(null);

        if(clientService.checkByPassport(client)){
            return "redirect:edit/"+client.getId()+"?message=passport must be unique";
        }
        else if(clientService.checkByIdentifyNumber(client)){
            return "redirect:edit/"+client.getId()+"?message=identifyNumber must be unique";
        }
        clientService.edit(client);


        return "redirect:/clients";
    }

    @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
    public String deleteClient(@PathVariable("id") int id) {
        Client client = clientService.getById(id);
        clientService.delete(client);
        return "redirect:/clients";
    }
}
