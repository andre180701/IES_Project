package com.FastTravel.FastTravelService.controller;

import com.FastTravel.FastTravelService.repository.*;
import com.FastTravel.FastTravelService.model.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@EnableJpaRepositories(basePackageClasses = {ScutRepository.class})
@RestController
public class ScutController{
    @Autowired
    private ScutRepository  scutRepository;

    @GetMapping("/scut")
    public List<Scut> getAllScuts(){
        return scutRepository.findAll();
    }

    @PostMapping("/scut")
    public Scut createScut(@RequestBody Scut scut){
        return scutRepository.save(scut);
    }
}