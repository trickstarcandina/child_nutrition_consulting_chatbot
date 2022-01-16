package com.example.chatbotspring.services;

import com.example.chatbotspring.data.entities.ThucPhamChuyenDoi;
import com.example.chatbotspring.data.entities.TileDinhDuong;
import com.example.chatbotspring.data.repository.NhuCauNangLuongRepository;
import com.example.chatbotspring.data.repository.ThucPhamChuyenDoiRepository;
import com.example.chatbotspring.data.repository.TiLeDinhDuongRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@AllArgsConstructor
public class ThucDonService {

    private final FuzzyLogic fuzzyLogic;
    private final ThucPhamChuyenDoiRepository thucPhamChuyenDoiRepository;
    private final NhuCauNangLuongRepository nhuCauNangLuongRepository;
    private final TiLeDinhDuongRepository tiLeDinhDuongRepository;

    public String suaMe(double month) {
        if (month <= 2)
            return "Lượng sữa mỗi lần cho bé bú là 60-120ml, cho trẻ bú bất cứ khi nào trẻ muốn, cả ngày lẫn đêm ít nhất 8 lần/ngày\n";
        else if (month <= 4)
            return "Lượng sữa mỗi lần cho bé bú là 120-180ml, cho trẻ bú bất cứ khi nào trẻ muốn, cả ngày lẫn đêm ít nhất 8 lần/ngày\n";
        else if (month <= 6)
            return "Lượng sữa mỗi lần cho bé bú là 120-240ml, cho trẻ bú bất cứ khi nào trẻ muốn, cả ngày lẫn đêm ít nhất 8 lần/ngày"
                    + "\nCó thể cho bé tập ăn dặm nếu bé đã ngồi vững, nhưng không nhất thiết cho trẻ ăn dặm vào lúc này\n";
        else if (month <= 12) return "Lượng sữa mỗi lần cho bé bú là 240ml, ít nhất 8 lần/ngày"
                + "\nBắt đầu cho bé làm quan với các thực phẩm mềm như: ngũ cốc, thịt và trái cây xay nhuyễn. Sau đó, dần dấn đến các món được nghiền và xắt nhỏ";

        return "";
    }

    public String result(String sex, double month, double weight, double height) {
        if (month <= 12)
            return suaMe(month);
        return thucDonDinhDuong(sex, month, weight, height);
    }

    public String thucDonDinhDuong(String sex, double month, double weight, double height) {
        String tinhTrang = fuzzyLogic.result(sex, month, weight, height);
        double kcal = nhuCauNangLuongRepository.findByThang(month).getNangLuong();
        if (tinhTrang.equals("Suy dinh dưỡng cấp 1"))
            kcal = kcal * 1.1;
        else if (tinhTrang.equals("Suy dinh dưỡng cấp 2"))
            kcal = kcal * 1.2;
        else if (tinhTrang.equals("Thừa cân"))
            kcal = kcal * 0.9;
        else if (tinhTrang.equals("Béo phì"))
            kcal = kcal * 0.8;

        TileDinhDuong tileDinhDuong = tiLeDinhDuongRepository.findByTuoi(month);
        double tinhBot = kcal * (tileDinhDuong.getTinhBot() / 100);
        double chatBeo = kcal * (tileDinhDuong.getChatBeo() / 100);
        double protein = kcal * (tileDinhDuong.getProtein() / 100);

        Random Rand = new Random(); // random thuc pham
        StringBuilder tb = new StringBuilder(); // random tinh bot
        List<ThucPhamChuyenDoi> listTb = thucPhamChuyenDoiRepository.findByNhom("Nhiều tinh bột");

        for (int i = 1; i <= 3; i++) {
            int index = Rand.nextInt(listTb.size());
            ThucPhamChuyenDoi thucPhamChuyenDoi = listTb.remove(index);
            tb.append(thucPhamChuyenDoi.getThucPham());
            tb.append(',');
        }

        StringBuilder cb = new StringBuilder(); // random chat beo
        List<ThucPhamChuyenDoi> listCb = thucPhamChuyenDoiRepository.findByNhom("Nhiều chất béo");

        for (int i = 1; i <= 3; i++) {
            int index = Rand.nextInt(listCb.size());
            ThucPhamChuyenDoi thucPhamChuyenDoi = listCb.remove(index);
            cb.append(thucPhamChuyenDoi.getThucPham());
            cb.append(',');
        }

        StringBuilder pr = new StringBuilder(); // random protein
        List<ThucPhamChuyenDoi> listPr = thucPhamChuyenDoiRepository.findByNhom("Nhiều protein");
        for (int i = 1; i <= 3; i++) {
            int index = Rand.nextInt(listPr.size());
            ThucPhamChuyenDoi thucPhamChuyenDoi = listPr.remove(index);
            pr.append(thucPhamChuyenDoi.getThucPham());
            pr.append(',');
        }

        return "Thể trạng hiện tại của cháu là: " + tinhTrang + "\n" +
                "Khẩu phần ăn phù hợp cho cháu là khoảng: " + kcal + " kcal\n" +
                "Thực đơn ví dụ như:\n" +
                "- " + tinhBot + " kcal từ " + tb + "\n" +
                "- " + chatBeo + " kcal từ " + cb + "\n" +
                "- " + protein + " kcal từ " + pr + "\n";
    }

}
