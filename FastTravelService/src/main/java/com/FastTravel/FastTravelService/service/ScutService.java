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
        scut.setDescription(existingScut.getDescription());
        scut.setInstalationDate(existingScut.getInstalationDate());
        scut.setLatitude(existingScut.getLatitude());
        scut.setLongitude(existingScut.getLongitude());
        scut.setPassages(existingScut.getPassages());
        scut.setPrice1(existingScut.getPrice1());
        scut.setPrice2(existingScut.getPrice2());
        scut.setPrice3(existingScut.getPrice3());
        scut.setPrice4(existingScut.getPrice4());
        scut.setPrice5(existingScut.getPrice5());
        return scutRepository.save(existingScut);
    }
}
