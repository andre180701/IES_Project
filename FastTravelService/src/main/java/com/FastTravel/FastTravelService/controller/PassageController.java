package com.FastTravel.FastTravelService.controller;


import com.FastTravel.FastTravelService.model.Passage;
import com.FastTravel.FastTravelService.repository.PassageRepository;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@EnableJpaRepositories(basePackageClasses = {PassageRepository.class})
public class PassageController {
    @Autowired
    private PassageRepository passageRepository;

    //@CrossOrigin(origins = "http://localhost:8000/")
    @GetMapping("/passages")
    public List<Passage> getAllPassages() {
        return passageRepository.findAll();
    }

    @PostMapping("/passages")
    public  @Valid Passage createPassage(@Valid @RequestBody Passage passage){
        return passageRepository.save(passage);
    }

}
