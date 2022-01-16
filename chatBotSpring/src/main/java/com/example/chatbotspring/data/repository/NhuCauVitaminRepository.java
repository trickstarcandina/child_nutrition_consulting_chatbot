package com.example.chatbotspring.data.repository;

import com.example.chatbotspring.data.entities.NhuCauVitamin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface NhuCauVitaminRepository extends JpaRepository<NhuCauVitamin, Long> {

    @Query(value = "select n from NhuCauVitamin n where n.tuoiToiThieu < ?1 and n.tuoiToiDa >= ?1")
    NhuCauVitamin findByTuoi(double tuoi);
}
