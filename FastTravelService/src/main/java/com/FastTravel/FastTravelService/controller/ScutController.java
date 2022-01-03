package com.FastTravel.FastTravelService.controller;

import com.FastTravel.FastTravelService.repository.*;
import com.FastTravel.FastTravelService.model.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


//@EnableJpaRepositories(basePackageClasses = {ScutRepository.class})
//@RestController
@Controller
public class ScutController{
    @Autowired
    private ScutRepository  scutRepository;

    @GetMapping("/scuts")
    public String getAllScuts(Model model){
        List<Scut> scuts = scutRepository.findAll();
        model.addAttribute("scuts", scuts);
		return "admin/scuts";

    }

    @PostMapping("/scuts")
    public Scut createScut(@RequestBody Scut scut){
        return scutRepository.save(scut);
    }
}