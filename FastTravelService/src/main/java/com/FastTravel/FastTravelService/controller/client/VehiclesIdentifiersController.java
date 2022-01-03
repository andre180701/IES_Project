package com.FastTravel.FastTravelService.controller.client;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;

@Controller
public class VehiclesIdentifiersController {

    @GetMapping("/vehiclesIdentifiers")
    public String getVehiclesIdentifiers( Model model) {
		return "client/vehiclesIdentifiers";
    }    
}