package com.FastTravel.FastTravelService.service;

import com.FastTravel.FastTravelService.repository.PassageRepository;
import com.FastTravel.FastTravelService.model.Passage;
import java.util.*;

public class PassageService{
    private PassageRepository passageRepository;
    
    public Passage savePassages(Passage p){
        return passageRepository.save(p);
    }

    public List<Passage> getPassages(){
        return passageRepository.findAll();
    }
}