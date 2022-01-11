package com.example.chatbotspring.data.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "nhu_cau_glucid")
@Getter
@Setter
public class NhuCauGlucid extends BaseEntity {
    private double tuoiToiThieu;
    private double tuoiToiDa;
    private double khoiLuong;
}
