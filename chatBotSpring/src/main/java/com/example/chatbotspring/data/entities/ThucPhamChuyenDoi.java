package com.example.chatbotspring.data.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "thuc_pham_chuyen_doi")
@Getter
@Setter
public class ThucPhamChuyenDoi extends BaseEntity {
    private String ten;
    private String nhom;
    private double kcal;
    private String tinhBot;
    private String chatBeoBaoHoa;
    private String protein;
    private double xo;

    public String getThucPham(){
        return ten+"("+kcal+"/"+"100g"+")";
    }
}
