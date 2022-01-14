package com.example.chatbotspring.services;

import com.example.chatbotspring.data.entities.*;
import com.example.chatbotspring.data.repository.*;
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
    private final VaiTroRepository vaiTroRepository;
    private final NhuCauVitaminRepository nhuCauVitaminRepository;
    private final NhuCauProteinRepository nhuCauProteinRepository;
    private final NhuCauLipidRepository nhuCauLipidRepository;
    private final NhuCauGlucidRepository nhuCauGlucidRepository;
    private final NhuCauNuocRepository nhuCauNuocRepository;

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
        String chat = message.substring(43,message.indexOf("cho trẻ")).replace(" ","");
        String tuoi = message.substring(message.indexOf("cho trẻ") + 7,message.indexOf("tuổi")).replace(" ","");
        //check query return null => ko có csdl
        StringBuffer vaitro = new StringBuffer();
        StringBuffer dinhduong = new StringBuffer();
        if(chat.contains("Vitamin")) {
            List<String> vaiTroList = vaiTroRepository.findByVaiTroVitamin();
            for(int i=0; i<vaiTroList.size(); i++) {
                if(vaiTroList.get(i).contains(chat)) {
                    vaitro.append(vaiTroList.get(i));
                    vaitro.append("\n");
                }
            }
            NhuCauVitamin nhuCauVitamin = nhuCauVitaminRepository.findByTuoi(Double.valueOf(tuoi));
            if(chat.equals("Vitamin")) {
                vaitro.append(nhuCauVitamin.toString());
            }
            else if (chat.equals("Vitamin A")) {
                vaitro.append(nhuCauVitamin.getVitaminA());
            }
            else if (chat.equals("Vitamin D")) {
                vaitro.append(nhuCauVitamin.getVitaminD());
            }
            else if (chat.equals("Vitamin E")) {
                vaitro.append(nhuCauVitamin.getVitaminE());
            }
            else if (chat.equals("Vitamin K")) {
                vaitro.append(nhuCauVitamin.getVitaminK());
            }
            else if (chat.equals("Vitamin B1")) {
                vaitro.append(nhuCauVitamin.getVitaminB1());
            }
            else if (chat.equals("Vitamin B2")) {
                vaitro.append(nhuCauVitamin.getVitaminB1());
            }
            else if (chat.equals("Vitamin B3")) {
                vaitro.append(nhuCauVitamin.getVitaminB1());
            }
            else if (chat.equals("Vitamin B6")) {
                vaitro.append(nhuCauVitamin.getVitaminB1());
            }
            else if (chat.equals("Vitamin B9")) {
                vaitro.append(nhuCauVitamin.getVitaminB1());
            }
            else if (chat.equals("Vitamin B12")) {
                vaitro.append(nhuCauVitamin.getVitaminB1());
            }
            else if (chat.equals("Vitamin C")) {
                vaitro.append(nhuCauVitamin.getVitaminB1());
            }
            dinhduong.append(" (mcg/ngày)");
        }
        else if (chat.contains("Sắt") || chat.contains("Maggie") || chat.contains("Canxi")
        || chat.contains("Phospho") || chat.contains("Kẽm") || chat.contains("Đồng") || chat.contains("Seleni")) {
            List<String> vaiTroList = vaiTroRepository.findByVaiTroKhoangChat();
            for(int i=0; i<vaiTroList.size(); i++) {
                if(vaiTroList.get(i).contains(chat)) {
                    vaitro.append(vaiTroList.get(i));
                    vaitro.append("\n");
                }
            }
        }
        else {
            List<String> vaiTroList = vaiTroRepository.findByVaiTro(chat);
            for(int i=0; i<vaiTroList.size(); i++) {
                    vaitro.append(vaiTroList.get(i));
                    vaitro.append("\n");
            }
            if(chat.contains("Protein")) {
                dinhduong.append(nhuCauProteinRepository.findByTuoi(Double.valueOf(tuoi)).getKhoiLuong());
                dinhduong.append(" (g/kg/ngày)");
            }
            else if (chat.contains("Lipid")) {
                dinhduong.append(nhuCauLipidRepository.findByTuoi(Double.valueOf(tuoi)).getKhoiLuong());
                dinhduong.append(" (gam / ngày)");
            }
            else if (chat.contains("Glucid")) {
                dinhduong.append(nhuCauGlucidRepository.findByTuoi(Double.valueOf(tuoi)).getKhoiLuong());
                dinhduong.append("(g/ngày)");
            }
            else if (chat.contains("Nước")) {
                NhuCauNuoc nhuCauNuoc = nhuCauNuocRepository.findByTuoi(Double.valueOf(tuoi)).get(0);
                dinhduong.append("Tối thiểu là: ");
                dinhduong.append(nhuCauNuoc.getKhoiLuongToiThieu());
                dinhduong.append(" Nước/kg/24 giờ (ml) \n");
                dinhduong.append("Tối đa là: ");
                dinhduong.append(nhuCauNuoc.getKhoiLuongToiDa());
                dinhduong.append(" Nước/kg/24 giờ (ml) \n");
            }
        }
        return "Vai trò của chất là: \n" + vaitro +
                "\n" + "Nhu cầu đối với trẻ là: \n" + dinhduong;
    }
}
