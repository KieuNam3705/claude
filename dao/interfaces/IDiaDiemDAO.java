/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tourmanagement.dao.interfaces;

import com.tourmanagement.dao.interfaces.common.ICRUD;
import com.tourmanagement.dao.interfaces.common.ITimKiem;
import com.tourmanagement.entity.DiaDiem;
import java.util.List;

/**
 *
 * @author phanh
 */
public interface IDiaDiemDAO extends ICRUD<DiaDiem>, ITimKiem<DiaDiem> {
    List<DiaDiem> timDiaDiemTheoTen(String tenDiaDiem);
    List<DiaDiem> layDanhSachDiaDiemTheoThanhPho(String thanhPho);
    List<DiaDiem> layDanhSachDiaDiemTheoQuocGia(String quocGia);
    List<DiaDiem> layDanhSachDiaDiemTheoTour(int maTour);
}

