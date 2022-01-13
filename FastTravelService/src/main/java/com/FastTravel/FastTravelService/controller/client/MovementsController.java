package com.FastTravel.FastTravelService.controller.client;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import java.sql.Date;
import java.sql.Time;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.FastTravel.FastTravelService.controller.PassageController;
import com.FastTravel.FastTravelService.inputsForms.FilterForms;
import com.FastTravel.FastTravelService.model.Client;
import com.FastTravel.FastTravelService.model.Passage;
import com.FastTravel.FastTravelService.service.ClientService;
import org.springframework.beans.factory.ObjectFactory;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
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

    model.addAttribute("passages", passages_client);
    return "client/movements";

  }

  @PostMapping("/client/filter")
  public String filterMovements(@ModelAttribute FilterForms filterForms, Model model) {
    System.out.println("INICIO");
    HttpSession session = httpSessionFactory.getObject();
    String email = (String) session.getAttribute("email");

    model.addAttribute("firstName", session.getAttribute("firstName"));
    model.addAttribute("lastName", session.getAttribute("lastName"));
    model.addAttribute("email", session.getAttribute("email"));

    Client client = clientService.getClientByEmail(email);

    List<Passage> passages = passageController.findAllPassages();
    List<Passage> passages_client = new ArrayList<Passage>();
    List<Passage> passages_client2 = new ArrayList<Passage>();
    List<Passage> filter_passages = new ArrayList<Passage>();

    for (Passage passage : passages) {
      if ( passage.getIdentifier().getClient().getId() == client.getId() ) {
        passages_client.add(passage);
        passages_client2.add(passage);
       
      }
    }
    
    System.out.println(passages_client2.size());
    if(filterForms.getRegistration() != ""){
      for(Passage pc : passages_client){
        if(!pc.getIdentifier().getRegistration().equals(filterForms.getRegistration())){
          passages_client2.remove(pc); 
        }
      }
    }

    if(filterForms.getIdentifier() != ""){
      for(Passage pc : passages_client){
        System.out.println(filterForms.getIdentifier());
        System.out.println(pc.getIdentifier().getId());
        if(pc.getIdentifier().getId() != (Long.parseLong(String.valueOf(filterForms.getIdentifier())))){
          if(passages_client2.contains(pc)){
            passages_client2.remove(pc);
          }
        }
      }
    }
    if(filterForms.getDate() != ""){
      for(Passage pc : passages_client){
        if(!pc.getDate().equals(Date.valueOf(filterForms.getDate())) ){
          if(passages_client2.contains(pc)){
            
            passages_client2.remove(pc); 

          }
          
        }
      }
      
    }
    if(filterForms.getHour() != ""){
      for(Passage pc : passages_client){
        if(!pc.getTime().equals(Time.valueOf(filterForms.getHour()))){
          System.out.println(pc.getTime());
          if(passages_client2.contains(pc)){
            passages_client2.remove(pc);
            


          }
        }
      }
    }
    if(filterForms.getScutslatitude() != ""){
      for(Passage pc : passages_client){
        System.out.println(filterForms.getScutslatitude());
        System.out.println(pc.getScut().getLatitude());
        if(pc.getScut().getLatitude() != Double.parseDouble(filterForms.getScutslatitude()) ){
          
          
          if(passages_client2.contains(pc)){
            passages_client2.remove(pc); 

          }
          
        }
      }
      
    }
    if(filterForms.getScutslongitude() != ""){
      for(Passage pc : passages_client){
        System.out.println(filterForms.getScutslongitude());
        System.out.println(pc.getScut().getLongitude());
        if(pc.getScut().getLongitude() != Double.parseDouble(filterForms.getScutslongitude()) ){
          
          
          if(passages_client2.contains(pc)){
            passages_client2.remove(pc); 

          }
          
        }
      }
      
    }
    if(filterForms.getScutsdescription() != ""){
      for(Passage pc : passages_client){
        System.out.println(filterForms.getScutsdescription());
        System.out.println(pc.getScut().getDescription());
        if(!pc.getScut().getDescription().equals(filterForms.getScutsdescription()) ){
          if(passages_client2.contains(pc)){
            passages_client2.remove(pc); 
          }
        }
      } 
    }
    if(filterForms.getPaymentstate() != ""){
      for(Passage pc : passages_client){
        System.out.println(filterForms.getPaymentstate());
        System.out.println(pc.getScut().getDescription());
        if(!pc.getPaymentState().toString().equals(filterForms.getPaymentstate())){
          if(passages_client2.contains(pc)){
            passages_client2.remove(pc); 
          }
        }
      } 
    }
    
    

 
    



    // for(Passage pc : passages_client){
    //   // int classe = pc.getIdentifier().getClasse();
    //   //  double priceClasse;
    //   //  switch(classe) {
    //   //    case 1:
    //   //      priceClasse = pc.getScut().getPrice1();
    //   //      break;
    //   //    case 2:
    //   //      priceClasse = pc.getScut().getPrice2();
    //   //      break;
    //   //    case 3:
    //   //      priceClasse = pc.getScut().getPrice2();
    //   //      break;
    //   //    case 4:
    //   //      priceClasse = pc.getScut().getPrice2();
    //   //      break;
    //   //    case 5:
    //   //      priceClasse = pc.getScut().getPrice2();
    //   //      break;
    //   //    default:
    //   //      // code block
    //   //  }
    //   System.out.println("matricula inserida");
    //   System.out.println(filterForms.getRegistration());
    //   System.out.println("matriculas da geraçao de dados");
    //   System.out.println(pc.getIdentifier().getRegistration());

                                                                               
    //   if(pc.getIdentifier().getRegistration().equals(filterForms.getRegistration()) && //FILTER REGISTRATION  
    //   //pc.getIdentifier().getId().equals(Long.parseLong(filterForms.getIdentifier())) && 
    //   pc.getDate().equals(Date.valueOf(filterForms.getDate())) && 
    //   pc.getTime().equals(Time.valueOf(filterForms.getHour())) &&
    //   //pc.getScut().getLatitude().equals(Double.parseDouble(filterForms.getScutslatitude())) &&
    //   //pc.getScut().getLongitude() == Double.parseDouble(filterForms.getScutslongitude()) &&
    //   pc.getScut().getDescription().equals(filterForms.getScutsdescription()) 
    //   //priceClasse.equals(Double.parseDouble(filterForms.getPrice()))
    //   //pc.getPaymentState().equals(filterForms.getPaymentstate())
    //   ){
    //     filter_passages.add(pc);  
    //   }


    // }
    System.out.println("Tamanho lista final");
    System.out.println(passages_client2.size());

    model.addAttribute("passages", passages_client2);
    return "client/movements";
    



    

  }
}