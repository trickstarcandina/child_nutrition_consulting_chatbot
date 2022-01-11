package com.example.chatbotspring.data.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ti_le_dinh_duong")
@Getter
@Setter
public class TileDinhDuong extends BaseEntity {
    private double tuoiToiThieu;
    private double tuoiToiDa;
    @Column(name = "tong_kcal")
    private double tongKcal;
    private double chatBeo;
    private double tinhBot;
    private double protein;
    // mcg/24h
    @Column(name = "vitamin_a")
    private double vitaminA;
    // mcg/24h
    @Column(name = "vitamin_b1")
    private double vitaminB1;
    @Column(name = "vitamin_b2")
    private double vitaminB2;
    @Column(name = "vitamin_b12")
    private double vitaminB12;
    // mg/24h
    @Column(name = "vitamin_c")
    private double vitaminC;
    @Column(name = "vitamin_d")
    private double vitaminD;
    // mg/24h
    @Column(name = "canxi")
    private double canxi;
}
