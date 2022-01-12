package com.example.chatbotspring.data.repository;

import com.example.chatbotspring.data.entities.GiaiPhap;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GiaiPhapRepository extends JpaRepository<GiaiPhap, Long> {

    List<GiaiPhap> findByVanDe(String vanDe);
}
