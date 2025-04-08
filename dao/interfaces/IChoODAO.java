/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tourmanagement.dao.interfaces;

import com.tourmanagement.dao.interfaces.common.ICRUD;
import com.tourmanagement.dao.interfaces.common.ITimKiem;
import com.tourmanagement.entity.ChoO;
import java.util.List;

/**
 *
 * @author phanh
 */
public interface IChoODAO extends ICRUD<ChoO>, ITimKiem<ChoO> {
    List<ChoO> timChoOTheoTen(String tenChoO);
    List<ChoO> layDanhSachChoOTheoLoai(String loaiChoO);
    List<ChoO> layDanhSachChoOTheoThanhPho(String thanhPho);
    List<ChoO> layDanhSachChoOTheoSoSao(int soSao);
    List<ChoO> layDanhSachChoOTheoTour(int maTour);
}