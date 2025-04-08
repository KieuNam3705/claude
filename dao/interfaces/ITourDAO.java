/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tourmanagement.dao.interfaces;

import com.tourmanagement.dao.interfaces.common.ICRUD;
import com.tourmanagement.dao.interfaces.common.ITimKiem;
import com.tourmanagement.entity.Tour;
import java.util.Date;
import java.util.List;
/**
 *
 * @author phanh
 */
public interface ITourDAO extends ICRUD<Tour>, ITimKiem<Tour> {
    List<Tour> timTourTheoTen(String tenTour);
    List<Tour> layDanhSachTourTheoTrangThai(String trangThai);
    List<Tour> layDanhSachTourTheoNgay(Date ngayBatDau, Date ngayKetThuc);
    List<Tour> layDanhSachTourTheoLoai(String loaiTour);
    boolean capNhatTrangThaiTour(int maTour, String trangThaiMoi);
}