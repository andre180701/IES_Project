package com.FastTravel.FastTravelService.controller.client;

import com.FastTravel.FastTravelService.inputsForms.FilterIdentifiers;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.beans.factory.ObjectFactory;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;  
import org.springframework.beans.factory.annotation.Autowired;
import com.FastTravel.FastTravelService.model.Client;
import com.FastTravel.FastTravelService.model.StateIdentifier;
import com.FastTravel.FastTravelService.model.Identifier;
import com.FastTravel.FastTravelService.controller.ClientController;
import com.FastTravel.FastTravelService.controller.IdentifierController;


@Controller
public class VehiclesIdentifiersController {

  @ModelAttribute("filterForm")
  public FilterIdentifiers getGreetingObject() {
    return new FilterIdentifiers();
  }

  @Autowired
  private ClientController clientController;

  @Autowired
  ObjectFactory<HttpSession> httpSessionFactory;

  @Autowired
  private IdentifierController identifierController;


    @GetMapping("client/vehiclesIdentifiers")
    public String getVehiclesIdentifiers( Model model) {
      HttpSession session = httpSessionFactory.getObject();

      model.addAttribute("firstName", session.getAttribute("firstName"));
      model.addAttribute("lastName", session.getAttribute("lastName"));
      model.addAttribute("email", session.getAttribute("email"));

      String email = (String) session.getAttribute("email");

      Client client = clientController.findClientByEmail(email);

      List<Identifier> identifiersClient = new ArrayList<Identifier>();
      List<Identifier> identifiers = identifierController.findAllIdentifiers();

      for(Identifier val : identifiers){
        if(client.getId() == val.getClient().getId()){
          identifiersClient.add(val);
        }
      }
      
      model.addAttribute("identifiers", identifiersClient);
		  return "client/vehiclesIdentifiers";
    }    

  @PostMapping("/client/filteridentifier")
  public String filterMovements(@ModelAttribute FilterIdentifiers filterIdentifiers, Model model) {
    HttpSession session = httpSessionFactory.getObject();

    model.addAttribute("firstName", session.getAttribute("firstName"));
    model.addAttribute("lastName", session.getAttribute("lastName"));
    model.addAttribute("email", session.getAttribute("email"));

    String email = (String) session.getAttribute("email");
    Client client = clientController.findClientByEmail(email);

    List<Identifier> identifiersClient = new ArrayList<Identifier>();
    List<Identifier> identifiersClient2 = new ArrayList<Identifier>();
    List<Identifier> identifiers = identifierController.findAllIdentifiers();

    for(Identifier val : identifiers){
      if(client.getId() == val.getClient().getId()){
        identifiersClient.add(val);
        identifiersClient2.add(val);
      }
    }

    if(filterIdentifiers.getRegistration().strip() != ""){
      for(Identifier pc : identifiersClient){
        if(!pc.getRegistration().equals(filterIdentifiers.getRegistration().strip())){
          identifiersClient2.remove(pc); 
        }
      }
    }

    if(filterIdentifiers.getIdentifier().strip() != ""){
      for(Identifier pc : identifiersClient){
        if(pc.getId() != (Integer.parseInt(String.valueOf(filterIdentifiers.getIdentifier().strip()))) && identifiersClient2.contains(pc)){
            identifiersClient2.remove(pc);
        }
      }
    }

    if(filterIdentifiers.getClasse().strip() != ""){
      for(Identifier pc : identifiersClient){
        if(pc.getClasse() != (Integer.parseInt(String.valueOf(filterIdentifiers.getClasse().strip()))) && identifiersClient2.contains(pc)){
            identifiersClient2.remove(pc);
        }
      }
    }
    if(filterIdentifiers.getMeansPayment().strip() != ""){
      for(Identifier pc : identifiersClient){
        if(pc.getCreditCard().getNumber() != (Long.parseLong(String.valueOf(filterIdentifiers.getMeansPayment().strip()))) && identifiersClient2.contains(pc)){
            identifiersClient2.remove(pc);
        }
      }
    }

    if(filterIdentifiers.getState().strip() != ""){
      for(Identifier pc : identifiersClient){
        if(pc.getState() != StateIdentifier.valueOf(String.valueOf(filterIdentifiers.getState().strip())) && identifiersClient2.contains(pc)){
            identifiersClient2.remove(pc);
        }
      }
    }

    model.addAttribute("identifiers", identifiersClient2);
    return "client/vehiclesIdentifiers";
  }
}