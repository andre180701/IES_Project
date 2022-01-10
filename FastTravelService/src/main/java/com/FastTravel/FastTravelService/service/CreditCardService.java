package com.FastTravel.FastTravelService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.FastTravel.FastTravelService.model.CreditCard;
import com.FastTravel.FastTravelService.repository.CreditCardRepository;

public class CreditCardService {
    @Autowired
    private CreditCardRepository CreditCardRepository;

    public CreditCard saveCreditCard(CreditCard CreditCard){
        return CreditCardRepository.save(CreditCard);
    }

    public List<CreditCard> saveCreditCards(List<CreditCard> CreditCards) {
        return CreditCardRepository.saveAll(CreditCards);
    }

    public List<CreditCard> getCreditCards(){
        return CreditCardRepository.findAll();
    }

    public CreditCard getCreditCardById(Long id) {
        return CreditCardRepository.findById(id).orElse(null);
    }

    public String deleteCreditCard(Long id) {
        CreditCardRepository.deleteById(id);
        return "CreditCard removed !! " + id;
    }

    public CreditCard updateCreditCard(CreditCard creditCard){
        CreditCard existingCreditCard = CreditCardRepository.findById(creditCard.getId()).orElse(null);
        creditCard.setCvv(existingCreditCard.getCvv());
        creditCard.setExpirationDate(existingCreditCard.getExpirationDate());
        creditCard.setIdentifiers(existingCreditCard.getIdentifiers());
        creditCard.setName(existingCreditCard.getName());
        creditCard.setNumber(existingCreditCard.getNumber());
        creditCard.setPais(existingCreditCard.getPais());
        return CreditCardRepository.save(existingCreditCard);

    }
    
}
