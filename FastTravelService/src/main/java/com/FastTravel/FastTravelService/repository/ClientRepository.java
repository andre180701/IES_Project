package com.FastTravel.FastTravelService.repository;

import com.FastTravel.FastTravelService.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    
}