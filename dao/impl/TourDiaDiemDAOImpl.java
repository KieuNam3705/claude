/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tourmanagement.dao.impl;

import com.tourmanagement.dao.interfaces.ITourDiaDiemDAO;
import com.tourmanagement.entity.TourDiaDiem;
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
public class TourDiaDiemDAOImpl implements ITourDiaDiemDAO {

    @Override
    public TourDiaDiem timTourDiaDiem(int maTour, int maDiaDiem) {
        TourDiaDiem tourDiaDiem = null;
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM Tour_DiaDiem WHERE MaTour = ? AND MaDiaDiem = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, maTour);
                stmt.setInt(2, maDiaDiem);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        tourDiaDiem = new TourDiaDiem();
                        tourDiaDiem.setMaTour(rs.getInt("MaTour"));
                        tourDiaDiem.setMaDiaDiem(rs.getInt("MaDiaDiem"));
                        tourDiaDiem.setThuTu(rs.getInt("ThuTu"));
                        tourDiaDiem.setThoiGianLuuTru(rs.getInt("ThoiGianLuuTru"));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tourDiaDiem;
    }

    @Override
    public List<TourDiaDiem> layDanhSachDiaDiemTheoTour(int maTour) {
        List<TourDiaDiem> danhSach = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM Tour_DiaDiem WHERE MaTour = ? ORDER BY ThuTu";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, maTour);
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        TourDiaDiem tourDiaDiem = new TourDiaDiem();
                        tourDiaDiem.setMaTour(rs.getInt("MaTour"));
                        tourDiaDiem.setMaDiaDiem(rs.getInt("MaDiaDiem"));
                        tourDiaDiem.setThuTu(rs.getInt("ThuTu"));
                        tourDiaDiem.setThoiGianLuuTru(rs.getInt("ThoiGianLuuTru"));
                        danhSach.add(tourDiaDiem);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSach;
    }

    @Override
    public boolean xoaTatCaDiaDiemTheoTour(int maTour) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "DELETE FROM Tour_DiaDiem WHERE MaTour = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, maTour);
                int rowsAffected = stmt.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean them(TourDiaDiem obj) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO Tour_DiaDiem (MaTour, MaDiaDiem, ThuTu, ThoiGianLuuTru) VALUES (?, ?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, obj.getMaTour());
                stmt.setInt(2, obj.getMaDiaDiem());
                stmt.setInt(3, obj.getThuTu());
                stmt.setInt(4, obj.getThoiGianLuuTru());
                int rowsAffected = stmt.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean sua(TourDiaDiem obj) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "UPDATE Tour_DiaDiem SET ThuTu = ?, ThoiGianLuuTru = ? WHERE MaTour = ? AND MaDiaDiem = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, obj.getThuTu());
                stmt.setInt(2, obj.getThoiGianLuuTru());
                stmt.setInt(3, obj.getMaTour());
                stmt.setInt(4, obj.getMaDiaDiem());
                int rowsAffected = stmt.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean xoa(int id) {
        // Since TourDiaDiem has a composite key (maTour, maDiaDiem),
        // this method might not be appropriate. 
        // This implementation assumes id is maTour and will delete all entries with that maTour
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "DELETE FROM Tour_DiaDiem WHERE MaTour = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, id);
                int rowsAffected = stmt.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    // Additional method to properly handle deletion with composite key
    public boolean xoaTheoMaTourVaMaDiaDiem(int maTour, int maDiaDiem) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "DELETE FROM Tour_DiaDiem WHERE MaTour = ? AND MaDiaDiem = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, maTour);
                stmt.setInt(2, maDiaDiem);
                int rowsAffected = stmt.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public TourDiaDiem timTheoMa(int id) {
        // Since TourDiaDiem has a composite key, this method might not be appropriate.
        // This implementation assumes id is maTour and will return the first entry with that maTour
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM Tour_DiaDiem WHERE MaTour = ? LIMIT 1";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, id);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        TourDiaDiem tourDiaDiem = new TourDiaDiem();
                        tourDiaDiem.setMaTour(rs.getInt("MaTour"));
                        tourDiaDiem.setMaDiaDiem(rs.getInt("MaDiaDiem"));
                        tourDiaDiem.setThuTu(rs.getInt("ThuTu"));
                        tourDiaDiem.setThoiGianLuuTru(rs.getInt("ThoiGianLuuTru"));
                        return tourDiaDiem;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<TourDiaDiem> layDanhSach() {
        List<TourDiaDiem> danhSach = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM Tour_DiaDiem ORDER BY MaTour, ThuTu";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        TourDiaDiem tourDiaDiem = new TourDiaDiem();
                        tourDiaDiem.setMaTour(rs.getInt("MaTour"));
                        tourDiaDiem.setMaDiaDiem(rs.getInt("MaDiaDiem"));
                        tourDiaDiem.setThuTu(rs.getInt("ThuTu"));
                        tourDiaDiem.setThoiGianLuuTru(rs.getInt("ThoiGianLuuTru"));
                        danhSach.add(tourDiaDiem);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSach;
    }
}