package com.FastTravel.FastTravelService.controller.admin;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ModelAttribute;
import com.FastTravel.FastTravelService.inputsForms.FilterPassagesAdmin;
import javax.validation.Valid;


import com.FastTravel.FastTravelService.model.Passage;
import com.FastTravel.FastTravelService.controller.PassageController;

import java.util.*;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpSession;  
import java.util.List;


@Controller
public class PassagesController {
    @Autowired
    ObjectFactory<HttpSession> httpSessionFactory;

    @Autowired
    private PassageController passageController;

    @ModelAttribute("filterPassagesAdmin")
    public FilterPassagesAdmin getGreetingObject() {
        return new FilterPassagesAdmin();
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
    public String filterMovements(@ModelAttribute FilterPassagesAdmin filterPassagesAdmin, Model model) {
        HttpSession session = httpSessionFactory.getObject();

        model.addAttribute("firstName", session.getAttribute("firstName"));
        model.addAttribute("lastName", session.getAttribute("lastName"));
        model.addAttribute("email", session.getAttribute("email"));

        List<Passage> passages_client = passageController.findAllPassages();
        List<Passage> passages_client2 = passageController.findAllPassages();

       
        if(filterPassagesAdmin.getRegistration().strip() != ""){
            for(Passage pc : passages_client){
              if(!pc.getIdentifier().getRegistration().equals(filterPassagesAdmin.getRegistration().strip())){
                passages_client2.remove(pc); 
              }
            }
          }
          

        // if(filterFormsadminp.getClientemail().strip() != ""){
        //   for(Passage pc : passages_client){
        //     if(!pc.getIdentifier().getClient().getEmail().equals(filterFormsadminp.getClientemail().strip())){
        //       if(passages_client2.contains(pc)){
        //         passages_client2.remove(pc);
        //       }
        //     }
        //   }
        // }
      
        // if(filterFormsadminp.getIdentifier().strip() != ""){
        //   for(Passage pc : passages_client){
        //     if(pc.getIdentifier().getId() != (Long.parseLong(String.valueOf(filterFormsadminp.getIdentifier().strip())))){
        //       if(passages_client2.contains(pc)){
        //         passages_client2.remove(pc);
        //       }
        //     }
        //   }
        // }
        // if(filterFormsadminp.getDate().strip() != ""){
        //   for(Passage pc : passages_client){
        //     if(!pc.getDate().equals(Date.valueOf(filterFormsadminp.getDate().strip())) ){
        //       if(passages_client2.contains(pc)){
                
        //         passages_client2.remove(pc); 
    
        //       }
              
        //     }
        //   }
          
        // }
        // if(filterFormsadminp.getHour().strip() != ""){
        //   for(Passage pc : passages_client){
        //     if(!pc.getTime().equals(Time.valueOf(filterFormsadminp.getHour().strip()))){
             
        //       if(passages_client2.contains(pc)){
        //         passages_client2.remove(pc);
                
    
    
        //       }
        //     }
        //   }
        // }
        // if(filterFormsadminp.getScutslatitude().strip() != ""){
        //   for(Passage pc : passages_client){
        //     if(pc.getScut().getLatitude() != Double.parseDouble(filterFormsadminp.getScutslatitude().strip()) ){
              
              
        //       if(passages_client2.contains(pc)){
        //         passages_client2.remove(pc); 
    
        //       }
              
        //     }
        //   }
          
        // }
        // if(filterFormsadminp.getScutslongitude().strip() != ""){
        //   for(Passage pc : passages_client){
        //     if(pc.getScut().getLongitude() != Double.parseDouble(filterFormsadminp.getScutslongitude().strip()) ){
              
        //       if(passages_client2.contains(pc)){
        //         passages_client2.remove(pc); 
    
        //       }
              
        //     }
        //   }
          
        // }
        // if(filterFormsadminp.getScutsdescription().strip() != ""){
        //   for(Passage pc : passages_client){
        //     if(!pc.getScut().getDescription().equals(filterFormsadminp.getScutsdescription().strip()) ){
        //       if(passages_client2.contains(pc)){
        //         passages_client2.remove(pc); 
        //       }
        //     }
        //   } 
        // }
        // if(filterFormsadminp.getPaymentstate().strip() != ""){
        //   for(Passage pc : passages_client){
        //     if(!pc.getPaymentState().toString().equals(filterFormsadminp.getPaymentstate().strip())){
        //       if(passages_client2.contains(pc)){
        //         passages_client2.remove(pc); 
        //       }
        //     }
        //   } 
        // }
    
    
        // if(filterFormsadminp.getPrice().strip() != ""){
    
        //   for(Passage pc : passages_client){
    
        //     int classe = pc.getIdentifier().getClasse();
        //     double priceClasse = pc.getScut().getPrice5();
        //     switch(classe) {
        //       case 1:
        //         priceClasse = pc.getScut().getPrice1();
        //         break;
        //       case 2:
        //         priceClasse = pc.getScut().getPrice2();
        //         break;
        //       case 3:
        //         priceClasse = pc.getScut().getPrice3();
        //         break;
        //       case 4:
        //         priceClasse = pc.getScut().getPrice4();
        //         break;
        //       case 5:
        //         priceClasse = pc.getScut().getPrice5();
        //         break;
        //     }
           
        //     if(priceClasse != Double.parseDouble(filterFormsadminp.getPrice().strip())){
        //       if(passages_client2.contains(pc)){
        //         passages_client2.remove(pc); 
        //       }
        //     }
        //   } 
        // }
    
        model.addAttribute("passages", passages_client2);
		return "admin/passages";

    }
}