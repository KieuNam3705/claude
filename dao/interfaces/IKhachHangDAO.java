/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tourmanagement.dao.interfaces;
import com.tourmanagement.dao.interfaces.common.ICRUD;  
import com.tourmanagement.dao.interfaces.common.ITimKiem;
import com.tourmanagement.entity.KhachHang;
import java.util.List;  
/**
 *
 * @author phanh
 */
public interface IKhachHangDAO extends ICRUD<KhachHang>, ITimKiem<KhachHang> {
    KhachHang timKhachHangTheoCMND(String cmnd);
    List<KhachHang> timKhachHangTheoTen(String hoTen);
    List<KhachHang> timKhachHangTheoSDT(String soDienThoai);
    List<KhachHang> layDanhSachKhachHangTheoTour(int maTour);
    
}
