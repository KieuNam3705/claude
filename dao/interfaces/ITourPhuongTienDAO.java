/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tourmanagement.dao.interfaces;

import com.tourmanagement.dao.interfaces.common.ICRUD;
import com.tourmanagement.dao.interfaces.common.ITimKiem;
import com.tourmanagement.entity.TourPhuongTien;
import java.util.List;

/**
 *
 * @author phanh
 */
public interface ITourPhuongTienDAO extends ICRUD<TourPhuongTien>, ITimKiem<TourPhuongTien> {
    TourPhuongTien timTourPhuongTien(int maTour, int maPhuongTien);
    List<TourPhuongTien> layDanhSachPhuongTienTheoTour(int maTour);
    boolean xoaTatCaPhuongTienTheoTour(int maTour);
}
