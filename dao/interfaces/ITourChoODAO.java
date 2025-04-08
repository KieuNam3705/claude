/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tourmanagement.dao.interfaces;

import com.tourmanagement.dao.interfaces.common.ICRUD;
import com.tourmanagement.dao.interfaces.common.ITimKiem;
import com.tourmanagement.entity.TourChoO;
import java.util.List;

/**
 *
 * @author phanh
 */
public interface ITourChoODAO extends ICRUD<TourChoO>, ITimKiem<TourChoO> {
    TourChoO timTourChoO(int maTour, int maChoO);
    List<TourChoO> layDanhSachChoOTheoTour(int maTour);
    boolean xoaTatCaChoOTheoTour(int maTour);
}
