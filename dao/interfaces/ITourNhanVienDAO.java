/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tourmanagement.dao.interfaces;

import com.tourmanagement.dao.interfaces.common.ICRUD;
import com.tourmanagement.dao.interfaces.common.ITimKiem;
import com.tourmanagement.entity.TourNhanVien;
import java.util.List;

/**
 *
 * @author phanh
 */
public interface ITourNhanVienDAO extends ICRUD<TourNhanVien>, ITimKiem<TourNhanVien> {
    TourNhanVien timTourNhanVien(int maTour, int maNV);
    List<TourNhanVien> layDanhSachNhanVienTheoTour(int maTour);
    boolean xoaTatCaNhanVienTheoTour(int maTour);
}