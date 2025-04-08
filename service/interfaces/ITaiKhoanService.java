/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tourmanagement.service.interfaces;

import com.tourmanagement.entity.TaiKhoan;
import com.tourmanagement.service.interfaces.common.ICRUDService;
import com.tourmanagement.service.interfaces.common.ITimKiemService;
/**
 *
 * @author phanh
 */
public interface ITaiKhoanService extends ICRUDService<TaiKhoan>, ITimKiemService<TaiKhoan> {
    TaiKhoan timTheoTenDangNhap(String tenDangNhap);
    boolean doiMatKhau(int maTaiKhoan, String matKhauMoi);
    boolean capNhatTrangThai(int maTaiKhoan, boolean hoatDong);
}