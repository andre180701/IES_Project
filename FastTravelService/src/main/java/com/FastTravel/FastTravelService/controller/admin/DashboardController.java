package com.FastTravel.FastTravelService.controller.admin;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.ObjectFactory;
import javax.servlet.http.HttpSession;  
import org.springframework.beans.factory.annotation.Autowired;


@Controller
public class DashboardController {
  @Autowired
  ObjectFactory<HttpSession> httpSessionFactory;

    @GetMapping("admin/dashboard")
    public String getDashboard( Model model) {
      HttpSession session = httpSessionFactory.getObject();

      model.addAttribute("firstName", session.getAttribute("firstName"));
      model.addAttribute("lastName", session.getAttribute("lastName"));
      model.addAttribute("email", session.getAttribute("email"));
		return "admin/dashboard";
    }   
}