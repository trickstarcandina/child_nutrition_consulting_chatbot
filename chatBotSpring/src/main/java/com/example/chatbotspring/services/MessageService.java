package com.example.chatbotspring.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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
        return "";
    }

    // kịch bản 2
    private String tuVanVanDeDinhDuong(String message) {
        return "";
    }

    // kịch bản 3
    private String tuVanVaiTroDinhDuong(String message) {
        return "";
    }
}
