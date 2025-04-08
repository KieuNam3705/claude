package com.tourmanagement.dao.impl;

import com.tourmanagement.dao.interfaces.ITourNhanVienDAO;
import com.tourmanagement.entity.TourNhanVien;
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
public class TourNhanVienDAOImpl implements ITourNhanVienDAO {

    /**
     * Tìm thông tin nhân viên theo mã tour và mã nhân viên
     */
    @Override
    public TourNhanVien timTourNhanVien(int maTour, int maNV) {
        String sql = "SELECT * FROM TourNhanVien WHERE MaTour = ? AND MaNV = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, maTour);
            stmt.setInt(2, maNV);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new TourNhanVien(rs.getInt("MaTour"), rs.getInt("MaNV"), rs.getString("VaiTro"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Lấy danh sách nhân viên theo tour
     */
    @Override
    public List<TourNhanVien> layDanhSachNhanVienTheoTour(int maTour) {
        List<TourNhanVien> danhSach = new ArrayList<>();
        String sql = "SELECT * FROM TourNhanVien WHERE MaTour = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, maTour);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    danhSach.add(new TourNhanVien(rs.getInt("MaTour"), rs.getInt("MaNV"), rs.getString("VaiTro")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSach;
    }

    /**
     * Xóa tất cả nhân viên khỏi một tour
     */
    @Override
    public boolean xoaTatCaNhanVienTheoTour(int maTour) {
        String sql = "DELETE FROM TourNhanVien WHERE MaTour = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, maTour);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Thêm nhân viên vào tour
     */
    @Override
    public boolean them(TourNhanVien obj) {
        String sql = "INSERT INTO TourNhanVien (MaTour, MaNV, VaiTro) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, obj.getMaTour());
            stmt.setInt(2, obj.getMaNV());
            stmt.setString(3, obj.getVaiTro());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Sửa thông tin nhân viên trong tour
     */
    @Override
    public boolean sua(TourNhanVien obj) {
        String sql = "UPDATE TourNhanVien SET VaiTro = ? WHERE MaTour = ? AND MaNV = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, obj.getVaiTro());
            stmt.setInt(2, obj.getMaTour());
            stmt.setInt(3, obj.getMaNV());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Xóa một nhân viên khỏi tour
     */
    @Override
    public boolean xoa(int id) {
        String sql = "DELETE FROM TourNhanVien WHERE MaNV = ?";
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
     * Tìm thông tin nhân viên theo mã
     */
    @Override
    public TourNhanVien timTheoMa(int id) {
        String sql = "SELECT * FROM TourNhanVien WHERE MaNV = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new TourNhanVien(rs.getInt("MaTour"), rs.getInt("MaNV"), rs.getString("VaiTro"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Lấy danh sách tất cả nhân viên trong các tour
     */
    @Override
    public List<TourNhanVien> layDanhSach() {
        List<TourNhanVien> danhSach = new ArrayList<>();
        String sql = "SELECT * FROM TourNhanVien";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                danhSach.add(new TourNhanVien(rs.getInt("MaTour"), rs.getInt("MaNV"), rs.getString("VaiTro")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSach;
    }

    /**
     * Đếm số lượng nhân viên trong một tour
     */
    public int demSoLuongNhanVienTrongTour(int maTour) {
        String sql = "SELECT COUNT(*) FROM TourNhanVien WHERE MaTour = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, maTour);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}