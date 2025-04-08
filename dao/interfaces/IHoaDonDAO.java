/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tourmanagement.dao.interfaces;

import com.tourmanagement.dao.interfaces.common.ICRUD;
import com.tourmanagement.dao.interfaces.common.ITimKiem;
import com.tourmanagement.entity.HoaDon;
import java.util.List;

/**
 *
 * @author phanh
 */
public interface IHoaDonDAO extends ICRUD<HoaDon>, ITimKiem<HoaDon> {
    HoaDon timHoaDonTheoDatTour(int maDatTour);
    List<HoaDon> layDanhSachHoaDonTheoTrangThai(String trangThai);
    List<HoaDon> layDanhSachHoaDonTheoNhanVien(int maNV);
    boolean capNhatTrangThaiHoaDon(int maHoaDon, String trangThaiMoi);
    boolean capNhatThanhToanHoaDon(int maHoaDon, double soTien);
}