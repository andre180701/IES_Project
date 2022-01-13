package com.FastTravel.FastTravelService.controller.admin;


import com.FastTravel.FastTravelService.controller.PassageController;
import com.FastTravel.FastTravelService.model.Client;
import com.FastTravel.FastTravelService.model.Passage;
import com.FastTravel.FastTravelService.repository.PassageRepository;
import com.FastTravel.FastTravelService.service.ClientService;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import javax.validation.Valid;
import java.util.*;
import org.springframework.beans.factory.ObjectFactory;
import javax.servlet.http.HttpSession;  

@Controller
//@EnableJpaRepositories(basePackageClasses = {PassageRepository.class})
public class PassagesController {
    @Autowired
    ObjectFactory<HttpSession> httpSessionFactory;

    @Autowired
     private ClientService clientService;

    @Autowired
    private PassageController passageController;


    @Autowired
    private PassageRepository passageRepository;

    //@CrossOrigin(origins = "http://localhost:8000/")
    @GetMapping("admin/passages")
    public String getAllPassages( Model model) {
        HttpSession session = httpSessionFactory.getObject();
        String email = (String) session.getAttribute("email");

        model.addAttribute("firstName", session.getAttribute("firstName"));
        model.addAttribute("lastName", session.getAttribute("lastName"));
        model.addAttribute("email", session.getAttribute("email"));
        List<Passage> passages = passageRepository.findAll();
		model.addAttribute("passages", passages);

        Client client = clientService.getClientByEmail(email);

        List<Passage> passages_client = new ArrayList<Passage>();

        for (Passage passage : passages) {
            if ( passage.getIdentifier().getClient().getId() == client.getId() ) {
            passages_client.add(passage);
        }
    }

    model.addAttribute("passages", passages_client);
		return "admin/passages";
    }   

    @PostMapping("admin/passages")
    public  @Valid Passage createPassage(@Valid @RequestBody Passage passage){
        return passageRepository.save(passage);
    }

}
