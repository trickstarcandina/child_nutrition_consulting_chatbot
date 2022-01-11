/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.chatbotspring.data.kb1;

import java.io.Serializable;

/**
 *
 * @author Admin
 */
public class Standard implements Serializable{
    private String sex;
    private int month;
    private double weightmin;
    private double weightmax;
    private double heightmin;
    private double heightmax;
    

    public Standard() {
    }

    public Standard(String sex, int month, double weightmin, double weightmax, double heightmin, double heightmax) {
        this.sex = sex;
        this.month = month;
        this.weightmin = weightmin;
        this.weightmax = weightmax;
        this.heightmin = heightmin;
        this.heightmax = heightmax;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public double getWeightmin() {
        return weightmin;
    }

    public void setWeightmin(double weightmin) {
        this.weightmin = weightmin;
    }

    public double getWeightmax() {
        return weightmax;
    }

    public void setWeightmax(double weightmax) {
        this.weightmax = weightmax;
    }

    public double getHeightmin() {
        return heightmin;
    }

    public void setHeightmin(double heightmin) {
        this.heightmin = heightmin;
    }

    public double getHeightmax() {
        return heightmax;
    }

    public void setHeightmax(double heightmax) {
        this.heightmax = heightmax;
    }


    
    


}
