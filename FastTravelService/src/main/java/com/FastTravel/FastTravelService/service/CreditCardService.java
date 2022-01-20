package com.FastTravel.FastTravelService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.FastTravel.FastTravelService.model.CreditCard;
import com.FastTravel.FastTravelService.repository.CreditCardRepository;

@Service
public class CreditCardService{
    @Autowired
    private CreditCardRepository creditCardRepository;
    
    public CreditCard saveCreditCard(CreditCard creditCard){
        return creditCardRepository.save(creditCard);
    }

    public List<CreditCard> saveCreditCards(List<CreditCard> creditCards) {
        return creditCardRepository.saveAll(creditCards);
    }

    public List<CreditCard> getCreditCards(){
        return creditCardRepository.findAll();
    }

    public CreditCard getCreditCardById(Long id) {
        return creditCardRepository.findById(id).orElse(null);
    }

    public String deleteCreditCard(Long id) {
        creditCardRepository.deleteById(id);
        return "creditCard removed !! " + id;
    }

    public CreditCard updateCreditCard(CreditCard creditCard){
        CreditCard existingCreditCard = creditCardRepository.findById(creditCard.getId()).orElse(null);
        existingCreditCard.setCvv(creditCard.getCvv());
        existingCreditCard.setExpirationDate(creditCard.getExpirationDate());
        existingCreditCard.setIdentifiers(creditCard.getIdentifiers());
        existingCreditCard.setName(creditCard.getName());
        existingCreditCard.setNumber(creditCard.getNumber());
        existingCreditCard.setPais(creditCard.getPais());
        return creditCardRepository.save(existingCreditCard);

    }
}
