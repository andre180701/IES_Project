package com.FastTravel.FastTravelService.controller;


import com.FastTravel.FastTravelService.model.Passage;
import com.FastTravel.FastTravelService.repository.PassageRepository;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import javax.validation.Valid;
import java.util.*;

@Controller
//@EnableJpaRepositories(basePackageClasses = {PassageRepository.class})
public class PassageController {
    @Autowired
    private PassageRepository passageRepository;

    //@CrossOrigin(origins = "http://localhost:8000/")
    @GetMapping("/passages")
    public String getAllPassages( Model model) {
        List<Passage> passages = passageRepository.findAll();

        
        
		model.addAttribute("passages", passages);
		return "passages";
    }   

    @PostMapping("/passages")
    public  @Valid Passage createPassage(@Valid @RequestBody Passage passage){
        return passageRepository.save(passage);
    }

}
