package com.FastTravel.FastTravelService.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Autowired;
import java.math.BigInteger; 
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest; 
import java.security.NoSuchAlgorithmException;

import com.FastTravel.FastTravelService.inputsForms.InputLogin;
import com.FastTravel.FastTravelService.model.Admin;
import com.FastTravel.FastTravelService.model.Client;
import com.FastTravel.FastTravelService.service.AdminService;
import com.FastTravel.FastTravelService.service.ClientService;

import org.springframework.beans.factory.ObjectFactory;
import javax.servlet.http.HttpSession;  

import org.springframework.stereotype.Controller;

@Controller
public class LoginController {

  @Autowired
  private ClientService clientService;

  @Autowired
  private AdminService adminService;

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

  public static byte[] getSHA(String input) throws NoSuchAlgorithmException
  { 
      MessageDigest md = MessageDigest.getInstance("SHA-256"); 
      return md.digest(input.getBytes(StandardCharsets.UTF_8)); 
  }
  
  public static String toHexString(byte[] hash)
  {
      BigInteger number = new BigInteger(1, hash); 
      StringBuilder hexString = new StringBuilder(number.toString(16)); 

      while (hexString.length() < 32) 
      { 
          hexString.insert(0, '0'); 
      } 

      return hexString.toString(); 
  }

  @PostMapping("/login/check")
  public String greetingSubmit(@ModelAttribute InputLogin inputLogin, Model model) throws NoSuchAlgorithmException {
    HttpSession session = httpSessionFactory.getObject();
    String email = inputLogin.getEmail().strip();
    String password = inputLogin.getPassword();
    password = toHexString(getSHA(password));
    if (email == "" || password == "") {
      model.addAttribute("error", "All fields must be filled!");
      return "login";
    }

    Client client = clientService.getClientByEmail(email);

    
    if(client != null && client.getPassword().equals(password)) {
      session.setAttribute("email", email);
      session.setAttribute("firstName", client.getFirst_name());
      session.setAttribute("lastName", client.getLast_name());
      model.addAttribute("firstName", client.getFirst_name());
      model.addAttribute("lastName", client.getLast_name());
      model.addAttribute("email", email);
      return "client/home";
    }

    Admin admin = adminService.getAdminByEmail(email);
    
    if(admin != null && admin.getPassword().equals(password)) {
      session.setAttribute("email", email);
      session.setAttribute("firstName", admin.getFirst_name());
      session.setAttribute("lastName", admin.getLast_name());
      model.addAttribute("firstName", admin.getFirst_name());
      model.addAttribute("lastName", admin.getLast_name());
      model.addAttribute("email", email);
      return "admin/dashboard";
    }


    model.addAttribute("error", "Email and/or password incorrect!");
    return "login";
  }
}