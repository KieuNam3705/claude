/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tourmanagement.service.interfaces;

import com.tourmanagement.entity.ChoO;
import com.tourmanagement.service.interfaces.common.ICRUDService;
import com.tourmanagement.service.interfaces.common.ITimKiemService;
import java.util.List;

/**
 *
 * @author phanh
 */
public interface IChoOService extends ICRUDService<ChoO>, ITimKiemService<ChoO> {
    List<ChoO> timTheoTen(String tenChoO);
    List<ChoO> layDanhSachTheoLoai(String loaiChoO);
    List<ChoO> layDanhSachTheoThanhPho(String thanhPho);
    List<ChoO> layDanhSachTheoSoSao(int soSao);
    List<ChoO> layDanhSachTheoTour(int maTour);
}
