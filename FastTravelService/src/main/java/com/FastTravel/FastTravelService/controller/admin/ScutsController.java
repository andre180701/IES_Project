package com.FastTravel.FastTravelService.controller.admin;

import com.FastTravel.FastTravelService.model.*;
import com.FastTravel.FastTravelService.controller.*;
import java.sql.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.FastTravel.FastTravelService.inputsForms.FilterAdminScuts;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.ObjectFactory;
import javax.servlet.http.HttpSession;  


@Controller
public class ScutsController{
    @Autowired
    ObjectFactory<HttpSession> httpSessionFactory;

    @ModelAttribute("filterAdminScuts")
    public FilterAdminScuts getGreetingObject() {
        return new FilterAdminScuts();
    }


    @Autowired
    private ScutController  scutController;

    @GetMapping("admin/scuts")
    public String getAllScuts(Model model){
        HttpSession session = httpSessionFactory.getObject();

        model.addAttribute("firstName", session.getAttribute("firstName"));
        model.addAttribute("lastName", session.getAttribute("lastName"));
        model.addAttribute("email", session.getAttribute("email"));
        List<Scut> scuts = scutController.findAllScuts();
        model.addAttribute("scuts", scuts);
		return "admin/scuts";

    }

    @PostMapping("admin/scuts")
    public Scut createScut(@RequestBody Scut scut){
        return scutController.addScut(scut);
    }


    @PostMapping("/admin/filterscuts")
    public String filterMovements(@ModelAttribute FilterAdminScuts filterAdminScuts, Model model) {
        HttpSession session = httpSessionFactory.getObject();

        model.addAttribute("firstName", session.getAttribute("firstName"));
        model.addAttribute("lastName", session.getAttribute("lastName"));
        model.addAttribute("email", session.getAttribute("email"));

        List<Scut> scuts = scutController.findAllScuts();
        List<Scut> scuts2 = scutController.findAllScuts();

        if(filterAdminScuts.getId().strip() != ""){
            for(Scut sc : scuts){
              if(sc.getId() != Long.parseLong(filterAdminScuts.getId().strip())){
                scuts2.remove(sc); 
              }
            }
        }
  

        if(filterAdminScuts.getLongitude().strip() != ""){
          for(Scut sc : scuts){
            if(sc.getLongitude() != Double.parseDouble(filterAdminScuts.getLongitude().strip()) ){
              if(scuts2.contains(sc)){
                scuts2.remove(sc); 
              } 
            }
          }
        }

        if(filterAdminScuts.getLatitude().strip() != ""){
          for(Scut sc : scuts){
            if(sc.getLatitude() != Double.parseDouble(filterAdminScuts.getLatitude().strip()) ){
              if(scuts2.contains(sc)){
                scuts2.remove(sc); 
              } 
            }
          }
        }

        if(filterAdminScuts.getInstalationdate().strip() != ""){
          for(Scut sc : scuts){
            if(!sc.getInstalationDate().equals(Date.valueOf(filterAdminScuts.getInstalationdate().strip()))){
              if(scuts2.contains(sc)){
                scuts2.remove(sc); 
              } 
            }
          }
        }

        if(filterAdminScuts.getDescription().strip() != ""){
          for(Scut sc : scuts){
            if(!sc.getDescription().equals(filterAdminScuts.getDescription().strip()) ){
              if(scuts2.contains(sc)){
                scuts2.remove(sc);
              } 
            }
          }
        }

        if(filterAdminScuts.getPriceclass1().strip() != ""){
          for(Scut sc : scuts){
            if(sc.getPrice1() != Double.parseDouble(filterAdminScuts.getPriceclass1().strip()) ){
              if(scuts2.contains(sc)){
                scuts2.remove(sc);
              } 
            }
          }
        }
        if(filterAdminScuts.getPriceclass2().strip() != ""){
          for(Scut sc : scuts){
            if(sc.getPrice2() != Double.parseDouble(filterAdminScuts.getPriceclass2().strip()) ){
              if(scuts2.contains(sc)){
                scuts2.remove(sc);
              } 
            }
          }
        }
        if(filterAdminScuts.getPriceclass3().strip() != ""){
          for(Scut sc : scuts){
            if(sc.getPrice3() != Double.parseDouble(filterAdminScuts.getPriceclass3().strip()) ){
              if(scuts2.contains(sc)){
                scuts2.remove(sc);
              } 
            }
          }
        }
        if(filterAdminScuts.getPriceclass4().strip() != ""){
          for(Scut sc : scuts){
            if(sc.getPrice4() != Double.parseDouble(filterAdminScuts.getPriceclass4().strip()) ){
              if(scuts2.contains(sc)){
                scuts2.remove(sc);
              } 
            }
          }
        }
        if(filterAdminScuts.getPriceclass5().strip() != ""){
          for(Scut sc : scuts){
            if(sc.getPrice5() != Double.parseDouble(filterAdminScuts.getPriceclass5().strip()) ){
              if(scuts2.contains(sc)){
                scuts2.remove(sc);
              } 
            }
          }
        }
        


      model.addAttribute("scuts", scuts2);
		  return "admin/scuts";

    }
}