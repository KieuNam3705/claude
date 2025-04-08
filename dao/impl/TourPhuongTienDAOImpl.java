/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tourmanagement.dao.impl;

import com.tourmanagement.dao.interfaces.ITourPhuongTienDAO;
import com.tourmanagement.entity.TourPhuongTien;
import com.tourmanagement.util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author phanh
 */
public class TourPhuongTienDAOImpl implements ITourPhuongTienDAO {

    @Override
    public TourPhuongTien timTourPhuongTien(int maTour, int maPhuongTien) {
        String sql = "SELECT * FROM TourPhuongTien WHERE MaTour = ? AND MaPhuongTien = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, maTour);
            stmt.setInt(2, maPhuongTien);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToTourPhuongTien(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<TourPhuongTien> layDanhSachPhuongTienTheoTour(int maTour) {
        List<TourPhuongTien> danhSach = new ArrayList<>();
        String sql = "SELECT * FROM TourPhuongTien WHERE MaTour = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, maTour);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    danhSach.add(mapResultSetToTourPhuongTien(rs));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSach;
    }

    @Override
    public boolean xoaTatCaPhuongTienTheoTour(int maTour) {
        String sql = "DELETE FROM TourPhuongTien WHERE MaTour = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, maTour);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean them(TourPhuongTien obj) {
        String sql = "INSERT INTO TourPhuongTien (MaTour, MaPhuongTien, NgayBatDau, NgayKetThuc) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, obj.getMaTour());
            stmt.setInt(2, obj.getMaPhuongTien());
            stmt.setTimestamp(3, obj.getNgayBatDau() != null ? new Timestamp(obj.getNgayBatDau().getTime()) : null);
            stmt.setTimestamp(4, obj.getNgayKetThuc() != null ? new Timestamp(obj.getNgayKetThuc().getTime()) : null);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean sua(TourPhuongTien obj) {
        String sql = "UPDATE TourPhuongTien SET NgayBatDau = ?, NgayKetThuc = ? WHERE MaTour = ? AND MaPhuongTien = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setTimestamp(1, obj.getNgayBatDau() != null ? new Timestamp(obj.getNgayBatDau().getTime()) : null);
            stmt.setTimestamp(2, obj.getNgayKetThuc() != null ? new Timestamp(obj.getNgayKetThuc().getTime()) : null);
            stmt.setInt(3, obj.getMaTour());
            stmt.setInt(4, obj.getMaPhuongTien());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean xoa(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public boolean xoa(int maTour, int maPhuongTien) {
        String sql = "DELETE FROM TourPhuongTien WHERE MaTour = ? AND MaPhuongTien = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, maTour);
            stmt.setInt(2, maPhuongTien);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    @Override
    public TourPhuongTien timTheoMa(int maPhuongTien) {
        String sql = "SELECT * FROM TourPhuongTien WHERE MaPhuongTien = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, maPhuongTien);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToTourPhuongTien(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<TourPhuongTien> layDanhSach() {
        List<TourPhuongTien> danhSach = new ArrayList<>();
        String sql = "SELECT * FROM TourPhuongTien";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                danhSach.add(mapResultSetToTourPhuongTien(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSach;
    }
    
    private TourPhuongTien mapResultSetToTourPhuongTien(ResultSet rs) throws SQLException {
        return new TourPhuongTien(
            rs.getInt("MaTour"),
            rs.getInt("MaPhuongTien"),
            rs.getTimestamp("NgayBatDau"),
            rs.getTimestamp("NgayKetThuc")
        );
    }
}