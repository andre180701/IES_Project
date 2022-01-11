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
