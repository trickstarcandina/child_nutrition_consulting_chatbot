package com.example.chatbotspring.services;

import com.example.chatbotspring.data.entities.GiaiPhap;
import com.example.chatbotspring.data.entities.VanDeDinhDuong;
import com.example.chatbotspring.data.repository.GiaiPhapRepository;
import com.example.chatbotspring.data.repository.VanDeDinhDuongRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class MessageService {

    private final VanDeDinhDuongRepository vanDeDinhDuongRepository;
    private final GiaiPhapRepository giaiPhapRepository;
    private final ThucDonService thucDonService;

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
        message = message.substring(message.indexOf("chiều cao"));
        String[] cacThongTin = message.split(";");
        for (String thongTin : cacThongTin) {
            if (thongTin.contains("chiều cao")) {
                thongTin = thongTin.substring("chiều cao".length()+1, thongTin.indexOf("cm"));
                height = Double.parseDouble(thongTin.trim());
            }

            if (thongTin.contains("cân nặng")) {
                thongTin = thongTin.substring("cân nặng".length()+1, thongTin.indexOf("kg"));
                weight = Double.parseDouble(thongTin.trim());
            }
            if (thongTin.contains("giới tính")) {
                thongTin = thongTin.substring("giới tính".length()+1);
                sex = thongTin.trim();
            }
            if (thongTin.contains("tháng tuổi")) {
                thongTin = thongTin.substring(0, thongTin.indexOf("tháng tuổi"));
                month = Integer.parseInt(thongTin.trim());
            }

        }
        return thucDonService.result(sex, month, weight, height);
    }

    // kịch bản 2
    private String tuVanVanDeDinhDuong(String message) {
        String prefix = "Chào bác sĩ, cháu nhà tôi có hiện tượng";
        String suffix = "thì chế độ dinh dưỡng như thế nào để khắc phục ạ";
        message = message.substring(prefix.length(), message.indexOf(suffix)).trim();
        String[] cacHienTuong = message.split(";");
        List<VanDeDinhDuong> vanDeDinhDuongList = new ArrayList<>();
        for (String hienTuong : cacHienTuong) {
            vanDeDinhDuongList.addAll(vanDeDinhDuongRepository.findByHienTuong(hienTuong.trim()));
        }
        Map<String, Integer> map = new HashMap<>();
        int doPhuHopMax = 0;
        String vanDe = "";
        for (VanDeDinhDuong vanDeDinhDuong : vanDeDinhDuongList) {
            map.merge(vanDeDinhDuong.getVanDe(), vanDeDinhDuong.getMucDoPhuHop(), Integer::sum);
            if (map.get(vanDeDinhDuong.getVanDe()) > doPhuHopMax) {
                doPhuHopMax = map.get(vanDeDinhDuong.getVanDe());
                vanDe = vanDeDinhDuong.getVanDe();
            }
        }
        if (vanDe.isEmpty())
            return "Không thể tư vấn từ các hiện tượng trên";
        StringBuilder result = new StringBuilder("Từ hiện tượng, có thể cháu đang gặp vấn đề ");
        result.append(vanDe.toLowerCase()).append(", giải pháp cho vấn đề này là");
        List<GiaiPhap> giaiPhapList = giaiPhapRepository.findByVanDe(vanDe);
        for (GiaiPhap giaiPhap : giaiPhapList) {
            result.append("\n- ").append(giaiPhap.getGiaiPhap());
        }
        return result.toString();
    }

    // kịch bản 3
    private String tuVanVaiTroDinhDuong(String message) {
        return "";
    }

}
