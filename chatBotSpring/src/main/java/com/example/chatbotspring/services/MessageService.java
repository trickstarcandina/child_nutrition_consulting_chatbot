package com.example.chatbotspring.services;

import com.example.chatbotspring.data.kb1.ThucDon;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.StringTokenizer;

@Service
@AllArgsConstructor
public class MessageService {

    public String solveMessage(String message) {
        if (message.startsWith("Chào bác sĩ, tôi muốn hỏi chế độ ăn cho cháu có")
                && message.contains("chiều cao") && message.contains("cân nặng")
                && message.contains("giới tính") && message.contains("tuổi"))
            return tuVanKhauPhanAn(message);
        if (message.startsWith("Chào bác sĩ, cháu nhà tôi có hiện tượng") && message.contains("thì chế độ dinh dưỡng như thế nào để khắc phục ạ"))
            return tuVanVanDeDinhDuong(message);
        if (message.startsWith("Chào bác sĩ, tôi cần biết thông tin về chất") && message.contains("tuổi"))
            return tuVanVaiTroDinhDuong(message);
        return "Không thể nhận dạng thông tin cần tư vấn";
    }

    // kịch bản 1
    private String tuVanKhauPhanAn(String message) {
        double height = 0, weight = 0;
        int month = 0;
        String sex=null;
        for(int i = 0; i < message.length()-1 ; i++){
            if(message.charAt(i)=='o' && message.charAt(i+1)==':' ){
                StringBuilder s = new StringBuilder("");
                i=i+2;
                while(message.charAt(i)!=' '){
                    s.append(message.charAt(i));
                    i++;
                }
                height = Double.valueOf(s.toString());
                break;
            }
        }

        for(int i = 0; i < message.length()-1 ; i++){
            if(message.charAt(i)=='g' && message.charAt(i+1)==':' ){
                StringBuilder s = new StringBuilder("");
                i=i+2;
                while(message.charAt(i)!=' '){
                    s.append(message.charAt(i));
                    i++;
                }
                weight = Double.valueOf(s.toString());
                break;
            }
        }

        for(int i = 0; i < message.length()-1 ; i++){
            if(message.charAt(i)=='h' && message.charAt(i+1)==':' ){
                StringBuilder s = new StringBuilder("");
                i=i+2;
                while(message.charAt(i)!=' '){
                    s.append(message.charAt(i));
                    i++;
                }
                sex = s.toString();
                break;
            }
        }

        for(int i = 0; i < message.length()-1 ; i++){
            if(message.charAt(i)=='i' && message.charAt(i+1)==':' ){
                StringBuilder s = new StringBuilder("");
                i=i+2;
                while(message.charAt(i)!=' '){
                    s.append(message.charAt(i));
                    i++;
                }
                month = Integer.valueOf(s.toString() );
                break;
            }
        }
    //    System.out.println(height + " " + weight + " " + sex + " " + month);
        ThucDon td = new ThucDon();
        return td.result(sex, month, weight, height);
    }

    // kịch bản 2
    private String tuVanVanDeDinhDuong(String message) {
        return "";
    }

    // kịch bản 3
    private String tuVanVaiTroDinhDuong(String message) {
        return "";
    }

    public static void main(String[] args) {
         MessageService messageService = new MessageService();
         String result = messageService.tuVanKhauPhanAn("Chào bác sĩ, tôi muốn hỏi chế độ ăn cho cháu có chiều cao:90 cm cân nặng:14 kg giới tính:Nam tuổi:36 tháng tuổi");
         System.out.println(result);
    }
}
