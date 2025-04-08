/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tourmanagement.dao.interfaces;

import com.tourmanagement.dao.interfaces.common.ICRUD;
import com.tourmanagement.dao.interfaces.common.ITimKiem;
import com.tourmanagement.entity.TourDiaDiem;
import java.util.List;

/**
 *
 * @author phanh
 */
public interface ITourDiaDiemDAO extends ICRUD<TourDiaDiem>, ITimKiem<TourDiaDiem> {
    TourDiaDiem timTourDiaDiem(int maTour, int maDiaDiem);
    List<TourDiaDiem> layDanhSachDiaDiemTheoTour(int maTour);
    boolean xoaTatCaDiaDiemTheoTour(int maTour);
}
