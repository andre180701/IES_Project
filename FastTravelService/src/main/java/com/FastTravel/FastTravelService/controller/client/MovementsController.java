package com.FastTravel.FastTravelService.controller.client;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import java.sql.Date;
import java.sql.Time;
import org.springframework.stereotype.Controller;
import com.FastTravel.FastTravelService.controller.PassageController;
import com.FastTravel.FastTravelService.inputsForms.FilterForms;
import com.FastTravel.FastTravelService.model.Client;
import com.FastTravel.FastTravelService.model.Passage;
import com.FastTravel.FastTravelService.service.ClientService;
import org.springframework.beans.factory.ObjectFactory;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
public class MovementsController {

  @Autowired
  private ClientService clientService;

  @ModelAttribute("filterForms")
  public FilterForms getGreetingObject() {
    return new FilterForms();
  }

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
    Collections.sort(passages_client);
    model.addAttribute("passages", passages_client);
    return "client/movements";

  }

  @PostMapping("/client/filter")
  public String filterMovements(@ModelAttribute FilterForms filterForms, Model model) {
  
    HttpSession session = httpSessionFactory.getObject();
    String email = (String) session.getAttribute("email");

    model.addAttribute("firstName", session.getAttribute("firstName"));
    model.addAttribute("lastName", session.getAttribute("lastName"));
    model.addAttribute("email", session.getAttribute("email"));

    Client client = clientService.getClientByEmail(email);

    List<Passage> passages = passageController.findAllPassages();
    List<Passage> passages_client = new ArrayList<Passage>();
    List<Passage> passages_client2 = new ArrayList<Passage>();

    for (Passage passage : passages) {
      if ( passage.getIdentifier().getClient().getId() == client.getId() ) {
        passages_client.add(passage);
        passages_client2.add(passage);
       
      }
    }
    
    if(filterForms.getRegistration().strip() != ""){
      for(Passage pc : passages_client){
        if(!pc.getIdentifier().getRegistration().equals(filterForms.getRegistration().strip())){
          passages_client2.remove(pc); 
        }
      }
    }

    if(filterForms.getIdentifier().strip() != ""){
      for(Passage pc : passages_client){
        if(pc.getIdentifier().getId() != (Long.parseLong(String.valueOf(filterForms.getIdentifier().strip())))){
          if(passages_client2.contains(pc)){
            passages_client2.remove(pc);
          }
        }
      }
    }
    if(filterForms.getDate().strip() != ""){
      for(Passage pc : passages_client){
        if(!pc.getDate().equals(Date.valueOf(filterForms.getDate().strip())) ){
          if(passages_client2.contains(pc)){
            
            passages_client2.remove(pc); 

          }
          
        }
      }
      
    }
    if(filterForms.getHour().strip() != ""){
      for(Passage pc : passages_client){
        if(!pc.getTime().equals(Time.valueOf(filterForms.getHour().strip()))){
         
          if(passages_client2.contains(pc)){
            passages_client2.remove(pc);
          }
        }
      }
    }
    if(filterForms.getScutslatitude().strip() != ""){
      for(Passage pc : passages_client){
        if(pc.getScut().getLatitude() != Double.parseDouble(filterForms.getScutslatitude().strip()) ){
          
          
          if(passages_client2.contains(pc)){
            passages_client2.remove(pc); 

          }
          
        }
      }
      
    }
    if(filterForms.getScutslongitude().strip() != ""){
      for(Passage pc : passages_client){
        if(pc.getScut().getLongitude() != Double.parseDouble(filterForms.getScutslongitude().strip()) ){
          if(passages_client2.contains(pc)){
            passages_client2.remove(pc); 
          } 
        }
      }
    }
    if(filterForms.getScutsdescription().strip() != ""){
      for(Passage pc : passages_client){
        if(!pc.getScut().getDescription().equals(filterForms.getScutsdescription().strip()) ){
          if(passages_client2.contains(pc)){
            passages_client2.remove(pc); 
          }
        }
      } 
    }
    if(filterForms.getPaymentstate().strip() != ""){
      for(Passage pc : passages_client){
        if(!pc.getPaymentState().toString().equals(filterForms.getPaymentstate().strip())){
          if(passages_client2.contains(pc)){
            passages_client2.remove(pc); 
          }
        }
      } 
    }


    if(filterForms.getPrice().strip() != ""){

      for(Passage pc : passages_client){

        int classe = pc.getIdentifier().getClasse();
        double priceClasse = pc.getScut().getPrice5();
        switch(classe) {
          case 1:
            priceClasse = pc.getScut().getPrice1();
            break;
          case 2:
            priceClasse = pc.getScut().getPrice2();
            break;
          case 3:
            priceClasse = pc.getScut().getPrice3();
            break;
          case 4:
            priceClasse = pc.getScut().getPrice4();
            break;
          case 5:
            priceClasse = pc.getScut().getPrice5();
            break;
        }
       
        if(priceClasse != Double.parseDouble(filterForms.getPrice().strip())){
          if(passages_client2.contains(pc)){
            passages_client2.remove(pc); 
          }
        }
      } 
    }

    model.addAttribute("passages", passages_client2);
    return "client/movements";
  }
}