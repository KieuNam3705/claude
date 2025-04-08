package com.tourmanagement.service.impl;

import com.tourmanagement.dao.interfaces.ITaiKhoanDAO;
import com.tourmanagement.entity.TaiKhoan;
import com.tourmanagement.service.interfaces.ITaiKhoanService;
import com.tourmanagement.util.PasswordUtils;
import java.util.List;

public class TaiKhoanServiceImpl implements ITaiKhoanService {
    private final ITaiKhoanDAO taiKhoanDAO;

    // Constructor for dependency injection
    public TaiKhoanServiceImpl(ITaiKhoanDAO taiKhoanDAO) {
        this.taiKhoanDAO = taiKhoanDAO;
    }

    @Override
    public TaiKhoan timTheoTenDangNhap(String tenDangNhap) {
        if (tenDangNhap == null || tenDangNhap.trim().isEmpty()) {
            throw new IllegalArgumentException("Tên đăng nhập không được để trống.");
        }
        return taiKhoanDAO.timTheoTenDangNhap(tenDangNhap);
    }

    @Override
    public boolean doiMatKhau(int maTaiKhoan, String matKhauMoi) {
        if (maTaiKhoan <= 0) {
            throw new IllegalArgumentException("Mã tài khoản không hợp lệ.");
        }
        if (matKhauMoi == null || matKhauMoi.length() < 6) {
            throw new IllegalArgumentException("Mật khẩu mới phải có ít nhất 6 ký tự.");
        }
        // Encrypt password before updating
        String encryptedPassword = PasswordUtils.hashPassword(matKhauMoi);
        TaiKhoan result = taiKhoanDAO.capNhatMatKhau(maTaiKhoan, encryptedPassword);
        return result != null;
    }

    @Override
    public boolean capNhatTrangThai(int maTaiKhoan, boolean hoatDong) {
        if (maTaiKhoan <= 0) {
            throw new IllegalArgumentException("Mã tài khoản không hợp lệ.");
        }
        String trangThai = hoatDong ? "Hoạt động" : "Khóa";
        TaiKhoan result = taiKhoanDAO.capNhatTrangThaiTaiKhoan(maTaiKhoan, trangThai);
        return result != null;
    }

    @Override
    public boolean them(TaiKhoan taiKhoan) {
        if (taiKhoan == null || taiKhoan.getTenDangNhap() == null || taiKhoan.getTenDangNhap().trim().isEmpty()) {
            throw new IllegalArgumentException("Tên đăng nhập không được để trống.");
        }
        if (taiKhoan.getMatKhau() == null || taiKhoan.getMatKhau().length() < 6) {
            throw new IllegalArgumentException("Mật khẩu phải có ít nhất 6 ký tự.");
        }
        // Encrypt password before saving
        taiKhoan.setMatKhau(PasswordUtils.hashPassword(taiKhoan.getMatKhau()));
        return taiKhoanDAO.them(taiKhoan);
    }

    @Override
    public boolean sua(TaiKhoan taiKhoan) {
        if (taiKhoan == null || taiKhoan.getMaTaiKhoan() <= 0) {
            throw new IllegalArgumentException("Thông tin tài khoản không hợp lệ.");
        }
        return taiKhoanDAO.sua(taiKhoan);
    }

    @Override
    public boolean xoa(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("Mã tài khoản không hợp lệ.");
        }
        return taiKhoanDAO.xoa(id);
    }

    @Override
    public TaiKhoan timTheoMa(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("Mã tài khoản không hợp lệ.");
        }
        return (TaiKhoan) taiKhoanDAO.timTheoMa(id);
    }

    @Override
    public List<TaiKhoan> layDanhSach() {
        return taiKhoanDAO.layDanhSach();
    }
}