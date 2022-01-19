package com.FastTravel.FastTravelService.controller.client;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;


import org.springframework.beans.factory.ObjectFactory;
import javax.servlet.http.HttpSession;  
import org.springframework.beans.factory.annotation.Autowired;


@Controller
public class EditIdentifiersController {
  @Autowired
  ObjectFactory<HttpSession> httpSessionFactory;

    @GetMapping("client/editIdentifiers")
    public String getEditIdentifiers( Model model) {
      
      return "client/editidentifier";
    }    
}