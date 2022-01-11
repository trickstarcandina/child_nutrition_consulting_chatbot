/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.chatbotspring.data.kb1;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Admin
 */
public class ThucDon {
    LogicController logicController = new LogicController();
    DanhSachThucPham ds = new DanhSachThucPham();
    
    public float nangLuong(int month){
        float kcal = 0;
        if(month < 6) kcal = 620; else
            if(6 <= month && month < 12) kcal = 820; else
                if(12 <= month && month < 36 ) kcal = 1300; else
                    if(36 <= month && month < 72) kcal = 1600; 
        return kcal;
        
    }
    public String suaMe(int month){
        if(month <= 2) return "Lượng sữa mỗi lần cho bé bú là 60-120ml, cho trẻ bú bất cứ khi nào trẻ muốn, cả ngày lẫn đêm ít nhất 8 lần/ngày\n"; else
            if(month > 2 && month <= 4) return "Lượng sữa mỗi lần cho bé bú là 120-180ml, cho trẻ bú bất cứ khi nào trẻ muốn, cả ngày lẫn đêm ít nhất 8 lần/ngày\n"; else 
                if(month > 4 && month <= 6) return "Lượng sữa mỗi lần cho bé bú là 120-240ml, cho trẻ bú bất cứ khi nào trẻ muốn, cả ngày lẫn đêm ít nhất 8 lần/ngày"
                        + "\nCó thể cho bé tập ăn dặm nếu bé đã ngồi vững, nhưng không nhất thiết cho trẻ ăn dặm vào lúc này\n"; else 
                    if(month >6 && month <= 12) return "Lượng sữa mỗi lần cho bé bú là 240ml, ít nhất 8 lần/ngày"
                            + "\nBắt đầu cho bé làm quan với các thực phẩm mềm như: ngũ cốc, thịt và trái cây xay nhuyễn. Sau đó, dần dấn đến các món được nghiền và xắt nhỏ\n";
            
        return "";
    }
    public String thucDonDinhDuong(String sex, int month, double weight, double height){
        String tinhtrang = logicController.result(sex, month, weight, height);
        float kcal = nangLuong(month);
        if(tinhtrang.equals("Suy dinh dưỡng cấp 1")) kcal = (float) (kcal*1.1); else
            if(tinhtrang.equals("Suy dinh dưỡng cấp 2")) kcal = (float) (kcal*1.2); else
                if(tinhtrang.equals("Thừa cân")) kcal = (float) (kcal*0.9); else
                    if(tinhtrang.equals("Béo phì")) kcal = (float) (kcal*0.8);
         
        float tinhbot = 0, chatbeo = 0, protein = 0;
        if(12 <= month && month < 36){
            chatbeo = (float) (kcal*0.35);
            tinhbot = (float) (kcal*0.53);
            protein = (float) (kcal*0.12);
        } else
            if(36 <= month && month <= 72){
                chatbeo = (float) (kcal*0.25);
                tinhbot = (float) (kcal*0.63);
                protein = (float) (kcal*0.12);
            }
        
        Random Rand = new Random(); // random thuc pham
        
        StringBuilder tb = new StringBuilder(); // random tinh bot
        ArrayList<Integer> listtb = new ArrayList<Integer>(5);
        for(int i = 0; i < 5; i++) {
            listtb.add(i);
        }

        for(int i = 1 ; i <= 3 ; i++){
            int index = Rand.nextInt(listtb.size());
            int id = listtb.remove(index);
            tb.append(ds.tinhbot.get(id).getThucPham());
            tb.append(',');
        }
        
        
        StringBuilder cb = new StringBuilder(); // random chat beo
        ArrayList<Integer> listcb = new ArrayList<Integer>(4);
        for(int i = 0; i < 4; i++) {
            listcb.add(i);
        }

        for(int i = 1 ; i <= 3 ; i++){
            int index = Rand.nextInt(listcb.size());
            int id = listcb.remove(index);
            cb.append(ds.chatbeo.get(id).getThucPham());
            cb.append(',');
        }

        
        StringBuilder pr = new StringBuilder(); // random protein
        ArrayList<Integer> listpr = new ArrayList<Integer>(11);
        for(int i = 0; i < 11; i++) {
            listpr.add(i);
        }

        for(int i = 1 ; i <= 3 ; i++){
            int index = Rand.nextInt(listcb.size());
            int id = listpr.remove(index);
            pr.append(ds.protein.get(id).getThucPham());
            pr.append(',');
        }        
        
        
        return "với thông tin đầu vào thì tình trạng của bé là: "+ tinhtrang + "\n" +
               "năng lương cần cung cấp cho bé trong một ngày là: "+ kcal + " kcal\n"+
                "bao gồm:\n" + 
                tinhbot + " kcal từ " + tb.toString() + "\n"+
                chatbeo + " kcal từ " + cb.toString() + "\n"+
                protein + " kcal từ " + pr.toString() + "\n";
    }
    
    public String vitamin(int month){
        if(month < 6) return "Vitamin A: 300mcg/ngày, Vitamin B1 và B2:1-2mcg/ngày, Vitamin B12:2mcg/ngày, Vitamin C:30mg/ngày, Canxi: 300mg/ngày";else
            if(6<=month && month <12) return "Vitamin A: 500-600mcg/ngày, Vitamin B1 và B2:1-2mcg/ngày, Vitamin B12:2mcg/ngày, Vitamin C:30mg/ngày, Canxi: 500mg/ngày";else 
                if(12<=month && month < 36) return "Vitamin A: 500-600mcg/ngày, Vitamin B1 và B2:1-2mcg/ngày, Vitamin B12:2mcg/ngày, Vitamin C:60-70mg/ngày, Canxi: 500mg/ngày"; else 
                    if(36<=month && month <= 72) return  "Vitamin A: 500-600mcg/ngày, Vitamin B1 và B2:1-2mcg/ngày, Vitamin B12:2mcg/ngày, Vitamin C:60-70mg/ngày, Canxi: 500mg/ngày";
                    
        return "";
    }
    
    public String result(String sex, int month, double weight, double height){
        if(month <= 12) return suaMe(month) + "các Vitamin cần cung cấp cho trẻ:\n" + vitamin(month);
        else return thucDonDinhDuong(sex, month, weight, height) + "các Vitamin cần cung cấp cho trẻ:\n" + vitamin(month);
    }
    public static void main(String[] args) {
        ThucDon thucDon = new ThucDon();
        System.out.println(thucDon.result("Nam", 36, 14, 90));
    //    System.out.println(thucDon.result("Nam", 10, 14, 90));
        
    }
}
