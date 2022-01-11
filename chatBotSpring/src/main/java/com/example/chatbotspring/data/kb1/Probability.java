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
public class Probability {
    double least = 0, normall = 0, hight = 0;

    public Probability() {
        least = 0;
        normall = 0;
        hight = 0;
    }

    public double getLeast() {
        return least;
    }

    public void setLeast(double least) {
        this.least = least;
    }

    public double getNormall() {
        return normall;
    }

    public void setNormall(double normall) {
        this.normall = normall;
    }

    public double getHight() {
        return hight;
    }

    public void setHight(double hight) {
        this.hight = hight;
    }


    
}
