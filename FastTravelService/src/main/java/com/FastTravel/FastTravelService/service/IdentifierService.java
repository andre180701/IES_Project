package com.FastTravel.FastTravelService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.FastTravel.FastTravelService.model.Identifier;
import com.FastTravel.FastTravelService.repository.IdentifierRepository;

@Service
public class IdentifierService{
    @Autowired
    private IdentifierRepository identifierRepository;
    
    public Identifier saveIdentifier(Identifier identifier){
        return identifierRepository.save(identifier);
    }

    public List<Identifier> saveIdentifiers(List<Identifier> identifiers) {
        return identifierRepository.saveAll(identifiers);
    }

    public List<Identifier> getIdentifiers(){
        return identifierRepository.findAll();
    }

    public Identifier getIdentifierById(Long id) {
        return identifierRepository.findById(id).orElse(null);
    }

    public String deleteIdentifier(Long id) {
        identifierRepository.deleteById(id);
        return "identifier removed !! " + id;
    }

    
    public Identifier updateIdentifier(Identifier identifier) {
        Identifier existingIdentifier = identifierRepository.findById(identifier.getId()).orElse(null);
        identifier.setClasse(existingIdentifier.getClasse());
        identifier.setClient(existingIdentifier.getClient());
        identifier.setCreditCard(existingIdentifier.getCreditCard());
        identifier.setPassages(existingIdentifier.getPassages());
        identifier.setRegistration(existingIdentifier.getRegistration());
        identifier.setState(existingIdentifier.getState());
        return identifierRepository.save(existingIdentifier);
    }
}
