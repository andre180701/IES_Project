package com.FastTravel.FastTravelService.controller.admin;

import org.springframework.ui.Model;
import java.util.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.ObjectFactory;
import com.FastTravel.FastTravelService.model.Passage;
import com.FastTravel.FastTravelService.repository.PassageRepository;
import com.FastTravel.FastTravelService.controller.PassageController;
import javax.servlet.http.HttpSession;  
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
 


@Controller
public class DashboardController {
  @Autowired
  ObjectFactory<HttpSession> httpSessionFactory;

  @Autowired
  private PassageController passageController;


    @GetMapping("admin/dashboard")
    public String getDashboard( Model model) {
      HttpSession session = httpSessionFactory.getObject();

      model.addAttribute("firstName", session.getAttribute("firstName"));
      model.addAttribute("lastName", session.getAttribute("lastName"));
      model.addAttribute("email", session.getAttribute("email"));


      HashMap<String, Integer> hm = new HashMap<String, Integer>(); 
      List<Passage> passages = passageController.findAllPassages();
      for(Passage p : passages) {
        if(hm.containsKey(p.getScut().getDescription())){
          hm.put(p.getScut().getDescription(), hm.get(p.getScut().getDescription()) + 1);

        }
        else{
          hm.put(p.getScut().getDescription(), 1);
        }
      }


      Map<String, Integer> graphData = new TreeMap<>();
      for(String i : hm.keySet()) {
        graphData.put(i, hm.get(i));
      }
      
      model.addAttribute("chartData", graphData);

		return "admin/dashboard";
    }

   
}