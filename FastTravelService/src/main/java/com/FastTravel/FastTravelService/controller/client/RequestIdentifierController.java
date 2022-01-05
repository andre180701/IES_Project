package com.FastTravel.FastTravelService.controller.client;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;

@Controller
public class RequestIdentifierController {

    @GetMapping("client/requestIdentifier")
    public String getRequestIdentifier( Model model) {
		return "client/requestIdentifier";
    }    
}