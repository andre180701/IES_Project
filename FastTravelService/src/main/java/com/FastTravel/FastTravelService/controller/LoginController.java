package com.FastTravel.FastTravelService.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String getAskIdentifier( Model model) {
		return "login";
    }    
}