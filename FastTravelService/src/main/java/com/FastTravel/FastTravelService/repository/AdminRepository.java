package com.FastTravel.FastTravelService.repository;

import com.FastTravel.FastTravelService.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Long>{
    
}
