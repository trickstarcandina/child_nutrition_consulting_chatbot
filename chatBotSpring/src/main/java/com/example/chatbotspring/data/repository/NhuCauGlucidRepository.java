package com.example.chatbotspring.data.repository;

import com.example.chatbotspring.data.entities.NhuCauGlucid;
import com.example.chatbotspring.data.entities.NhuCauProtein;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface NhuCauGlucidRepository extends JpaRepository<NhuCauGlucid, Long> {
    @Query(value = "select n from NhuCauGlucid n where n.tuoiToiThieu < ?1 and n.tuoiToiDa >= ?1")
    NhuCauGlucid findByTuoi(double tuoi);
}
