package com.example.chatbotspring.data.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "chieu_cao_can_nang")
@Getter
@Setter
public class ChieuCaoCanNang extends BaseEntity {
    private double tuoi;
    private double canNangToiThieu;
    private double canNangToiDa;
    private double chieuCaoToiThieu;
    private double chieuCaoToiDa;
    private String gioiTinh;
}
