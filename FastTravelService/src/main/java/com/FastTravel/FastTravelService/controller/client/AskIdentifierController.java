package com.FastTravel.FastTravelService.controller.client;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;

@Controller
public class AskIdentifierController {

    @GetMapping("/askIdentifier")
    public String getAskIdentifier( Model model) {
		return "client/askIdentifier";
    }    
}