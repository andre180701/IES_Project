package com.FastTravel.FastTravelService.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.FastTravel.FastTravelService.model.Client;
import com.FastTravel.FastTravelService.model.InputLogin;
import com.FastTravel.FastTravelService.service.ClientService;

import org.springframework.beans.factory.ObjectFactory;
import javax.servlet.http.HttpSession;  

import org.springframework.stereotype.Controller;

@Controller
public class LoginController {

  @Autowired
  private ClientService clientService;

  @Autowired
  ObjectFactory<HttpSession> httpSessionFactory;

  @ModelAttribute("inputLogin")
  public InputLogin getGreetingObject() {
    return new InputLogin();
  }

  @GetMapping("/login")
  public String getAskIdentifier(Model model) {
    return "login";
  }

  @PostMapping("/login/check")
  public String greetingSubmit(@ModelAttribute InputLogin inputLogin, Model model) {
    HttpSession session = httpSessionFactory.getObject();
    String email = inputLogin.getEmail();
    String password = inputLogin.getPassword();

    if (email == "" || password == "") {
      model.addAttribute("error", "All fields must be filled!");
      return "login";
    }

    Client client = clientService.getClientByEmail(email);

    
    if(client != null && client.getPassword().equals(password)) {
      System.out.println("{\"state\": true, \"firstName\": \"" + client.getFirst_name() +"\", \"lastName\": \"" + client.getLast_name() + "\" }");
      session.setAttribute("email", email);
      session.setAttribute("firstName", client.getFirst_name());
      session.setAttribute("lastName", client.getLast_name());
      model.addAttribute("firstName", client.getFirst_name());
      model.addAttribute("lastName", client.getLast_name());
      model.addAttribute("email", email);
      return "client/home";
    }

    model.addAttribute("error", "Email and/or password incorrect!");
    return "login";
  }
}