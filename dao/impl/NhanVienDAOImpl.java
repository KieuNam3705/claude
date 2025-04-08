/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tourmanagement.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tourmanagement.dao.interfaces.INhanVienDAO;
import com.tourmanagement.entity.NhanVien;
import com.tourmanagement.util.DBConnection;

/**
 *
 * @author phanh
 */
public class NhanVienDAOImpl implements INhanVienDAO {

    /**
     * Tìm nhân viên theo số CMND/CCCD
     * @param cmnd số CMND/CCCD cần tìm
     * @return đối tượng NhanVien nếu tìm thấy, null nếu không tìm thấy
     */
    @Override
    public NhanVien timNhanVienTheoCMND(String cmnd) {
        String sql = "SELECT * FROM NhanVien WHERE CMND = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cmnd);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToNhanVien(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Tìm danh sách nhân viên theo tên (tìm kiếm gần đúng)
     * @param hoTen tên nhân viên cần tìm
     * @return danh sách nhân viên tìm thấy
     */
    @Override
    public List<NhanVien> timNhanVienTheoTen(String hoTen) {
        List<NhanVien> danhSach = new ArrayList<>();
        String sql = "SELECT * FROM NhanVien WHERE HoTen LIKE ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, "%" + hoTen + "%");
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    danhSach.add(mapResultSetToNhanVien(rs));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSach;
    }

    /**
     * Lấy danh sách nhân viên theo chức vụ
     * @param chucVu chức vụ cần tìm
     * @return danh sách nhân viên có chức vụ tương ứng
     */
    @Override
    public List<NhanVien> layDanhSachNhanVienTheoChucVu(String chucVu) {
        List<NhanVien> danhSach = new ArrayList<>();
        String sql = "SELECT * FROM NhanVien WHERE ChucVu = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, chucVu);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    danhSach.add(mapResultSetToNhanVien(rs));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSach;
    }

    /**
     * Lấy danh sách tất cả hướng dẫn viên từ cơ sở dữ liệu.     
     * @return danh sách nhân viên có chức vụ "Hướng dẫn viên"
     */
    @Override
    public List<NhanVien> layDanhSachHuongDanVien() {
        List<NhanVien> danhSach = new ArrayList<>();
        String sql = "SELECT * FROM NhanVien WHERE ChucVu = 'Hướng dẫn viên'";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                danhSach.add(mapResultSetToNhanVien(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSach;
    }

    /**
     * Lấy danh sách nhân viên theo tour
     * @param maTour mã tour cần lấy danh sách nhân viên
     * @return danh sách nhân viên tham gia tour
     */
    @Override
    public List<NhanVien> layDanhSachNhanVienTheoTour(int maTour) {
        List<NhanVien> danhSach = new ArrayList<>();
        String sql = "SELECT n.* FROM NhanVien n "
                   + "JOIN PhanCong pc ON n.MaNV = pc.MaNV "
                   + "WHERE pc.MaTour = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, maTour);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    danhSach.add(mapResultSetToNhanVien(rs));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSach;
    }

    /**
     * Thêm một nhân viên mới vào database
     */
    @Override
    public boolean them(NhanVien nv) {
        String sql = "INSERT INTO NhanVien (HoTen, CMND, SoDienThoai, Email, DiaChi, NgaySinh, GioiTinh, ChucVu, NgayVaoLam, Luong) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nv.getHoTen());
            stmt.setString(2, nv.getCmnd());
            stmt.setString(3, nv.getSoDienThoai());
            stmt.setString(4, nv.getEmail());
            stmt.setString(5, nv.getDiaChi());
            stmt.setDate(6, nv.getNgaySinh() != null ? new java.sql.Date(nv.getNgaySinh().getTime()) : null);
            stmt.setString(7, nv.getGioiTinh());
            stmt.setString(8, nv.getChucVu());
            stmt.setDate(9, nv.getNgayVaoLam() != null ? new java.sql.Date(nv.getNgayVaoLam().getTime()) : null);
            stmt.setBigDecimal(10, nv.getLuong());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

     /**
     * Sửa thông tin nhân viên
     */
    @Override
    public boolean sua(NhanVien nv) {
        String sql = "UPDATE NhanVien SET HoTen = ?, CMND = ?, SoDienThoai = ?, Email = ?, DiaChi = ?, NgaySinh = ?, GioiTinh = ?, ChucVu = ?, NgayVaoLam = ?, Luong = ? WHERE MaNV = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nv.getHoTen());
            stmt.setString(2, nv.getCmnd());
            stmt.setString(3, nv.getSoDienThoai());
            stmt.setString(4, nv.getEmail());
            stmt.setString(5, nv.getDiaChi());
            stmt.setDate(6, nv.getNgaySinh() != null ? new java.sql.Date(nv.getNgaySinh().getTime()) : null);
            stmt.setString(7, nv.getGioiTinh());
            stmt.setString(8, nv.getChucVu());
            stmt.setDate(9, nv.getNgayVaoLam() != null ? new java.sql.Date(nv.getNgayVaoLam().getTime()) : null);
            stmt.setBigDecimal(10, nv.getLuong());
            stmt.setInt(11, nv.getMaNV());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Xóa nhân viên theo mã
     */
    @Override
    public boolean xoa(int id) {
        String sql = "DELETE FROM NhanVien WHERE MaNV = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Tìm nhân viên theo mã
     */
    @Override
    public NhanVien timTheoMa(int id) {
        String sql = "SELECT * FROM NhanVien WHERE MaNV = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToNhanVien(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Lấy danh sách tất cả nhân viên
     */
    @Override
    public List<NhanVien> layDanhSach() {
        List<NhanVien> danhSach = new ArrayList<>();
        String sql = "SELECT * FROM NhanVien";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                danhSach.add(mapResultSetToNhanVien(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSach;
    }
    
    /**
     * Chuyển đổi từ ResultSet sang đối tượng NhanVien
     * @param rs ResultSet chứa dữ liệu từ database
     * @return đối tượng NhanVien
     * @throws SQLException nếu có lỗi khi đọc dữ liệu
     */
    private NhanVien mapResultSetToNhanVien(ResultSet rs) throws SQLException {
        NhanVien nv = new NhanVien();
        nv.setMaNV(rs.getInt("MaNV"));
        nv.setHoTen(rs.getString("HoTen"));
        nv.setCmnd(rs.getString("CMND"));
        nv.setSoDienThoai(rs.getString("SoDienThoai"));
        nv.setEmail(rs.getString("Email"));
        nv.setDiaChi(rs.getString("DiaChi"));
        nv.setNgaySinh(rs.getDate("NgaySinh"));
        nv.setGioiTinh(rs.getString("GioiTinh"));
        nv.setChucVu(rs.getString("ChucVu"));
        nv.setNgayVaoLam(rs.getDate("NgayVaoLam"));
        nv.setLuong(rs.getBigDecimal("Luong"));
        return nv;
    }
}