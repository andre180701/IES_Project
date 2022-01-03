package com.FastTravel.FastTravelService.controller.admin;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;

@Controller
public class DashboardController {
    @GetMapping("/dashboard")
    public String getDashboard( Model model) {
		return "admin/dashboard";
    }   
}