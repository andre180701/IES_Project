package com.FastTravel.FastTravelService.controller.client;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;

import org.springframework.beans.factory.ObjectFactory;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;  
import org.springframework.beans.factory.annotation.Autowired;
import com.FastTravel.FastTravelService.service.ClientService;
import com.FastTravel.FastTravelService.service.IdentifierService;
import com.FastTravel.FastTravelService.model.Client;
import com.FastTravel.FastTravelService.model.Identifier;

@Controller
public class VehiclesIdentifiersController {

  @Autowired
  private ClientService clientService;

  @Autowired
  private IdentifierService identifierService;

  @Autowired
  ObjectFactory<HttpSession> httpSessionFactory;


    @GetMapping("client/vehiclesIdentifiers")
    public String getVehiclesIdentifiers( Model model) {
      HttpSession session = httpSessionFactory.getObject();

      model.addAttribute("firstName", session.getAttribute("firstName"));
      model.addAttribute("lastName", session.getAttribute("lastName"));
      model.addAttribute("email", session.getAttribute("email"));

      String email = (String) session.getAttribute("email");

      Client client = clientService.getClientByEmail(email);

      List<Identifier> identifiersClient = new ArrayList<Identifier>();
      List<Identifier> identifiers = identifierService.getIdentifiers();

      for(Identifier val : identifiers){
        if(client.getId() == val.getClient().getId()){
          identifiersClient.add(val);
        }
      }
      
      model.addAttribute("identifiers", identifiersClient);
		  return "client/vehiclesIdentifiers";
    }    
}