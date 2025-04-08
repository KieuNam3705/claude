/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tourmanagement.dao.impl;

import com.tourmanagement.dao.interfaces.IPhuongTienDAO;
import com.tourmanagement.entity.PhuongTien;
import com.tourmanagement.util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author phanh
 */
public class PhuongTienDAOImpl implements IPhuongTienDAO {

    /**
     * Phương thức chuyển từ ResultSet sang đối tượng PhuongTien
     */
    private PhuongTien mapResultSetToPhuongTien(ResultSet rs) throws SQLException {
        PhuongTien phuongTien = new PhuongTien();
        phuongTien.setMaPhuongTien(rs.getInt("MaPhuongTien"));
        phuongTien.setTenPhuongTien(rs.getString("TenPhuongTien"));
        phuongTien.setLoaiPhuongTien(rs.getString("LoaiPhuongTien"));
        phuongTien.setBienSo(rs.getString("BienSo"));
        phuongTien.setSoChoNgoi(rs.getInt("SoChoNgoi"));
        phuongTien.setCongTy(rs.getString("CongTy"));
        phuongTien.setGiaThue(rs.getDouble("GiaThue"));
        phuongTien.setTrangThai(rs.getString("TrangThai"));
        return phuongTien;
    }

    /**
     * Tìm phương tiện theo tên
     */
    @Override
    public List<PhuongTien> timPhuongTienTheoTen(String tenPhuongTien) {
        List<PhuongTien> danhSach = new ArrayList<>();
        String sql = "SELECT * FROM PhuongTien WHERE TenPhuongTien LIKE ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, "%" + tenPhuongTien + "%");
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    danhSach.add(mapResultSetToPhuongTien(rs));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSach;
    }

    /**
     * Lấy danh sách phương tiện theo loại
     */
    @Override
    public List<PhuongTien> layDanhSachPhuongTienTheoLoai(String loaiPhuongTien) {
        List<PhuongTien> danhSach = new ArrayList<>();
        String sql = "SELECT * FROM PhuongTien WHERE LoaiPhuongTien = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, loaiPhuongTien);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    danhSach.add(mapResultSetToPhuongTien(rs));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSach;
    }

    /**
     * Lấy danh sách phương tiện theo trạng thái
     */
    @Override
    public List<PhuongTien> layDanhSachPhuongTienTheoTrangThai(String trangThai) {
        List<PhuongTien> danhSach = new ArrayList<>();
        String sql = "SELECT * FROM PhuongTien WHERE TrangThai = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, trangThai);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    danhSach.add(mapResultSetToPhuongTien(rs));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSach;
    }

    /**
     * Lấy danh sách phương tiện theo tour
     */
    @Override
    public List<PhuongTien> layDanhSachPhuongTienTheoTour(int maTour) {
        List<PhuongTien> danhSach = new ArrayList<>();
        String sql = "SELECT pt.* FROM PhuongTien pt JOIN TourPhuongTien tpt ON pt.MaPhuongTien = tpt.MaPhuongTien WHERE tpt.MaTour = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, maTour);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    danhSach.add(mapResultSetToPhuongTien(rs));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSach;
    }

    /**
     * Cập nhật trạng thái phương tiện
     */
    @Override
    public boolean capNhatTrangThaiPhuongTien(int maPhuongTien, String trangThaiMoi) {
        String sql = "UPDATE PhuongTien SET TrangThai = ? WHERE MaPhuongTien = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, trangThaiMoi);
            stmt.setInt(2, maPhuongTien);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Thêm phương tiện mới
     */
    @Override
    public boolean them(PhuongTien obj) {
        String sql = "INSERT INTO PhuongTien (TenPhuongTien, LoaiPhuongTien, BienSo, SoChoNgoi, CongTy, GiaThue, TrangThai) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, obj.getTenPhuongTien());
            stmt.setString(2, obj.getLoaiPhuongTien());
            stmt.setString(3, obj.getBienSo());
            stmt.setInt(4, obj.getSoChoNgoi());
            stmt.setString(5, obj.getCongTy());
            stmt.setDouble(6, obj.getGiaThue());
            stmt.setString(7, obj.getTrangThai());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Sửa thông tin phương tiện
     */
    @Override
    public boolean sua(PhuongTien obj) {
        String sql = "UPDATE PhuongTien SET TenPhuongTien = ?, LoaiPhuongTien = ?, BienSo = ?, SoChoNgoi = ?, CongTy = ?, GiaThue = ?, TrangThai = ? WHERE MaPhuongTien = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, obj.getTenPhuongTien());
            stmt.setString(2, obj.getLoaiPhuongTien());
            stmt.setString(3, obj.getBienSo());
            stmt.setInt(4, obj.getSoChoNgoi());
            stmt.setString(5, obj.getCongTy());
            stmt.setDouble(6, obj.getGiaThue());
            stmt.setString(7, obj.getTrangThai());
            stmt.setInt(8, obj.getMaPhuongTien());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Xóa phương tiện theo mã
     */
    @Override
    public boolean xoa(int id) {
        String sql = "DELETE FROM PhuongTien WHERE MaPhuongTien = ?";
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
     * Tìm phương tiện theo mã
     */
    @Override
    public PhuongTien timTheoMa(int id) {
        String sql = "SELECT * FROM PhuongTien WHERE MaPhuongTien = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToPhuongTien(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Lấy danh sách tất cả phương tiện
     */
    @Override
    public List<PhuongTien> layDanhSach() {
        List<PhuongTien> danhSach = new ArrayList<>();
        String sql = "SELECT * FROM PhuongTien";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                danhSach.add(mapResultSetToPhuongTien(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSach;
    }
}