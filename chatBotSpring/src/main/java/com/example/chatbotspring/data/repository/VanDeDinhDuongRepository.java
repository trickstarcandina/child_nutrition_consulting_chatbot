package com.example.chatbotspring.data.repository;

import com.example.chatbotspring.data.entities.VanDeDinhDuong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VanDeDinhDuongRepository extends JpaRepository<VanDeDinhDuong, Long> {

    @Query(value = "select v from VanDeDinhDuong v where v.bieuHien like %?1%")
    List<VanDeDinhDuong> findByHienTuong(String hienTuong);

}
