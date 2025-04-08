/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tourmanagement.service.interfaces;

import com.tourmanagement.entity.HoaDon;
import com.tourmanagement.service.interfaces.common.ICRUDService;
import com.tourmanagement.service.interfaces.common.ITimKiemService;
import java.util.List;
/**
 *
 * @author phanh
 */
public interface IHoaDonService extends ICRUDService<HoaDon>, ITimKiemService<HoaDon> {
    HoaDon timTheoDatTour(int maDatTour);
    List<HoaDon> layDanhSachTheoTrangThai(String trangThai);
    List<HoaDon> layDanhSachTheoNhanVien(int maNV);
    boolean capNhatTrangThai(int maHoaDon, String trangThaiMoi);
    boolean capNhatThanhToan(int maHoaDon, double soTien);
}
