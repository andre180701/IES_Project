package com.FastTravel.FastTravelService.controller.admin;

import com.FastTravel.FastTravelService.repository.*;
import com.FastTravel.FastTravelService.model.*;
import com.FastTravel.FastTravelService.controller.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.ObjectFactory;
import javax.servlet.http.HttpSession;  


//@EnableJpaRepositories(basePackageClasses = {ScutRepository.class})
//@RestController
@Controller
public class ScutsController{
    @Autowired
    ObjectFactory<HttpSession> httpSessionFactory;

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
}