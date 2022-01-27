package com.FastTravel.FastTravelService.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import javax.validation.Valid;
import com.FastTravel.FastTravelService.model.Passage;
import com.FastTravel.FastTravelService.controller.PassageController;
import com.FastTravel.FastTravelService.inputsForms.FilterAdminPassages;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;
import java.sql.Time;
import java.util.Collections;
import java.util.List;
import javax.servlet.http.HttpSession;  

@Controller
public class PassagesController {
    @Autowired
    ObjectFactory<HttpSession> httpSessionFactory;

    @Autowired
    private PassageController passageController;

    @ModelAttribute("filterAdminPassages")
    public FilterAdminPassages getGreetingObject() {
      return new FilterAdminPassages();
    }

    @GetMapping("admin/passages")
    public String getAllPassages( Model model) {
        HttpSession session = httpSessionFactory.getObject();

        model.addAttribute("firstName", session.getAttribute("firstName"));
        model.addAttribute("lastName", session.getAttribute("lastName"));
        model.addAttribute("email", session.getAttribute("email"));
        List<Passage> passages = passageController.findAllPassages();
        Collections.sort(passages);
		model.addAttribute("passages", passages);
		return "admin/passages";
    }   
    @PostMapping("admin/passages")
    public  @Valid Passage createPassage(@Valid @RequestBody Passage passage){
        return passageController.addPassage(passage);
    }

    @PostMapping("/admin/filterpassages")
    public String filterMovements(@ModelAttribute FilterAdminPassages filterAdminPassages, Model model) {
        HttpSession session = httpSessionFactory.getObject();

        model.addAttribute("firstName", session.getAttribute("firstName"));
        model.addAttribute("lastName", session.getAttribute("lastName"));
        model.addAttribute("email", session.getAttribute("email"));

        List<Passage> passages_client = passageController.findAllPassages();
        List<Passage> passages_client2 = passageController.findAllPassages();

       
        if(filterAdminPassages.getRegistration().strip() != ""){
            for(Passage pc : passages_client){
              if(!pc.getIdentifier().getRegistration().equals(filterAdminPassages.getRegistration().strip())){
                passages_client2.remove(pc); 
              }
            }
          }
          

        if(filterAdminPassages.getCemail().strip() != ""){
          for(Passage pc : passages_client){
            if(!pc.getIdentifier().getClient().getEmail().equals(filterAdminPassages.getCemail().strip())){
              if(passages_client2.contains(pc)){
                passages_client2.remove(pc);
              }
            }
          }
        }
      
        if(filterAdminPassages.getIdentifier().strip() != ""){
          for(Passage pc : passages_client){
            if(pc.getIdentifier().getId() != (Long.parseLong(String.valueOf(filterAdminPassages.getIdentifier().strip())))){
              if(passages_client2.contains(pc)){
                passages_client2.remove(pc);
              }
            }
          }
        }
        if(filterAdminPassages.getDate().strip() != ""){
          for(Passage pc : passages_client){
            if(!pc.getDate().equals(Date.valueOf(filterAdminPassages.getDate().strip())) ){
              if(passages_client2.contains(pc)){
                
                passages_client2.remove(pc); 
    
              }
              
            }
          }
          
        }
        if(filterAdminPassages.getHour().strip() != ""){
          for(Passage pc : passages_client){
            if(!pc.getTime().equals(Time.valueOf(filterAdminPassages.getHour().strip()))){
             
              if(passages_client2.contains(pc)){
                passages_client2.remove(pc);
                
    
    
              }
            }
          }
        }
        if(filterAdminPassages.getScutslatitude().strip() != ""){
          for(Passage pc : passages_client){
            if(pc.getScut().getLatitude() != Double.parseDouble(filterAdminPassages.getScutslatitude().strip()) ){
              
              
              if(passages_client2.contains(pc)){
                passages_client2.remove(pc); 
    
              }
              
            }
          }
          
        }
        if(filterAdminPassages.getScutslongitude().strip() != ""){
          for(Passage pc : passages_client){
            if(pc.getScut().getLongitude() != Double.parseDouble(filterAdminPassages.getScutslongitude().strip()) ){
              
              if(passages_client2.contains(pc)){
                passages_client2.remove(pc); 
    
              }
              
            }
          }
          
        }
        if(filterAdminPassages.getScutsdescription().strip() != ""){
          for(Passage pc : passages_client){
            if(!pc.getScut().getDescription().equals(filterAdminPassages.getScutsdescription().strip()) ){
              if(passages_client2.contains(pc)){
                passages_client2.remove(pc); 
              }
            }
          } 
        }
        if(filterAdminPassages.getPaymentstate().strip() != ""){
          for(Passage pc : passages_client){
            if(!pc.getPaymentState().toString().equals(filterAdminPassages.getPaymentstate().strip())){
              if(passages_client2.contains(pc)){
                passages_client2.remove(pc); 
              }
            }
          } 
        }
    
    
        if(filterAdminPassages.getPrice().strip() != ""){
    
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
           
            if(priceClasse != Double.parseDouble(filterAdminPassages.getPrice().strip())){
              if(passages_client2.contains(pc)){
                passages_client2.remove(pc); 
              }
            }
          } 
        }

        Collections.sort(passages_client2);
        model.addAttribute("passages", passages_client2);
		  return "admin/passages";
    }
}