package com.FastTravel.FastTravelService.controller.admin;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.ObjectFactory;
import com.FastTravel.FastTravelService.model.Passage;
import com.FastTravel.FastTravelService.controller.PassageController;

import java.sql.Date;
import java.sql.Time;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpSession;  
import org.springframework.beans.factory.annotation.Autowired;

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


      System.out.println("ANTES DE IR VUSCAR COISAS");
      HashMap<String, Integer> hm = new HashMap<String, Integer>(); 
      HashMap<Time, Double> hmProfit  = new HashMap<Time, Double>(); 
      List<Passage> passages = passageController.findAllPassages();
      for(Passage p : passages) {
        System.out.println("Passagem: " + p.getScut().getDescription());
        if(hm.containsKey(p.getScut().getDescription())){
          hm.put(p.getScut().getDescription(), hm.get(p.getScut().getDescription()) + 1);

        }
        else{
          hm.put(p.getScut().getDescription(), 1);
        }

        if(!hmProfit.containsKey(p.getTime())){
          hmProfit.put(p.getTime(), 0.0);
        }

        switch (p.getIdentifier().getClasse()) {
          case 1:
            hmProfit.put(p.getTime(), hmProfit.get(p.getTime()) + p.getScut().getPrice1());
            break;
          case 2:
            hmProfit.put(p.getTime(), hmProfit.get(p.getTime()) + p.getScut().getPrice2());
            break;
          case 3:
            hmProfit.put(p.getTime(), hmProfit.get(p.getTime()) + p.getScut().getPrice3());
            break;
          case 4:
            hmProfit.put(p.getTime(), hmProfit.get(p.getTime()) + p.getScut().getPrice4());
            break;
          default:
            hmProfit.put(p.getTime(), hmProfit.get(p.getTime()) + p.getScut().getPrice5());
            break;
        }
        
        System.out.println("CHave: " + String.valueOf(p.getTime()) + ", Tipo:" + String.valueOf(p.getTime()).getClass().getName());
        System.out.println("Value: " + String.valueOf(hmProfit.get(p.getTime())) + ", Tipo:" + String.valueOf(hmProfit.get(p.getTime())).getClass().getName());
      }


      Map<String, Integer> graphData = new TreeMap<>();
      Map<String, Double> graphDataProfit = new TreeMap<>();
      for(String i : hm.keySet()) {
        graphData.put(i, hm.get(i));
      }
      System.out.println("New grah");
      for(Time i : hmProfit.keySet()) {
        graphDataProfit.put(String.valueOf(i), hmProfit.get(i));
        System.out.println("CHave: " + String.valueOf(i) + ", Tipo:" + String.valueOf(i).getClass().getName());
        System.out.println("Value: " + String.valueOf(hmProfit.get(i)) + ", Tipo:" + String.valueOf(hmProfit.get(i)).getClass().getName());
      }
      
      model.addAttribute("chartData", graphData);
      model.addAttribute("chartDataProfit", graphDataProfit);
      
      return "admin/dashboard";
    }

   
}