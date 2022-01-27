package com.FastTravel.FastTravelService.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Autowired;
import java.math.BigInteger; 
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest; 
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import com.FastTravel.FastTravelService.inputsForms.InputLogin;
import com.FastTravel.FastTravelService.model.Admin;
import com.FastTravel.FastTravelService.model.Client;
import com.FastTravel.FastTravelService.model.Passage;
import com.FastTravel.FastTravelService.service.AdminService;
import com.FastTravel.FastTravelService.service.ClientService;
import org.springframework.beans.factory.ObjectFactory;
import javax.servlet.http.HttpSession;  

import org.springframework.stereotype.Controller;

@Controller
public class LoginController {

  @Autowired
  private PassageController passageController;

  @Autowired
  private ClientService clientService;

  @Autowired
  private AdminService adminService;

  @Autowired
  ObjectFactory<HttpSession> httpSessionFactory;

  @ModelAttribute("inputLogin")
  public InputLogin getGreetingObject() {
    return new InputLogin();
  }

  @GetMapping("/login")
  public String getAskIdentifier(Model model) {
    return "login";
  }

  public static byte[] getSHA(String input) throws NoSuchAlgorithmException
  { 
      MessageDigest md = MessageDigest.getInstance("SHA-256"); 
      return md.digest(input.getBytes(StandardCharsets.UTF_8)); 
  }
  
  public static String toHexString(byte[] hash)
  {
      BigInteger number = new BigInteger(1, hash); 
      StringBuilder hexString = new StringBuilder(number.toString(16)); 

      while (hexString.length() < 32) 
      { 
          hexString.insert(0, '0'); 
      } 

      return hexString.toString(); 
  }

  @PostMapping("/login/check")
  public String greetingSubmit(@ModelAttribute InputLogin inputLogin, Model model) throws NoSuchAlgorithmException {
    HttpSession session = httpSessionFactory.getObject();
    String email = inputLogin.getEmail().strip();
    String password = inputLogin.getPassword();
    password = toHexString(getSHA(password));
    if (email == "" || password == "") {
      model.addAttribute("error", "All fields must be filled!");
      return "login";
    }

    Client client = clientService.getClientByEmail(email);

    
    if(client != null && client.getPassword().equals(password)) {
      session.setAttribute("email", email);
      session.setAttribute("firstName", client.getFirst_name());
      session.setAttribute("lastName", client.getLast_name());
      model.addAttribute("firstName", client.getFirst_name());
      model.addAttribute("lastName", client.getLast_name());
      model.addAttribute("email", email);
      return "client/home";
    }

    Admin admin = adminService.getAdminByEmail(email);
    
    if(admin != null && admin.getPassword().equals(password)) {
      System.out.println("ANtes de tudo");
      session.setAttribute("email", email);
      session.setAttribute("firstName", admin.getFirst_name());
      session.setAttribute("lastName", admin.getLast_name());
      model.addAttribute("firstName", admin.getFirst_name());
      model.addAttribute("lastName", admin.getLast_name());
      model.addAttribute("email", email);

      System.out.println("ANTES DE IR VUSCAR COISAS");
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
        
        System.out.println("CHave: " + String.valueOf(p.getDate()) + ", Tipo:" + String.valueOf(p.getDate()).getClass().getName());
        System.out.println("Value: " + String.valueOf(hmProfit.get(p.getDate())) + ", Tipo:" + String.valueOf(hmProfit.get(p.getDate())).getClass().getName());
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


    model.addAttribute("error", "Email and/or password incorrect!");
    return "login";
  }
}