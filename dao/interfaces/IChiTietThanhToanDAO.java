/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tourmanagement.dao.interfaces;

import com.tourmanagement.dao.interfaces.common.ICRUD;
import com.tourmanagement.dao.interfaces.common.ITimKiem;
import com.tourmanagement.entity.ChiTietThanhToan;
import java.util.List;

/**
 *
 * @author phanh
 */
public interface IChiTietThanhToanDAO extends ICRUD<ChiTietThanhToan>, ITimKiem<ChiTietThanhToan> {
    List<ChiTietThanhToan> layDanhSachThanhToanTheoHoaDon(int maHoaDon);
    double tinhTongTienDaThanhToan(int maHoaDon);
}