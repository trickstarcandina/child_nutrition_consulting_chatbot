/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.chatbotspring.data.kb1;


/**
 *
 * @author Admin
 */
public class LogicController {
    public  DataLogic datas = new DataLogic();
    public Probability c_height = new Probability(), c_weight = new Probability();
    public Guess guess = new Guess();
    
    public Standard find(String sex, int month){
        boolean check = false;
        for(int i = 0 ; i < datas.list.size() ; i++){
            Standard standard = datas.list.get(i);
            if(sex.equals(standard.getSex()) && month == standard.getMonth()){
                check = true;
                return standard;
            }
        }
        if(!check) return findFuzzy(sex, month);
        return null;
    }
    
    public Standard findFuzzy(String sex, int month){
        Standard smin = null, smax = null;
        for(int i = 0 ; i < datas.list.size()-2 ; i++){
            Standard standard1 = datas.list.get(i);
            Standard standard2 = datas.list.get(i+2);
            if(sex.equals(standard1.getSex()) && month > standard1.getMonth() && month < standard2.getMonth()){
                smin = standard1;
                smax = standard2;
                break;
            }
        }
//        System.out.println(smin.toString());
//        System.out.println(smax.toString());
        double heightmin = smin.getHeightmin()+ (smax.getHeightmin()-smin.getHeightmin())*(month-smin.getMonth())/(smax.getMonth()-smin.getMonth());
        double heightmax = smin.getHeightmax()+ (smax.getHeightmax()-smin.getHeightmax())*(month-smin.getMonth())/(smax.getMonth()-smin.getMonth());
        double weightmin = smin.getWeightmin()+ (smax.getWeightmin()-smin.getWeightmin())*(month-smin.getMonth())/(smax.getMonth()-smin.getMonth());
        double weightmax = smin.getWeightmax()+ (smax.getWeightmax()-smin.getWeightmax())*(month-smin.getMonth())/(smax.getMonth()-smin.getMonth());
        Standard standardFuzzy = new Standard("sex", month, heightmin, heightmax , weightmin , weightmax);
        return standardFuzzy;
    }
    
    public void probalility(String sex, int month, double weight, double height){
        Standard standard = find(sex, month);
        
        if(height < standard.getHeightmin()) c_height.least = 1; else
            if(height >= standard.getHeightmin() && height < (standard.getHeightmax()+standard.getHeightmin())/2) {
                c_height.normall = 2*(double)(height - standard.getHeightmin())/(standard.getHeightmax()-standard.getHeightmin());
                c_height.least = 1 - c_height.normall;
            } else 
                if(height >= (standard.getHeightmax()+standard.getHeightmin())/2 && height <= standard.getHeightmax()){
                    c_height.hight = 2*(standard.getHeightmax()-height)/(standard.getHeightmax()-standard.getHeightmin());
                    c_height.normall = 1-c_height.hight;
                } else
                    if (height >= standard.getHeightmax()) {
                        c_height.hight = 1;
                    }
        
        if(weight < standard.getWeightmin()) c_weight.least = 1; else
            if(weight >= standard.getWeightmin() && weight < (standard.getWeightmax()+standard.getWeightmin())/2) {
                c_weight.normall = 2*(double)(weight - standard.getWeightmin())/(standard.getWeightmax()-standard.getWeightmin());
                c_weight.least = 1 - c_weight.normall;
            } else 
                if(weight >= (standard.getWeightmax()+standard.getWeightmin())/2 && weight <= standard.getWeightmax()){
                    c_weight.hight = 2*(standard.getWeightmax()-weight)/(standard.getWeightmax()-standard.getWeightmin());
                    c_weight.normall = 1-c_weight.hight;
                } else 
                    if(weight >= standard.getWeightmax()){
                        c_weight.hight = 1;
                    }
    }
    
    public String result(String sex, int month, double weight, double height){
        probalility(sex, month, weight, height);
        guess.thinlv1 = Double.max(Double.min(c_height.hight, c_weight.least), Double.max(Double.min(c_height.normall, c_weight.least), Double.min(c_height.least, c_weight.normall)));
        guess.thinlv2 = Double.min(c_height.least, c_weight.least);
        guess.fat1 = Double.max(Double.min(c_height.normall, c_weight.hight), Double.min(c_height.hight, c_weight.hight));
        guess.fat2 = Double.min(c_height.least, c_weight.hight);
        guess.normall = Double.max(Double.min(c_height.normall, c_weight.normall), Double.min(c_height.hight, c_weight.normall));
        double probabilityMax = 0;
        probabilityMax = Double.max(guess.thinlv1, Double.max(guess.thinlv2, Double.max(guess.normall, Double.max(guess.fat1, guess.fat2))));
        if(probabilityMax == guess.thinlv1) return "Suy dinh dưỡng cấp 1"; else
            if(probabilityMax == guess.thinlv2) return "Suy dinh dưỡng cấp 2"; else
                if(probabilityMax == guess.normall) return "Bình thường"; else
                    if(probabilityMax == guess.fat1) return "Thừa cân"; else
                    return "Béo phì"; 
    
    }
    
    public static void main(String[] args) {
         
        LogicController logicController = new LogicController();


        String result = logicController.result("Nam", 12, 10, 78);
        
        System.out.println("cao :"+logicController.c_height.least + ":" + logicController.c_height.normall + ":" + logicController.c_height.hight);
        System.out.println("nang:"+logicController.c_weight.least + ":" + logicController.c_weight.normall + ":" + logicController.c_weight.hight);          
        System.out.println("tỉ lệ theo logic mờ");
        System.out.println(logicController.guess.thinlv2 + ":" + logicController.guess.thinlv1 + ":" + 
                logicController.guess.normall + ":" + logicController.guess.fat1 + ":" + logicController.guess.fat2);
        System.out.println("kết quả: " + result);
    }
}
