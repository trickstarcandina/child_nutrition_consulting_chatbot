package com.example.chatbotspring.data.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "nhu_cau_protein")
@Getter
@Setter
public class NhuCauProtein extends BaseEntity {
    // tính theo tháng
    private double tuoiToiThieu;
    private double tuoiToiDa;
    private double khoiLuong;
}
