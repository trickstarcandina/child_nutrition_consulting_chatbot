package com.example.chatbotspring.data.repository;

import com.example.chatbotspring.data.entities.NhuCauVitamin;
import com.example.chatbotspring.data.entities.VaiTro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VaiTroRepository extends JpaRepository<VaiTro, Long> {
    @Query(value = "select v.vai_tro " +
            "from tu_van_dinh_duong.vai_tro v, dinh_duong d " +
            "where d.id = v.dinh_duong_id and d.ten = ?", nativeQuery = true)
    List<String> findByVaiTro(String tenChat);

    @Query(value = "select v.vai_tro " +
            "from tu_van_dinh_duong.vai_tro v" +
            "where dinh_duong_id = 5", nativeQuery = true)
    List<String> findByVaiTroVitamin();

    @Query(value = "select v.vai_tro " +
            "from tu_van_dinh_duong.vai_tro v" +
            "where dinh_duong_id = 6", nativeQuery = true)
    List<String> findByVaiTroKhoangChat();

}
