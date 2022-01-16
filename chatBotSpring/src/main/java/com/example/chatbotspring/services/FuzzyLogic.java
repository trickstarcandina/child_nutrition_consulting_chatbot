package com.example.chatbotspring.services;

import com.example.chatbotspring.data.entities.ChieuCaoCanNang;
import com.example.chatbotspring.data.dto.TinhTrangSucKhoe;
import com.example.chatbotspring.data.dto.XacSuat;
import com.example.chatbotspring.data.repository.ChieuCaoCanNangRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FuzzyLogic {

    private final ChieuCaoCanNangRepository chieuCaoCanNangRepository;

    public ChieuCaoCanNang find(String gioiTinh, double thang) {
        List<ChieuCaoCanNang> datas = chieuCaoCanNangRepository.findAll();
        for (int i = 0; i < datas.size(); i++) {
            ChieuCaoCanNang chieuCaoCanNang = datas.get(i);
            if (gioiTinh.equals(chieuCaoCanNang.getGioiTinh()) && thang == chieuCaoCanNang.getTuoi()) {
                return chieuCaoCanNang;
            }
        }
        return findFuzzy(gioiTinh, thang);
    }

    public ChieuCaoCanNang findFuzzy(String gioiTinh, double thang) {
        List<ChieuCaoCanNang> datas = chieuCaoCanNangRepository.findAll();
        System.out.println(thang);
        ChieuCaoCanNang smin = null, smax = null;
        for (int i = 0; i < datas.size() - 2; i++) {
            ChieuCaoCanNang chieuCaoCanNang = datas.get(i);
            ChieuCaoCanNang chieuCaoCanNang1 = datas.get(i + 2);
            if (gioiTinh.equals(chieuCaoCanNang.getGioiTinh()) && thang > chieuCaoCanNang.getTuoi() && thang <= chieuCaoCanNang1.getTuoi()) {
                smin = chieuCaoCanNang;
                smax = chieuCaoCanNang1;
                break;
            }
        }
        double chieuCaoToiThieu = smin.getChieuCaoToiThieu() + (smax.getChieuCaoToiThieu() - smin.getChieuCaoToiThieu()) * (thang - smin.getTuoi()) / (smax.getTuoi() - smin.getTuoi());
        double chieuCaoToiDa = smin.getChieuCaoToiDa() + (smax.getChieuCaoToiDa() - smin.getChieuCaoToiDa()) * (thang - smin.getTuoi()) / (smax.getTuoi() - smin.getTuoi());
        double canNangToiThieu = smin.getCanNangToiThieu() + (smax.getCanNangToiThieu() - smin.getCanNangToiThieu()) * (thang - smin.getTuoi()) / (smax.getTuoi() - smin.getTuoi());
        double canNangToiDa = smin.getChieuCaoToiDa() + (smax.getChieuCaoToiDa() - smin.getChieuCaoToiDa()) * (thang - smin.getTuoi()) / (smax.getTuoi() - smin.getTuoi());
        ChieuCaoCanNang chieuCaoCanNang = new ChieuCaoCanNang();
        chieuCaoCanNang.setGioiTinh(gioiTinh);
        chieuCaoCanNang.setTuoi(thang);
        chieuCaoCanNang.setChieuCaoToiThieu(chieuCaoToiThieu);
        chieuCaoCanNang.setChieuCaoToiDa(chieuCaoToiDa);
        chieuCaoCanNang.setCanNangToiThieu(canNangToiThieu);
        chieuCaoCanNang.setCanNangToiDa(canNangToiDa);
        return chieuCaoCanNang;
    }

    public void tinhXacSuat(XacSuat cHeight, XacSuat cWeight, String sex, double month, double weight, double height) {
        ChieuCaoCanNang chieuCaoCanNang = find(sex, month);
        double heightMin = chieuCaoCanNang.getChieuCaoToiThieu();
        double heightMax = chieuCaoCanNang.getChieuCaoToiDa();
        double heightTb = (heightMax + heightMin) / 2;

        if (height < heightMin)
            cHeight.setThap(1);
        else if (height >= heightMin
                && height < heightTb) {
            cHeight.setBinhThuong(2 * (height - heightMin) / (heightMax - heightMin));
            cHeight.setThap(1 - cHeight.getBinhThuong());
        } else if (height >= heightTb
                && height <= heightMax) {
            cHeight.setCao(2 * (heightMax - height) / (heightMax - heightMin));
            cHeight.setBinhThuong(1 - cHeight.getCao());
        } else if (height >= heightMax) {
            cHeight.setCao(1);
        }

        double weightMin = chieuCaoCanNang.getCanNangToiThieu();
        double weightMax = chieuCaoCanNang.getChieuCaoToiDa();
        double weightTb = (weightMax + weightMin) / 2;
        if (weight < weightMin) {
            cWeight.setThap(1);
        } else if (weight >= weightMin && weight < weightTb) {
            cWeight.setBinhThuong(2 * (double) (weight - weightMin) / (weightMax - weightMin));
            cWeight.setThap(1 - cWeight.getBinhThuong());
        } else if (weight >= weightTb && weight <= weightMax) {
            cWeight.setCao(2 * (weightMax - weight) / (weightMax - weightMin));
            cWeight.setBinhThuong(1 - cWeight.getCao());
        } else if (weight >= weightMax) {
            cWeight.setCao(1);
        }
    }

    public String result(String sex, double month, double weight, double height) {
        XacSuat cHeight = new XacSuat();
        XacSuat cWeight = new XacSuat();
        tinhXacSuat(cHeight, cWeight, sex, month, weight, height);
        TinhTrangSucKhoe tinhTrangSucKhoe = new TinhTrangSucKhoe();
        tinhTrangSucKhoe.setGayCap1(Double.max(Double.min(cHeight.getCao(), cWeight.getThap()), Double.max(Double.min(cHeight.getBinhThuong(), cWeight.getThap()), Double.min(cHeight.getThap(), cWeight.getBinhThuong()))));
        tinhTrangSucKhoe.setGayCap2(Double.min(cHeight.getThap(), cWeight.getThap()));
        tinhTrangSucKhoe.setBeoCap1(Double.max(Double.min(cHeight.getBinhThuong(), cWeight.getCao()), Double.min(cHeight.getCao(), cWeight.getCao())));
        tinhTrangSucKhoe.setBeoCap2(Double.min(cHeight.getThap(), cWeight.getCao()));
        tinhTrangSucKhoe.setBinhThuong(Double.max(Double.min(cHeight.getBinhThuong(), cWeight.getBinhThuong()), Double.min(cHeight.getCao(), cWeight.getBinhThuong())));
        double probabilityMax = 0;
        probabilityMax = Double.max(tinhTrangSucKhoe.getGayCap1(), Double.max(tinhTrangSucKhoe.getGayCap2(),
                Double.max(tinhTrangSucKhoe.getBinhThuong(), Double.max(tinhTrangSucKhoe.getBeoCap1(), tinhTrangSucKhoe.getBeoCap2()))));
        if (probabilityMax == tinhTrangSucKhoe.getGayCap1()) return "Suy dinh dưỡng cấp 1";
        else if (probabilityMax == tinhTrangSucKhoe.getGayCap2()) return "Suy dinh dưỡng cấp 2";
        else if (probabilityMax == tinhTrangSucKhoe.getBinhThuong()) return "Bình thường";
        else if (probabilityMax == tinhTrangSucKhoe.getBeoCap1()) return "Thừa cân";
        else
            return "Béo phì";

    }
}
