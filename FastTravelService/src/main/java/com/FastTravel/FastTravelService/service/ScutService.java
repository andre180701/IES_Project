package com.FastTravel.FastTravelService.service;

import com.FastTravel.FastTravelService.repository.ScutRepository;
import com.FastTravel.FastTravelService.model.Scut;
import java.util.*;

public class ScutService {
    private ScutRepository scutRepository;
    public Scut saveScut(Scut scut){
        return scutRepository.save(scut);
    }

    public List<Scut> getScuts(){
        return scutRepository.findAll();
    }
}