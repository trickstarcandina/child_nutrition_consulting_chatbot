package com.example.chatbotspring.data.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "vai_tro")
@Getter
@Setter
public class VaiTro extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "dinh_duong_id")
    private DinhDuong dinhDuong;
    private String vaiTro;
}