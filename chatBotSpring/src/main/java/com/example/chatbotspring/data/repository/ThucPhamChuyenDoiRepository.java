package com.example.chatbotspring.data.repository;

import com.example.chatbotspring.data.entities.ThucPhamChuyenDoi;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ThucPhamChuyenDoiRepository extends JpaRepository<ThucPhamChuyenDoi, Long> {

    List<ThucPhamChuyenDoi> findByNhom(String nhom);
}
