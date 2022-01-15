package com.example.chatbotspring.data.repository;

import com.example.chatbotspring.data.entities.NhuCauChatKhoang;
import com.example.chatbotspring.data.entities.NhuCauProtein;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface NhuCauKhoangChatRepository extends JpaRepository<NhuCauChatKhoang, Long> {
    @Query(value = "select n from NhuCauChatKhoang n where n.tuoiToiThieu < ?1 and n.tuoiToiDa >= ?1")
    NhuCauChatKhoang findByTuoi(double tuoi);
}
