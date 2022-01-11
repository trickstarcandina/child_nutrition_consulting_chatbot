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
public class Guess {
    public double thinlv1, thinlv2, normall, fat1, fat2;

    public Guess(double thinlv1, double thinlv2, double normall, double fat1, double fat2) {
        this.thinlv1 = thinlv1;
        this.thinlv2 = thinlv2;
        this.normall = normall;
        this.fat1 = fat1;
        this.fat2 = fat2;
    }

    public Guess() {
    }

    public double getThinlv1() {
        return thinlv1;
    }

    public void setThinlv1(double thinlv1) {
        this.thinlv1 = thinlv1;
    }

    public double getThinlv2() {
        return thinlv2;
    }

    public void setThinlv2(double thinlv2) {
        this.thinlv2 = thinlv2;
    }

    public double getNormall() {
        return normall;
    }

    public void setNormall(double normall) {
        this.normall = normall;
    }

    public double getFat1() {
        return fat1;
    }

    public void setFat1(double fat1) {
        this.fat1 = fat1;
    }

    public double getFat2() {
        return fat2;
    }

    public void setFat2(double fat2) {
        this.fat2 = fat2;
    }




    
    
}
