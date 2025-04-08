/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tourmanagement.service.interfaces;

import com.tourmanagement.entity.DiaDiem;
import com.tourmanagement.service.interfaces.common.ICRUDService;
import com.tourmanagement.service.interfaces.common.ITimKiemService;
import java.util.List;

/**
 *
 * @author phanh
 */
public interface IDiaDiemService extends ICRUDService<DiaDiem>, ITimKiemService<DiaDiem> {
    List<DiaDiem> timTheoTen(String tenDiaDiem);
    List<DiaDiem> layDanhSachTheoThanhPho(String thanhPho);
    List<DiaDiem> layDanhSachTheoQuocGia(String quocGia);
    List<DiaDiem> layDanhSachTheoTour(int maTour);
}
