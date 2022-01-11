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
  private IdentifierService id;

  @Autowired
  ObjectFactory<HttpSession> httpSessionFactory;


    @GetMapping("client/vehiclesIdentifiers")
    public String getVehiclesIdentifiers( Model model) {
      System.out.println("Entrei no get da pagina veiculos e identificadores");
      HttpSession session = httpSessionFactory.getObject();

      model.addAttribute("firstName", session.getAttribute("firstName"));
      model.addAttribute("lastName", session.getAttribute("lastName"));
      model.addAttribute("email", session.getAttribute("email"));
      System.out.println("INICIAL");

      String email = (String) session.getAttribute("email");
      System.out.println("Email teste");
      System.out.println(email);

      Client client = clientService.getClientByEmail(email);
      System.out.println("Cliente autenticado teste");
      System.out.println(client);

      //ArrayList<IdentifierByUser> idByUser = new ArrayList<IdentifierByUser>();
      List<Identifier> list2 = new ArrayList<Identifier>();
      List<Identifier> list3 = id.getIdentifiers();

      
      for(Identifier val : list3){
        System.out.println("Lista de identificadores ");
        
        System.out.println(val);
        System.out.println("Id do cliente autenticado " + client.getId());
        System.out.println("Id do cliente da lista " + val.getClient().getId());
        if(client.getId() == val.getClient().getId()){
          list2.add(val);
          System.out.println("Identificador do cliente teste");
          System.out.println(val);
          
        }
       
      }
      model.addAttribute("identifiers", list2);
		  return "client/vehiclesIdentifiers";
    }    
}