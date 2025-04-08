/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tourmanagement.dao.interfaces;

import com.tourmanagement.dao.interfaces.common.ICRUD;
import com.tourmanagement.dao.interfaces.common.ITimKiem;
import com.tourmanagement.entity.PhuongTien;
import java.util.List;
/**
 *
 * @author phanh
 */
public interface IPhuongTienDAO extends ICRUD<PhuongTien>, ITimKiem<PhuongTien> {
    List<PhuongTien> timPhuongTienTheoTen(String tenPhuongTien);
    List<PhuongTien> layDanhSachPhuongTienTheoLoai(String loaiPhuongTien);
    List<PhuongTien> layDanhSachPhuongTienTheoTrangThai(String trangThai);
    List<PhuongTien> layDanhSachPhuongTienTheoTour(int maTour);
    boolean capNhatTrangThaiPhuongTien(int maPhuongTien, String trangThaiMoi);
}