/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.chatbotspring.data.kb1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class DanhSachThucPham {
    public List<ThucPham>tinhbot = new ArrayList<>();
    public List<ThucPham>chatbeo = new ArrayList<>();
    public List<ThucPham>protein = new ArrayList<>();
    
    public void addData(){
        tinhbot.add(new ThucPham("Cơm", 150));
        tinhbot.add(new ThucPham("Bánh mì đen", 250));
        tinhbot.add(new ThucPham("Bánh mì", 266));
        tinhbot.add(new ThucPham("Ngô ngọt", 96));
        tinhbot.add(new ThucPham("Chuối", 89));
        
        chatbeo.add(new ThucPham("Thịt ba chỉ", 260));
        chatbeo.add(new ThucPham("Thịt gà", 187));
        chatbeo.add(new ThucPham("Bắp bò", 201));
        chatbeo.add(new ThucPham("Phô mai", 259));
        
        protein.add(new ThucPham("Trứng", 160));
        protein.add(new ThucPham("Cà chua xanh", 23));
        protein.add(new ThucPham("Ca rốt", 41));
        protein.add(new ThucPham("Cá thu", 114));
        protein.add(new ThucPham("Rau muống", 30));
        protein.add(new ThucPham("Rau đay", 25));
        protein.add(new ThucPham("Rau ngót", 26));
        protein.add(new ThucPham("Rau cần tây", 16));
        protein.add(new ThucPham("Súp lơ", 30));
        protein.add(new ThucPham("Bầu", 20));
        protein.add(new ThucPham("Bưởi", 38));
        
        
    }

    public DanhSachThucPham() {
        addData();
    }
    

}
