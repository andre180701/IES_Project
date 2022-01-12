package com.FastTravel.FastTravelService.controller;

import com.FastTravel.FastTravelService.model.Passage;
import com.FastTravel.FastTravelService.service.PassageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class PassageController {
    @Autowired
    private PassageService passageService;

    @PostMapping("/addPassage")
    public Passage addPassage(@RequestBody Passage passage) {
        return passageService.savePassage(passage);
    }

    @PostMapping("/addPassages")
    public List<Passage> addPassages(@RequestBody List<Passage> passages) {
        return passageService.savePassages(passages);
    }

    @GetMapping("/passages")
    public List<Passage> findAllPassages() {
        return passageService.getPassages();
    }

    @GetMapping("/passageById/{id}")
    public Passage findPassageById(@PathVariable Long id) {
        return passageService.getPassageById(id);
    }

    
    @PutMapping("/update")
    public Passage updatePassage(@RequestBody Passage passage) {
        return passageService.updatePassage(passage);
    }

    @DeleteMapping("/deletePassage/{id}")
    public String deletePassage(@PathVariable Long id) {
        return passageService.deletePassage(id);
    }    
}
