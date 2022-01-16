package com.example.chatbotspring.services;

import com.example.chatbotspring.data.entities.*;
import com.example.chatbotspring.data.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class MessageService {

    private final HienTuongRepository hienTuongRepository;
    private final GiaiPhapRepository giaiPhapRepository;
    private final ThucDonService thucDonService;
    private final VaiTroRepository vaiTroRepository;
    private final NhuCauVitaminRepository nhuCauVitaminRepository;
    private final NhuCauProteinRepository nhuCauProteinRepository;
    private final NhuCauLipidRepository nhuCauLipidRepository;
    private final NhuCauGlucidRepository nhuCauGlucidRepository;
    private final NhuCauNuocRepository nhuCauNuocRepository;
    private final NhuCauKhoangChatRepository nhuCauKhoangChatRepository;

    public String solveMessage(String message) {
        if (message.startsWith("Chào bác sĩ, tôi muốn hỏi chế độ ăn cho cháu có")
                && message.contains("chiều cao") && message.contains("cân nặng")
                && message.contains("giới tính") && message.contains("tuổi"))
            return tuVanKhauPhanAn(message);
        if (message.startsWith("Chào bác sĩ, cháu nhà tôi có hiện tượng") && message.contains("thì chế độ dinh dưỡng như thế nào để khắc phục ạ"))
            return tuVanVanDeDinhDuong(message);
        if (message.startsWith("Chào bác sĩ, tôi cần biết thông tin về chất") && message.contains("tháng tuổi"))
            return tuVanVaiTroDinhDuong(message);
        return "Không thể nhận dạng thông tin cần tư vấn";
    }

    // kịch bản 1
    private String tuVanKhauPhanAn(String message) {
        double height = 0, weight = 0;
        double month = 0;
        String sex= "";
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
                month = Double.parseDouble(thongTin.trim());
            }
        }
        if (month < 0 || month > 72
            || height <= 0 || weight <= 0
            || (!sex.equalsIgnoreCase("nam") && !sex.equalsIgnoreCase("nu")))
            return "Không thể nhận dạng thông tin cần tư vấn";

        return thucDonService.result(sex, month, weight, height);
    }

    // kịch bản 2
    private String tuVanVanDeDinhDuong(String message) {
        String prefix = "Chào bác sĩ, cháu nhà tôi có hiện tượng";
        String suffix = "thì chế độ dinh dưỡng như thế nào để khắc phục ạ";
        message = message.substring(prefix.length(), message.indexOf(suffix)).trim();
        String[] cacHienTuong = message.split(";");
        List<HienTuong> hienTuongList = new ArrayList<>();
        for (String hienTuong : cacHienTuong) {
            hienTuongList.addAll(hienTuongRepository.findByHienTuong(hienTuong.trim()));
        }
        Map<String, Integer> map = new HashMap<>();
        int doPhuHopMax = 0;
        String vanDe = "";
        for (HienTuong hienTuong : hienTuongList) {
            if (map.get(hienTuong.getVanDe()) == null) {
                map.put(hienTuong.getVanDe(), 0);
            }
            Integer mucDoPhuHop = map.get(hienTuong.getVanDe());
            map.put(hienTuong.getVanDe(), mucDoPhuHop + hienTuong.getMucDoPhuHop());
            if (map.get(hienTuong.getVanDe()) > doPhuHopMax) {
                doPhuHopMax = map.get(hienTuong.getVanDe());
                vanDe = hienTuong.getVanDe();
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
        String chat = message.substring(44,message.indexOf(" cho trẻ")).trim().toLowerCase();
        String tuoi = message.substring(message.indexOf("cho trẻ ") + 8,message.indexOf(" tháng tuổi")).trim();
        //check query return null => ko có csdl
        StringBuffer vaitro = new StringBuffer();
        StringBuffer dinhduong = new StringBuffer();
        if(chat.contains("vitamin")) {
            List<String> vaiTroList = vaiTroRepository.findByVaiTroVitamin();
            for(int i=0; i<vaiTroList.size(); i++) {
                if(vaiTroList.get(i).contains(chat)) {
                    vaitro.append(vaiTroList.get(i));
                    vaitro.append("\n");
                }
            }
            NhuCauVitamin nhuCauVitamin = nhuCauVitaminRepository.findByTuoi(Double.valueOf(tuoi));
            if(chat.equals("vitamin")) {
                dinhduong.append(nhuCauVitamin.toString());
            }
            else if (chat.equals("vitamin a")) {
                dinhduong.append(nhuCauVitamin.getVitaminA());
            }
            else if (chat.equals("vitamin d")) {
                dinhduong.append(nhuCauVitamin.getVitaminD());
            }
            else if (chat.equals("vitamin e")) {
                dinhduong.append(nhuCauVitamin.getVitaminE());
            }
            else if (chat.equals("vitamin k")) {
                dinhduong.append(nhuCauVitamin.getVitaminK());
            }
            else if (chat.equals("vitamin b1")) {
                dinhduong.append(nhuCauVitamin.getVitaminB1());
            }
            else if (chat.equals("vitamin b2")) {
                dinhduong.append(nhuCauVitamin.getVitaminB2());
            }
            else if (chat.equals("vitamin b3")) {
                dinhduong.append(nhuCauVitamin.getVitaminB3());
            }
            else if (chat.equals("vitamin b6")) {
                dinhduong.append(nhuCauVitamin.getVitaminB6());
            }
            else if (chat.equals("vitamin b9")) {
                dinhduong.append(nhuCauVitamin.getVitaminB9());
            }
            else if (chat.equals("vitamin b12")) {
                dinhduong.append(nhuCauVitamin.getVitaminB12());
            }
            else if (chat.equals("vitamin c")) {
                dinhduong.append(nhuCauVitamin.getVitaminC());
            }
            if(!chat.equals("vitamin")) {
                dinhduong.append(" (mcg/ngày)");
            }
        }
        else if (chat.contains("iot") || chat.contains("sắt") || chat.contains("maggie") || chat.contains("canxi") || chat.contains("phospho")
                || chat.contains("kẽm") || chat.contains("đồng") || chat.contains("seleni") || chat.contains("khoáng chất")) {
            List<String> vaiTroList = vaiTroRepository.findByVaiTroKhoangChat();
            for (int i = 0; i < vaiTroList.size(); i++) {
                if (chat.equals("khoáng chất") || vaiTroList.get(i).contains(chat)) {
                    vaitro.append(vaiTroList.get(i));
                    vaitro.append("\n");
                }
            }
            NhuCauChatKhoang nhuCauChatKhoang = nhuCauKhoangChatRepository.findByTuoi(Double.valueOf(tuoi));
            if(chat.equals("khoáng chất")) {
                dinhduong.append(nhuCauChatKhoang.toString());
            }
            else if (chat.equals("iot")) {
                dinhduong.append(nhuCauChatKhoang.getIot());
                dinhduong.append(" 10^-6g/ngày");
            }
            else if(chat.equals("sắt")) {
                dinhduong.append(nhuCauChatKhoang.getSat());
                dinhduong.append(" 10^-3g/ngày");
            }
            else if(chat.equals("maggie")) {
                dinhduong.append(nhuCauChatKhoang.getMaggie());
                dinhduong.append(" 10^-3g/ngày");
            }
            else if(chat.equals("canxi")) {
                dinhduong.append(nhuCauChatKhoang.getCanxi());
                dinhduong.append(" 10^-3g/ngày");
            }
            else if(chat.equals("phospho")) {
                dinhduong.append(nhuCauChatKhoang.getPhospho());
                dinhduong.append(" 10^-3g/ngày");
            }
            else if(chat.equals("kẽm")) {
                dinhduong.append(nhuCauChatKhoang.getKem());
                dinhduong.append(" 10^-3g/ngày");
            }
            else if(chat.equals("đồng")) {
                dinhduong.append(nhuCauChatKhoang.getDong());
                dinhduong.append(" 10^-6g/ngày");
            }
            else if(chat.equals("seleni")) {
                dinhduong.append(nhuCauChatKhoang.getSeleni());
                dinhduong.append(" 10^-6g/ngày");
            }
        }
        else {
            List<String> vaiTroList = vaiTroRepository.findByVaiTro(chat.substring(0,1).toUpperCase() + chat.substring(1));
            for(int i=0; i<vaiTroList.size(); i++) {
                    vaitro.append(vaiTroList.get(i));
                    vaitro.append("\n");
            }
            if(chat.contains("protein")) {
                dinhduong.append(nhuCauProteinRepository.findByTuoi(Double.valueOf(tuoi)).getKhoiLuong());
                dinhduong.append(" (g/kg/ngày)");
            }
            else if (chat.contains("lipit")) {
                dinhduong.append(nhuCauLipidRepository.findByTuoi(Double.valueOf(tuoi)).getKhoiLuong());
                dinhduong.append(" (gam / ngày)");
            }
            else if (chat.contains("glucid")) {
                dinhduong.append(nhuCauGlucidRepository.findByTuoi(Double.valueOf(tuoi)).getKhoiLuong());
                dinhduong.append(" (g/ngày)");
            }
            else if (chat.contains("nước")) {
                NhuCauNuoc nhuCauNuoc = nhuCauNuocRepository.findByTuoi(Double.valueOf(tuoi)).get(0);
                dinhduong.append("Tối thiểu là: ");
                dinhduong.append(nhuCauNuoc.getDungLuongToiThieu());
                dinhduong.append(" Nước/kg/24 giờ (ml) \n");
                dinhduong.append("Tối đa là: ");
                dinhduong.append(nhuCauNuoc.getDungLuongToiDa());
                dinhduong.append(" Nước/kg/24 giờ (ml) \n");
            }
        }
        if(vaitro.length() == 0) {
            vaitro.append("Vai trò của chất chưa tồn tại trong hệ thống");
        }
        else if(dinhduong.length() == 0) {
            dinhduong.append("Nhu cầu của chất chưa tồn tại trong hệ thống");
        }
        return "Vai trò của chất là: \n" + vaitro +
                "\n" + "Nhu cầu đối với trẻ là: \n" + dinhduong;
    }
}
