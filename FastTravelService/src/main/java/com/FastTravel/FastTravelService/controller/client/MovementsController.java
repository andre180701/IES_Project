package com.FastTravel.FastTravelService.controller.client;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.FastTravel.FastTravelService.controller.PassageController;
import com.FastTravel.FastTravelService.model.Client;
import com.FastTravel.FastTravelService.model.Passage;
import com.FastTravel.FastTravelService.service.ClientService;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.ObjectFactory;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MovementsController {

  @Autowired
  private ClientService clientService;

  @Autowired
  private PassageController passageController;

  @Autowired
  ObjectFactory<HttpSession> httpSessionFactory;

  @GetMapping("client/movements")
  public String getMovements(Model model) {
    HttpSession session = httpSessionFactory.getObject();
    String email = (String) session.getAttribute("email");

    model.addAttribute("firstName", session.getAttribute("firstName"));
    model.addAttribute("lastName", session.getAttribute("lastName"));
    model.addAttribute("email", session.getAttribute("email"));

    Client client = clientService.getClientByEmail(email);

    List<Passage> passages = passageController.findAllPassages();
    List<Passage> passages_client = new ArrayList<Passage>();

    for (Passage passage : passages) {
      if ( passage.getIdentifier().getClient().getId() == client.getId() ) {
        passages_client.add(passage);
      }
    }

    model.addAttribute("passages", passages_client);
    return "client/movements";

  }
}