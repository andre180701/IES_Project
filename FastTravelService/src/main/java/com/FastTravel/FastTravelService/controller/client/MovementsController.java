package com.FastTravel.FastTravelService.controller.client;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.FastTravel.FastTravelService.model.Client;
import com.FastTravel.FastTravelService.model.Movements;
import com.FastTravel.FastTravelService.model.Passage;
import com.FastTravel.FastTravelService.model.Identifier;
import com.FastTravel.FastTravelService.service.ClientService;
import com.FastTravel.FastTravelService.service.PassageService;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.ObjectFactory;
import javax.servlet.http.HttpSession;  
import org.springframework.beans.factory.annotation.Autowired;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
public class MovementsController {
  @Autowired
  private ClientService clientService;

  @Autowired
  private PassageService passageService;

  @Autowired
  ObjectFactory<HttpSession> httpSessionFactory;



    @GetMapping("client/movements")
    public String getMovements(Model model) {
      HttpSession session = httpSessionFactory.getObject();
      String email =(String) session.getAttribute("email");

      model.addAttribute("firstName", session.getAttribute("firstName"));
      model.addAttribute("lastName", session.getAttribute("lastName"));
      model.addAttribute("email", session.getAttribute("email"));

      Client client = clientService.getClientByEmail(email);
      List<Passage> passages = passageService.getPassages();
      List<Passage> passages_client = new ArrayList<Passage>();
      Set<Identifier> identifiers = client.getIdentifiers();
      for (int i = 0; i < passages.size(); i++){
        for (Identifier identifier: identifiers){
          if (passages.get(i).getIdentifier().getId() == (identifier.getId())){
            passages_client.add(passages.get(i));
          }
        }
      }

      model.addAttribute("passages", passages_client);
      return "client/movements";
      
    }    
}