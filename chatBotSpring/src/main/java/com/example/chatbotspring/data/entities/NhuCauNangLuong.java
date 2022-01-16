package com.example.chatbotspring.data.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "nhu_cau_nang_luong")
@Getter
@Setter
public class NhuCauNangLuong extends BaseEntity {
    // tính theo tháng
    private double tuoiToiThieu;
    private double tuoiToiDa;
    private double nangLuong;

}
