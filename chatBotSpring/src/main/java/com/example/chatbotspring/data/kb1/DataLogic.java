/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.chatbotspring.data.kb1;

import java.util.ArrayList;
import com.example.chatbotspring.data.kb1.Standard;

/**
 *
 * @author Admin
 */
public class DataLogic {
    public  ArrayList<Standard>list = new ArrayList<>();
 
    public void addData(){
        Standard s;
        // sex month weightmin weightmax heightmin heightmax 
        list.add(s = new Standard("Nam", 0, 2.9 , 3.8 , 48.2 , 52.8));
        list.add(s = new Standard("Nữ", 0 , 2.7 , 3.6 , 47.7 , 52.0));
        list.add(s = new Standard("Nam", 1 , 3.6 , 5 , 52.1 , 52.8));
        list.add(s = new Standard("Nữ", 1 , 3.4 , 4.5 , 52.1 , 55.8));
        list.add(s = new Standard("Nam", 2 , 4.3 , 6 , 55.5 , 60.7));
        list.add(s = new Standard("Nữ", 2 , 4.0 , 5.4 , 54.4 , 59.2));
        list.add(s = new Standard("Nam", 3 , 5 , 6.9 , 58.7 , 63.7));
        list.add(s = new Standard("Nữ", 3 , 5.3 , 6.9 , 57.1 , 59.5));
        list.add(s = new Standard("Nam", 4 , 5.7 , 7.6 , 61.0 , 66.4));
        list.add(s = new Standard("Nữ", 4 , 5.8 , 7.5 , 59.5 , 64.5));
        list.add(s = new Standard("Nam", 5 , 6.3 , 8.2 , 63.2 , 68.6));
        list.add(s = new Standard("Nữ", 5 , 6.3 , 8.1 , 61.5 , 66.7));
        list.add(s = new Standard("Nam", 6 , 7.3 , 8.5 , 65.1 , 70.5));
        list.add(s = new Standard("Nữ", 6 , 6.8 , 8.7 , 63.3 , 68.6));
        list.add(s = new Standard("Nam", 7 , 7.4 , 9.2 , 69.2 , 73.4));
        list.add(s = new Standard("Nữ", 7 , 7.1 , 9.0 , 67.3 , 74.2));
        list.add(s = new Standard("Nam", 8 , 7.7 , 9.6 , 70.3 , 75.7));
        list.add(s = new Standard("Nữ", 8 , 7.7 , 9.1 , 68.7 , 75.8));
        list.add(s = new Standard("Nam", 9 , 8.25 , 9.75 , 70.6 , 72.2));
        list.add(s = new Standard("Nữ", 9 , 8.2 , 9.3 , 70.1 , 77.4));
        list.add(s = new Standard("Nam", 10 , 8.3 , 10.2 , 73.3 , 80.1));
        list.add(s = new Standard("Nữ", 10 , 8.5 , 9.6 , 71.5 , 78.9));
        list.add(s = new Standard("Nam", 11 , 8.4 , 10.5 , 74.1 , 81.5));
        list.add(s = new Standard("Nữ", 11 , 8.7 , 9.9 , 72.8 , 80.3));
        list.add(s = new Standard("Nam", 12 , 8.9 , 10.4 , 74.5 , 82.9));
        list.add(s = new Standard("Nam", 18 , 9 , 13.7 , 76.9 , 88.7));
        list.add(s = new Standard("Nữ", 18 , 8.1 , 13.2 , 74.9 , 86.5));
        list.add(s = new Standard("Nữ", 12 , 8.9 , 10.1 , 74.0 , 81.7));
        list.add(s = new Standard("Nam", 24 , 9.7 , 15.3 , 81.7 , 93.9));
        list.add(s = new Standard("Nữ", 24 , 9 , 14.8 , 80 , 92.9));
        list.add(s = new Standard("Nam", 30 , 10.5 , 16.9 , 85.1 , 102.1));
        list.add(s = new Standard("Nữ", 30 , 10 , 16.5 , 83.6 , 97.7));
        list.add(s = new Standard("Nam", 36 , 11.3 , 18.3 , 88.7 , 107.2));
        list.add(s = new Standard("Nữ", 36 , 10.8 , 18.1 , 87.4 , 102.7));
        list.add(s = new Standard("Nam", 42 , 12 , 19.7 , 91.9 , 117.7));
        list.add(s = new Standard("Nữ", 42 , 11.6 , 19.8 , 90.9 , 107.2));
        list.add(s = new Standard("Nam", 48 , 12.7 , 21.2 , 94.9 , 115.9));
        list.add(s = new Standard("Nữ", 48 , 12.3 , 21.5 , 94.1 , 111.3));
        list.add(s = new Standard("Nam", 54 , 13.4 , 22.7 , 97.8 , 119.9));
        list.add(s = new Standard("Nữ", 54 , 13 , 23.2 , 97.1 , 115.2));
        list.add(s = new Standard("Nam", 60 , 14.1 , 24.2 , 100.7 , 123.9));
        list.add(s = new Standard("Nữ", 60 , 13.7 , 24.9 , 99.9 , 118.9));
    }
    public DataLogic() {
        addData();
        
    }
//    public static void main(String[] args) {
//        DataLogic data = new DataLogic();
//        System.out.println(data.list.size());
//        System.out.println(data.list.get(10).toString());
//    }
    
}
