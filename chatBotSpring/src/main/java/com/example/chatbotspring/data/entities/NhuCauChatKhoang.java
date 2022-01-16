package com.example.chatbotspring.data.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "nhu_cau_chat_khoang")
@Getter
@Setter
public class NhuCauChatKhoang extends BaseEntity {
    private double tuoiToiThieu;
    private double tuoiToiDa;
    // 10^-6g/ngay
    private double iot;
    // 10^-3g/ngay
    private double sat;
    // 10^-3g/ngay
    private double maggie;
    // 10^-3g/ngay
    private double canxi;
    // 10^-3g/ngay
    private double phospho;
    // 10^-3g/ngay
    private double kem;
    // 10^-6g/ngay
    private double dong;
    // 10^-6g/ngay
    private double seleni;

    @Override
    public String toString() {
        return "Iot: " + iot + " 10^-6g/ngày" +
                ", Sắt: " + sat + " 10^-3g/ngày" +
                ", Maggie: " + maggie+ " 10^-3g/ngày" +
                ", Canxi: " + canxi + " 10^-3g/ngày" +
                ", Phospho: " + phospho + " 10^-3g/ngày" +
                ", Kem: " + kem + " 10^-3g/ngày" +
                ", Đồng: " + dong + " 10^-6g/ngày" +
                ", Seleni: " + seleni + " 10^-6g/ngày";
    }
}
