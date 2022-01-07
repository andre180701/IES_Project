package com.FastTravel.FastTravelService.controller;

import com.FastTravel.FastTravelService.exception.*;
import com.FastTravel.FastTravelService.model.Client;
import com.FastTravel.FastTravelService.service.ClientService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class LoginCheckController {

    @Autowired
    private ClientService clientService;

    @CrossOrigin(origins ="http://127.0.0.1:6868/login")
    @GetMapping("/login/check")
    public String getLogin(String email, String password) throws ResourceNotFoundException {
        Client client = clientService.getClientByEmail(email);      

        if(client != null && client.getPassword().equals(password)) {
            System.out.println("{\"state\": true, \"firstName\": \"" + client.getFirst_name() +"\", \"lastName\": \"" + client.getLast_name() + "\" }");
            return "{\"state\": true, \"firstName\": \"" + client.getFirst_name() +"\", \"lastName\": \"" + client.getLast_name() + "\"}";
        }
        return "{\"state\": false, \"error\": \"Email and password incorrect!\"}";
    }
}