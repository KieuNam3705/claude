/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tourmanagement.dao.interfaces;
import com.tourmanagement.dao.interfaces.common.ICRUD;  
import com.tourmanagement.dao.interfaces.common.ITimKiem;
import com.tourmanagement.entity.NhanVien;
import java.util.List;  
/**
 *
 * @author phanh
 */
public interface INhanVienDAO extends ICRUD<NhanVien>, ITimKiem<NhanVien> {
    NhanVien timNhanVienTheoCMND(String cmnd);
    List<NhanVien> timNhanVienTheoTen(String hoTen);
    List<NhanVien> layDanhSachNhanVienTheoChucVu(String chucVu);
    List<NhanVien> layDanhSachHuongDanVien();
    List<NhanVien> layDanhSachNhanVienTheoTour(int maTour);
}


