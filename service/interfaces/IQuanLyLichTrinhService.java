package com.tourmanagement.service.interfaces;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface IQuanLyLichTrinhService {
    // Quản lý điểm đến
    boolean capNhatDiemDen(int maTour, int maDiaDiem, int thuTu, int thoiGianLuuTru); // Đã bỏ ghiChu
    boolean xoaDiemDen(int maTour, int maDiaDiem);
    List<Map<String, Object>> layDanhSachDiemDen(int maTour);

    // Quản lý phương tiện
    boolean capNhatPhuongTien(int maTour, int maPhuongTien, Date ngayBatDau, Date ngayKetThuc); // Đã bỏ ghiChu
    boolean xoaPhuongTien(int maTour, int maPhuongTien);
    List<Map<String, Object>> layDanhSachPhuongTien(int maTour);

    // Quản lý chỗ ở
    boolean capNhatChoO(int maTour, int maChoO, Date ngayNhan, Date ngayTra, int soPhong, String loaiPhong, String ghiChu); // Giữ ghiChu
    boolean xoaChoO(int maTour, int maChoO);
    List<Map<String, Object>> layDanhSachChoO(int maTour);

    // Quản lý nhân viên
    boolean capNhatNhanVien(int maTour, int maNV, String vaiTro); // Đã bỏ ghiChu
    boolean xoaNhanVien(int maTour, int maNV);
    List<Map<String, Object>> layDanhSachNhanVien(int maTour);
}