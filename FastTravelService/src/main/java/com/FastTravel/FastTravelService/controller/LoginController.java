package com.FastTravel.FastTravelService.controller;

import com.FastTravel.FastTravelService.exception.*;
import com.FastTravel.FastTravelService.model.Client;
import com.FastTravel.FastTravelService.repository.*;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


@Controller
public class LoginController {

    @Autowired
    private ClientRepository  clientRepository;

    @GetMapping("/login")
    public String getAskIdentifier( Model model) {
		  return "login";
    } 

    public String getLogin(String email, String password) throws ResourceNotFoundException {
      //List<Client> clientExists= clientRepository.findAll();
      Client clientExists = ClientRepository.findByEmail(email);


      return "";
  }

    
    @PostMapping("/post")
    public void createClient(@PathVariable String confirm, @Valid @RequestBody Client client) throws ResourceNotFoundException {
        System.out.println(client.getEmail() + client.getPassword());
    }


}