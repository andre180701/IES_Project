package com.FastTravel.FastTravelService.service;


import com.FastTravel.FastTravelService.repository.AdminRepository;
import com.FastTravel.FastTravelService.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;
    
    public Admin saveAdmin(Admin admin){
        return adminRepository.save(admin);
    }

    public List<Admin> saveAdmins(List<Admin> admins) {
        return adminRepository.saveAll(admins);
    }

    public List<Admin> getAdmins(){
        return adminRepository.findAll();
    }

    public Admin getAdminById(Long id) {
        return adminRepository.findById(id).orElse(null);
    }

    public String deleteAdmin(Long id) {
        adminRepository.deleteById(id);
        return "admin removed !! " + id;
    }

    public Admin getAdminByEmail(String email) {
        return adminRepository.findByEmail(email);
    }

    public Admin updateAdmin(Admin admin) {
        Admin existingAdmin = adminRepository.findById(admin.getId()).orElse(null);
        existingAdmin.setEmail(admin.getEmail());
        existingAdmin.setPassword(admin.getPassword());
        existingAdmin.setFirst_name(admin.getFirst_name());
        existingAdmin.setLast_name(admin.getLast_name());
        return adminRepository.save(existingAdmin);
    }
    

}
