package com.FastTravel.FastTravelService.repository;

import com.FastTravel.FastTravelService.model.Identifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IdentifierRepository extends JpaRepository<Identifier,Long>{
    
}