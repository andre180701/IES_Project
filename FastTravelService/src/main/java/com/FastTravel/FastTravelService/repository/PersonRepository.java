package com.FastTravel.FastTravelService.repository;


import com.FastTravel.FastTravelService.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    //public Integer countByEmail(String email);
    //public Person findById(Long id);
}