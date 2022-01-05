package com.FastTravel.FastTravelService.repository;

import com.FastTravel.FastTravelService.model.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CreditCardRepository extends JpaRepository<CreditCard,Long>{
    
}