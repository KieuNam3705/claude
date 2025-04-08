/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tourmanagement.service.interfaces;

import com.tourmanagement.entity.PhuongTien;
import com.tourmanagement.service.interfaces.common.ICRUDService;
import com.tourmanagement.service.interfaces.common.ITimKiemService;
import java.util.List;

/**
 *
 * @author phanh
 */
public interface IPhuongTienService extends ICRUDService<PhuongTien>, ITimKiemService<PhuongTien> {
    List<PhuongTien> timTheoTen(String tenPhuongTien);
    List<PhuongTien> layDanhSachTheoLoai(String loaiPhuongTien);
    List<PhuongTien> layDanhSachTheoTrangThai(String trangThai);
    List<PhuongTien> layDanhSachTheoTour(int maTour);
    boolean capNhatTrangThai(int maPhuongTien, String trangThaiMoi);
}
