/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tourmanagement.dao.interfaces;

import com.tourmanagement.dao.interfaces.common.ICRUD;
import com.tourmanagement.dao.interfaces.common.ITimKiem;
import com.tourmanagement.entity.DatTour;
import java.util.List;
/**
 *
 * @author phanh
 */
public interface IDatTourDAO extends ICRUD<DatTour>, ITimKiem<DatTour> {
    List<DatTour> layDanhSachDatTourTheoKhachHang(int maKH);
    List<DatTour> layDanhSachDatTourTheoTour(int maTour);
    List<DatTour> layDanhSachDatTourTheoTrangThai(String trangThai);
    List<DatTour> layDanhSachDatTourTheoNhanVien(int maNV);
    boolean capNhatTrangThaiDatTour(int maDatTour, String trangThaiMoi);
    int tinhTongSoNguoiDaDatChoTour(int maTour, int maDatTourExclude);
}