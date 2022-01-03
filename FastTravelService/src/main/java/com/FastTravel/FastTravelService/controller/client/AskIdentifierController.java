package com.FastTravel.FastTravelService.controller.client;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;

@Controller
public class AskIdentifierController {

    @GetMapping("/askIdentifierController")
    public String getAskIdentifierController( Model model) {
		return "client/askIdentifier";
    }    
}