package com.example.chatbotspring.data.repository;

import com.example.chatbotspring.data.entities.HienTuong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HienTuongRepository extends JpaRepository<HienTuong, Long> {

    @Query(value = "select h from HienTuong h where h.bieuHien like %?1%")
    List<HienTuong> findByHienTuong(String hienTuong);

}
