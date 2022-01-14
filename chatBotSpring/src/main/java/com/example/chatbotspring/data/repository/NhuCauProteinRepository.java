package com.example.chatbotspring.data.repository;

import com.example.chatbotspring.data.entities.NhuCauProtein;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface NhuCauProteinRepository extends JpaRepository<NhuCauProtein, Long> {
    @Query(value = "select n from NhuCauProtein n where n.tuoiToiThieu < ?1 and n.tuoiToiDa >= ?1")
    NhuCauProtein findByTuoi(double tuoi);
}
