package com.example.chatbotspring.data.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "dinh_duong")
@Getter
@Setter
public class DinhDuong extends BaseEntity {
    private String nhom;
    private String ten;

    @OneToMany(mappedBy = "dinhDuong")
    private List<VaiTro> dsVaiTro;
}
