package com.example.chatbotspring.data.repository;

import com.example.chatbotspring.data.entities.NhuCauNuoc;
import com.example.chatbotspring.data.entities.NhuCauProtein;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NhuCauNuocRepository extends JpaRepository<NhuCauNuoc, Long> {
    @Query(value = "select n from NhuCauNuoc n where n.tuoi >= ?1 order by tuoi")
    List<NhuCauNuoc> findByTuoi(double tuoi);
}
