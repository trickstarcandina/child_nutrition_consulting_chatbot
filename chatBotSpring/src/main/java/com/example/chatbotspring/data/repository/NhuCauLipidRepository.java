package com.example.chatbotspring.data.repository;

import com.example.chatbotspring.data.entities.NhuCauLipid;
import com.example.chatbotspring.data.entities.NhuCauProtein;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface NhuCauLipidRepository extends JpaRepository<NhuCauLipid, Long> {
    @Query(value = "select n from NhuCauLipid n where n.tuoiToiThieu < ?1 and n.tuoiToiDa >= ?1")
    NhuCauLipid findByTuoi(double tuoi);
}
