package com.FastTravel.FastTravelService.controller;


import java.util.List;

import com.FastTravel.FastTravelService.model.Admin;
import com.FastTravel.FastTravelService.service.AdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdminController {
    @Autowired
    private AdminService adminService;

    @PostMapping("/addAdmin")
    public Admin addAdmin(@RequestBody Admin admin) {
        return adminService.saveAdmin(admin);
    }

    @PostMapping("/addAdmins")
    public List<Admin> addAdmins(@RequestBody List<Admin> admins) {
        return adminService.saveAdmins(admins);
    }

    @GetMapping("/admins")
    public List<Admin> findAllAdmins() {
        return adminService.getAdmins();
    }

    @GetMapping("/adminById/{id}")
    public Admin findAdminById(@PathVariable Long id) {
        return adminService.getAdminById(id);
    }

    
    @PutMapping("/update/admin")
    public Admin updateAdmin(@RequestBody Admin admin) {
        return adminService.updateAdmin(admin);
    }

    @DeleteMapping("/deleteAdmin/{id}")
    public String deleteAdmin(@PathVariable Long id) {
        return adminService.deleteAdmin(id);
    }
}
