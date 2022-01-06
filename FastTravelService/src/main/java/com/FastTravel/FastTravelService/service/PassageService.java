package com.FastTravel.FastTravelService.service;

import com.FastTravel.FastTravelService.repository.PassageRepository;
import com.FastTravel.FastTravelService.model.Passage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PassageService{
    @Autowired
    private PassageRepository passageRepository;
    
    public Passage savePassage(Passage passage){
        return passageRepository.save(passage);
    }

    public List<Passage> savePassages(List<Passage> passages) {
        return passageRepository.saveAll(passages);
    }

    public List<Passage> getPassages(){
        return passageRepository.findAll();
    }

    public Passage getPassageById(Long id) {
        return passageRepository.findById(id).orElse(null);
    }

    public String deletePassage(Long id) {
        passageRepository.deleteById(id);
        return "passage removed !! " + id;
    }

    public Passage updatePassage(Passage passage) {
        Passage existingPassage = passageRepository.findById(passage.getId()).orElse(null);
        existingPassage.setDate(passage.getDate());
        existingPassage.setTime(passage.getTime());
        existingPassage.setPaymentState(passage.getPaymentState());
        existingPassage.setIdentifier(passage.getIdentifier());
        existingPassage.setScut(passage.getScut());
        return passageRepository.save(existingPassage);
    }
}
