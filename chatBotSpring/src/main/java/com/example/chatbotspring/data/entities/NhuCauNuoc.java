package com.example.chatbotspring.data.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "nhu_cau_nuoc")
@Getter
@Setter
public class NhuCauNuoc extends BaseEntity {
    // tính theo tháng
    private double tuoi;
    // tính theo kg
    private double canNang;
    // nước/kg/24h (ml) tối thiểu
    private double dungLuongToiThieu;
    // nước/kg/24h (ml) tối đa
    private double dungLuongToiDa;
}
