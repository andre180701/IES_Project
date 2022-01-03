package com.FastTravel.FastTravelService.controller.client;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;

@Controller
public class Vehicles_identifiersController {

    @GetMapping("/vehicles_identifiers")
    public String getAllVehicles_identifiers( Model model) {
		return "client/vehicles_identifiers.html";
    }  
    
}