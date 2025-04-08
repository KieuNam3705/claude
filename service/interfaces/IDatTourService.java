/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tourmanagement.service.interfaces;

import com.tourmanagement.entity.DatTour;
import com.tourmanagement.service.interfaces.common.ICRUDService;
import com.tourmanagement.service.interfaces.common.ITimKiemService;
import java.util.List;

/**
 *
 * @author phanh
 */
public interface IDatTourService extends ICRUDService<DatTour>, ITimKiemService<DatTour> {
    List<DatTour> layDanhSachTheoKhachHang(int maKH);
    List<DatTour> layDanhSachTheoTour(int maTour);
    List<DatTour> layDanhSachTheoTrangThai(String trangThai);
    List<DatTour> layDanhSachTheoNhanVien(int maNV);
    boolean capNhatTrangThai(int maDatTour, String trangThaiMoi);
}
