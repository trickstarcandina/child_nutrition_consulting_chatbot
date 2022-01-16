package com.example.chatbotspring.data.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.List;

@Entity
@Table(name = "hien_tuong")
@Getter
@Setter
public class HienTuong extends BaseEntity {
    private String vanDe;
    private String bieuHien;
    private int mucDoPhuHop;

    @Transient
    private List<GiaiPhap> cacGiaiPhap;

}
