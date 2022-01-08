package com.FastTravel.FastTravelService.controller.client;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.ObjectFactory;
import javax.servlet.http.HttpSession;  
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.FastTravel.FastTravelService.service.ClientService;
import com.FastTravel.FastTravelService.service.IdentifierService;
import com.FastTravel.FastTravelService.model.Client;
import com.FastTravel.FastTravelService.model.Identifier;
import com.FastTravel.FastTravelService.model.IdentifierByUser;
import com.FastTravel.FastTravelService.repository.IdentifierRepository;

@Controller
public class VehiclesIdentifiersController {

  @Autowired
  private ClientService clientService;

  @Autowired
  ObjectFactory<HttpSession> httpSessionFactory;


    @GetMapping("client/vehiclesIdentifiers")
    public String getVehiclesIdentifiers( Model model) {
      HttpSession session = httpSessionFactory.getObject();

      /*model.addAttribute("firstName", session.getAttribute("firstName"));
      model.addAttribute("lastName", session.getAttribute("lastName"));
      model.addAttribute("email", session.getAttribute("email"));
      */
      String email = (String) session.getAttribute("email");
      Client client = clientService.getClientByEmail(email);

      IdentifierService id = new IdentifierService();
      //List<IdentifierByUser> idByUser = new ArrayList<IdentifierByUser>();
      List<Identifier> list = new ArrayList<Identifier>();

      list = id.getIdentifiers();
      for(int i=0; i<list.size(); i++){
        Identifier var = list.get(i);
        if(client.getId() != var.getClient().getId()){
          list.remove(i);
          
        }

      }
      model.addAttribute("identifiers", list);
		  return "client/vehiclesIdentifiers";
    }    
}