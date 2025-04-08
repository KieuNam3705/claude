/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tourmanagement.service.interfaces;

import com.tourmanagement.entity.KhachHang;
import com.tourmanagement.service.interfaces.common.ICRUDService;
import com.tourmanagement.service.interfaces.common.ITimKiemService;
import java.util.List;

/**
 *
 * @author phanh
 */
public interface IKhachHangService extends ICRUDService<KhachHang>, ITimKiemService<KhachHang> {
    KhachHang timTheoCMND(String cmnd);
    List<KhachHang> timTheoTen(String hoTen);
    List<KhachHang> timTheoSDT(String soDienThoai);
    List<KhachHang> layDanhSachTheoTour(int maTour);
    boolean kiemTraCMNDTonTai(String cmnd);
}
