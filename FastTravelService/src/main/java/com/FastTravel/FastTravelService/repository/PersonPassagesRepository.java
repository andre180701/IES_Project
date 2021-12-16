package com.FastTravel.FastTravelService.repository;
import com.FastTravel.FastTravelService.model.PersonPassages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonPassagesRepository extends JpaRepository<PersonPassages, Long> {
    public PersonPassages findByPersonId(long id);
}