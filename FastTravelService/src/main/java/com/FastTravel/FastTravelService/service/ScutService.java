package com.FastTravel.FastTravelService.service;

import com.FastTravel.FastTravelService.repository.ScutRepository;
import com.FastTravel.FastTravelService.model.Scut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ScutService {
    @Autowired
    private ScutRepository scutRepository;

    public Scut saveScut(Scut scut){
        return scutRepository.save(scut);
    }

    public List<Scut> saveScuts(List<Scut> scuts) {
        return scutRepository.saveAll(scuts);
    }

    public List<Scut> getScuts(){
        return scutRepository.findAll();
    }

    public Scut getScutById(Long id) {
        return scutRepository.findById(id).orElse(null);
    }

    public String deleteScut(Long id) {
        scutRepository.deleteById(id);
        return "scut removed !! " + id;
    }

    
    public Scut updateScut(Scut scut) {
        Scut existingScut = scutRepository.findById(scut.getId()).orElse(null);
        existingScut.setDescription(scut.getDescription());
        existingScut.setInstalationDate(scut.getInstalationDate());
        existingScut.setLatitude(scut.getLatitude());
        existingScut.setLongitude(scut.getLongitude());
        existingScut.setPassages(scut.getPassages());
        existingScut.setPrice1(scut.getPrice1());
        existingScut.setPrice2(scut.getPrice2());
        existingScut.setPrice3(scut.getPrice3());
        existingScut.setPrice4(scut.getPrice4());
        existingScut.setPrice5(scut.getPrice5());
        return scutRepository.save(existingScut);
    }
}
