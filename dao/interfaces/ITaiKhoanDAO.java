/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tourmanagement.dao.interfaces;
import com.tourmanagement.dao.interfaces.common.ICRUD;
import com.tourmanagement.dao.interfaces.common.ITimKiem;
import com.tourmanagement.entity.TaiKhoan;
import java.util.List;
/**
 *
 * @author phanh
 */
public interface ITaiKhoanDAO extends ICRUD,ITimKiem {
    TaiKhoan timTheoTenDangNhap (String tenDangNhap );
    TaiKhoan timTheoMaKH (int maKH );
    TaiKhoan timTheoTenDangNhap (int maNV );
    TaiKhoan capNhatMatKhau (int maTK, String newPassword);
    TaiKhoan capNhatTrangThaiTaiKhoan (int maTK, String trangThai);
    TaiKhoan kiemTraTenDN (String tenDN);
}
