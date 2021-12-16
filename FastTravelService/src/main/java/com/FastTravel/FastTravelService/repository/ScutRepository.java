package com.FastTravel.FastTravelService.repository;

import com.FastTravel.FastTravelService.model.Scut;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScutRepository extends JpaRepository<Scut, Long> {
}