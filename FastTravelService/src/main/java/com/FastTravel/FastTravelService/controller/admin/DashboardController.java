package com.FastTravel.FastTravelService.controller.admin;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.ObjectFactory;
import com.FastTravel.FastTravelService.model.Passage;
import com.FastTravel.FastTravelService.controller.PassageController;
import javax.servlet.http.HttpSession;  
import org.springframework.beans.factory.annotation.Autowired;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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
      HashMap<Date, Double> hmProfit  = new HashMap<Date, Double>(); 
      List<Passage> passages = passageController.findAllPassages();
      for(Passage p : passages) {
        if(hm.containsKey(p.getScut().getDescription())){
          hm.put(p.getScut().getDescription(), hm.get(p.getScut().getDescription()) + 1);

        }
        else{
          hm.put(p.getScut().getDescription(), 1);
        }

        if(hmProfit.containsKey(p.getDate())){
          hmProfit.put(p.getDate(), 0.0);
        }

        switch (p.getIdentifier().getClasse()) {
          case 1:
            hmProfit.put(p.getDate(), hmProfit.get(p.getDate()) + p.getScut().getPrice1());
            break;
          case 2:
            hmProfit.put(p.getDate(), hmProfit.get(p.getDate()) + p.getScut().getPrice2());
            break;
          case 3:
            hmProfit.put(p.getDate(), hmProfit.get(p.getDate()) + p.getScut().getPrice3());
            break;
          case 4:
            hmProfit.put(p.getDate(), hmProfit.get(p.getDate()) + p.getScut().getPrice4());
            break;
          default:
            hmProfit.put(p.getDate(), hmProfit.get(p.getDate()) + p.getScut().getPrice5());
            break;
        }
      }


      Map<String, Integer> graphData = new TreeMap<>();
      Map<String, String> graphDataProfit = new TreeMap<>();
      for(String i : hm.keySet()) {
        graphData.put(i, hm.get(i));
      }
      System.out.println("New grah");
      for(Date i : hmProfit.keySet()) {
        graphDataProfit.put(String.valueOf(i), String.valueOf(hmProfit.get(i)));
        System.out.println("CHave: " + String.valueOf(i) + ", Tipo:" + String.valueOf(i).getClass().getName());
        System.out.println("Value: " + String.valueOf(hmProfit.get(i)) + ", Tipo:" + String.valueOf(hmProfit.get(i)).getClass().getName());
      }
      
      model.addAttribute("chartData", graphData);
      model.addAttribute("chartDataProfit", graphDataProfit);

		return "admin/dashboard";
    }

   
}