package com.FastTravel.FastTravelService.controller;

import java.util.List;

import com.FastTravel.FastTravelService.model.CreditCard;
import com.FastTravel.FastTravelService.service.CreditCardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class CreditCardController {
    @Autowired
    private CreditCardService creditCardService;

    @PostMapping("/addCreditCard")
    public CreditCard addCreditCard(@RequestBody CreditCard creditCard) {
        return creditCardService.saveCreditCard(creditCard);
    }

    @PostMapping("/addCreditCards")
    public List<CreditCard> addCreditCards(@RequestBody List<CreditCard> creditCards) {
        return creditCardService.saveCreditCards(creditCards);
    }

    @GetMapping("/creditCards")
    public List<CreditCard> findAllCreditCards() {
        return creditCardService.getCreditCards();
    }

    @GetMapping("/creditCardById/{id}")
    public CreditCard findCreditCardById(@PathVariable Long id) {
        return creditCardService.getCreditCardById(id);
    }

    /*
    @PutMapping("/update")
    public CreditCard updateCreditCard(@RequestBody CreditCard creditCard) {
        return creditCardService.updateCreditCard(creditCard);
    }*/

    @DeleteMapping("/deleteCreditCard/{id}")
    public String deleteCreditCard(@PathVariable Long id) {
        return creditCardService.deleteCreditCard(id);
    }
}