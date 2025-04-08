/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tourmanagement.service.interfaces;

import com.tourmanagement.entity.Tour;
import com.tourmanagement.service.interfaces.common.ICRUDService;
import com.tourmanagement.service.interfaces.common.ITimKiemService;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author phanh
 */
public interface ITourService extends ICRUDService<Tour>, ITimKiemService<Tour> {
    List<Tour> timTheoTen(String tenTour);
    List<Tour> layDanhSachTheoTrangThai(String trangThai);
    List<Tour> layDanhSachTheoNgay(Date ngayBatDau, Date ngayKetThuc);
    List<Tour> layDanhSachTheoLoai(String loaiTour);
    boolean capNhatTrangThai(int maTour, String trangThaiMoi);
    Map<String, Object> layChiTiet(int maTour);
}
