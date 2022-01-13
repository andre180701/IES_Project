package com.FastTravel.FastTravelService.controller;

import com.FastTravel.FastTravelService.model.Identifier;
import com.FastTravel.FastTravelService.service.IdentifierService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class IdentifierController {
    @Autowired
    private IdentifierService identifierService;

    @PostMapping("/addIdentifier")
    public Identifier addIdentifier(@RequestBody Identifier identifier) {
        return identifierService.saveIdentifier(identifier);
    }

    @PostMapping("/addIdentifiers")
    public List<Identifier> addIdentifiers(@RequestBody List<Identifier> identifiers) {
        return identifierService.saveIdentifiers(identifiers);
    }

    @GetMapping("/identifiers")
    public List<Identifier> findAllIdentifiers() {
        return identifierService.getIdentifiers();
    }

    @GetMapping("/identifierById/{id}")
    public Identifier findIdentifierById(@PathVariable Long id) {
        return identifierService.getIdentifierById(id);
    }

    
    @PutMapping("/update/identifier")
    public Identifier updateIdentifier(@RequestBody Identifier identifier) {
        return identifierService.updateIdentifier(identifier);
    }

    @DeleteMapping("/deleteIdentifier/{id}")
    public String deleteIdentifier(@PathVariable Long id) {
        return identifierService.deleteIdentifier(id);
    }    
}
