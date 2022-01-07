package com.FastTravel.FastTravelService.controller;

import com.FastTravel.FastTravelService.exception.*;
import com.FastTravel.FastTravelService.model.Client;
import com.FastTravel.FastTravelService.service.ClientService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.json.simple.JSONObject;  
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;  

@RestController
public class LoginCheckController {

    @Autowired
    private ClientService clientService;

    @PostMapping("/login/check")
    public JSONObject getLogin(String email, String password) throws ResourceNotFoundException {
        JSONParser parser = new JSONParser();  
        JSONObject json = null;
        Client client = clientService.getClientByEmail(email);      

        if(client != null && client.getPassword().equals(password)) {
            System.out.println("{\"state\": true, \"firstName\": \"" + client.getFirst_name() +"\", \"lastName\": \"" + client.getLast_name() + "\" }");
            try {
                json = (JSONObject) parser.parse("{\"state\": true, \"firstName\": \"" + client.getFirst_name() +"\", \"lastName\": \"" + client.getLast_name() + "\"}");
            } catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return json;
        }
        try {
            json = (JSONObject) parser.parse("{\"state\": false, \"error\": \"Email and password incorrect!\"}");
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return json;
    }
}