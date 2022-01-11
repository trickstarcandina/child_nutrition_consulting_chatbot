package com.example.chatbotspring.data.repository;

import com.example.chatbotspring.data.entities.ChieuCaoCanNang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ChieuCaoCanNangRepository extends JpaRepository<ChieuCaoCanNang, Long> {

    @Query(value = "select c from ChieuCaoCanNang c where c.tuoi = ?1 and c.gioiTinh = ?2")
    ChieuCaoCanNang findByTuoiAndGioiTinh(double tuoi, String gioiTinh);
}
