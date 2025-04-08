/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tourmanagement.service.interfaces;

import com.tourmanagement.entity.NhanVien;
import com.tourmanagement.service.interfaces.common.ICRUDService;
import com.tourmanagement.service.interfaces.common.ITimKiemService;
import java.util.List;

/**
 *
 * @author phanh
 */
public interface INhanVienService extends ICRUDService<NhanVien>, ITimKiemService<NhanVien> {
    NhanVien timTheoCMND(String cmnd);
    List<NhanVien> timTheoTen(String hoTen);
    List<NhanVien> layDanhSachTheoChucVu(String chucVu);
    List<NhanVien> layDanhSachHuongDanVien();
    List<NhanVien> layDanhSachTheoTour(int maTour);
}
