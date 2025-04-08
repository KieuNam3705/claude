/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tourmanagement.service.interfaces;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author phanh
 */
public interface IThongKeService {
    Map<String, Double> doanhThuTheoThang(int nam);
    Map<String, Integer> soLuongKhachTheoThang(int nam);
    Map<String, Integer> soLuongTourTheoThang(int nam);
    List<Map<String, Object>> top10TourBanChay(Date tuNgay, Date denNgay);
    List<Map<String, Object>> doanhThuTheoDiaDiem(Date tuNgay, Date denNgay);
    List<Map<String, Object>> top10KhachHangThanThiet(Date tuNgay, Date denNgay);
    Map<String, Double> tyLeHuyTour(Date tuNgay, Date denNgay);
    double tongDoanhThu(Date tuNgay, Date denNgay);
    int tongSoTourDaTo(Date tuNgay, Date denNgay);
    int tongSoKhachHang(Date tuNgay, Date denNgay);
}
