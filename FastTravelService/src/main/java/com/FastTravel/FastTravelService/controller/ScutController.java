package com.FastTravel.FastTravelService.controller;


import java.util.List;

import com.FastTravel.FastTravelService.model.Scut;
import com.FastTravel.FastTravelService.service.ScutService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ScutController {
    @Autowired
    private ScutService scutService;

    @PostMapping("/addScut")
    public Scut addScut(@RequestBody Scut scut) {
        return scutService.saveScut(scut);
    }

    @PostMapping("/addScuts")
    public List<Scut> addScuts(@RequestBody List<Scut> scuts) {
        return scutService.saveScuts(scuts);
    }

    @GetMapping("/scuts")
    public List<Scut> findAllScuts() {
        return scutService.getScuts();
    }

    @GetMapping("/scutById/{id}")
    public Scut findScutById(@PathVariable Long id) {
        return scutService.getScutById(id);
    }

    
    @PutMapping("/update")
    public Scut updateScut(@RequestBody Scut scut) {
        return scutService.updateScut(scut);
    }

    @DeleteMapping("/deleteScut/{id}")
    public String deleteScut(@PathVariable Long id) {
        return scutService.deleteScut(id);
    }
}
