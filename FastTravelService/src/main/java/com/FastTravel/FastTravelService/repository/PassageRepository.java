package com.FastTravel.FastTravelService.repository;
import com.FastTravel.FastTravelService.model.Passage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassageRepository extends JpaRepository<Passage, Long> {
    public Passage findByPersonPassagesIdAndScutId(long person_passage_id, Long scut_id);
}