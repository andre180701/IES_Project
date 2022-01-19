package com.FastTravel.FastTravelService.controller.admin;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

import com.FastTravel.FastTravelService.model.Passage;
import com.FastTravel.FastTravelService.repository.PassageRepository;
import com.FastTravel.FastTravelService.controller.PassageController;

import java.util.*;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpSession;  

@Controller
//@EnableJpaRepositories(basePackageClasses = {PassageRepository.class})
public class PassagesController {
    @Autowired
    ObjectFactory<HttpSession> httpSessionFactory;

    @Autowired
    private PassageController passageController;

    //@CrossOrigin(origins = "http://localhost:8000/")
    @GetMapping("admin/passages")
    public String getAllPassages( Model model) {
        HttpSession session = httpSessionFactory.getObject();

        model.addAttribute("firstName", session.getAttribute("firstName"));
        model.addAttribute("lastName", session.getAttribute("lastName"));
        model.addAttribute("email", session.getAttribute("email"));
        List<Passage> passages = passageController.findAllPassages();
		model.addAttribute("passages", passages);
		return "admin/passages";
    }   
    @PostMapping("admin/passages")
    public  @Valid Passage createPassage(@Valid @RequestBody Passage passage){
        return passageController.addPassage(passage);
    }
}