package com.example.chatbotspring.data.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "nhu_cau_vitamin")
@Getter
@Setter
public class NhuCauVitamin extends BaseEntity {
    private double tuoiToiThieu;
    private double tuoiToiDa;
    @Column(name = "vitamin_a")
    private double vitaminA;
    @Column(name = "vitamin_d")
    private double vitaminD;
    @Column(name = "vitamin_e")
    private double vitaminE;
    @Column(name = "vitamin_k")
    private double vitaminK;
    @Column(name = "vitamin_b1")
    private double vitaminB1;
    @Column(name = "vitamin_b2")
    private double vitaminB2;
    @Column(name = "vitamin_b3")
    private double vitaminB3;
    @Column(name = "vitamin_b6")
    private double vitaminB6;
    @Column(name = "vitamin_b9")
    private double vitaminB9;
    @Column(name = "vitamin_b12")
    private double vitaminB12;
    @Column(name = "vitamin_C")
    private double vitaminC;

    @Override
    public String toString() {
        return "Vitamin A: " + vitaminA + "mcg/ ngày" +
                ", Vitamin D: " + vitaminD + "mcg/ ngày" +
                ", Vitamin E: " + vitaminE + "mcg/ ngày" +
                ", Vitamin K: " + vitaminK + "mcg/ ngày" +
                ", Vitamin B1: " + vitaminB1 + "mcg/ ngày" +
                ", Vitamin B2: " + vitaminB2 + "mcg/ ngày" +
                ", Vitamin B3: " + vitaminB3 + "mcg/ ngày" +
                ", Vitamin B6: " + vitaminB6 + "mcg/ ngày" +
                ", Vitamin B9: " + vitaminB9 + "mcg/ ngày" +
                ", Vitamin B12: " + vitaminB12 + "mcg/ ngày" +
                ", Vitamin C: " + vitaminC + "mcg/ ngày";
    }
}
