/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tourmanagement.dao.impl;

import com.tourmanagement.dao.interfaces.IHoaDonDAO;
import com.tourmanagement.entity.HoaDon;
import com.tourmanagement.entity.KhachHang;
import com.tourmanagement.util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author phanh
 */
public class HoaDonDAOImpl implements IHoaDonDAO {

    @Override
    public HoaDon timHoaDonTheoDatTour(int maDatTour) {
    	String sql = "SELECT * FROM HoaDon WHERE MaDatTour = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, maDatTour);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToHoaDon(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<HoaDon> layDanhSachHoaDonTheoTrangThai(String trangThai) {
    	List<HoaDon> danhSach = new ArrayList<>();
        String sql = "SELECT * FROM HoaDon WHERE TrangThai = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, trangThai);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    danhSach.add(mapResultSetToHoaDon(rs));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSach;
    }

    @Override
    public List<HoaDon> layDanhSachHoaDonTheoNhanVien(int maNV) {
    	List<HoaDon> danhSach = new ArrayList<>();
        String sql = "SELECT * FROM HoaDon WHERE MaNV = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, maNV);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    danhSach.add(mapResultSetToHoaDon(rs));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSach;
    }

    @Override
    public boolean capNhatTrangThaiHoaDon(int maHoaDon, String trangThaiMoi) {
    	String sql = "UPDATE HoaDon SET TrangThai = ? WHERE MaHoaDon = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, trangThaiMoi);
            stmt.setInt(2, maHoaDon);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean capNhatThanhToanHoaDon(int maHoaDon, double soTien) {
    	String selectSQL = "SELECT TongTien, DaThanhToan FROM HoaDon WHERE MaHoaDon = ?";
        String updateSQL = "UPDATE HoaDon SET DaThanhToan = ?, ConLai = ? WHERE MaHoaDon = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement selectStmt = conn.prepareStatement(selectSQL)) {
            selectStmt.setInt(1, maHoaDon);
            try (ResultSet rs = selectStmt.executeQuery()) {
                if (rs.next()) {
                    double tongTien = rs.getDouble("TongTien");
                    double daThanhToan = rs.getDouble("DaThanhToan");
                    double newDaThanhToan = daThanhToan + soTien;
                    double conLai = tongTien - newDaThanhToan;
                    try (PreparedStatement updateStmt = conn.prepareStatement(updateSQL)) {
                        updateStmt.setDouble(1, newDaThanhToan);
                        updateStmt.setDouble(2, conLai);
                        updateStmt.setInt(3, maHoaDon);
                        return updateStmt.executeUpdate() > 0;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean them(HoaDon obj) {
    	String sql = "INSERT INTO HoaDon (MaDatTour, NgayThanhToan, TongTien, DaThanhToan, ConLai, PhuongThucThanhToan, TrangThai, GhiChu, MaNV) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, obj.getMaDatTour());
            stmt.setTimestamp(2, obj.getNgayThanhToan() != null ? new java.sql.Timestamp(obj.getNgayThanhToan().getTime()) : null);
            stmt.setBigDecimal(3, obj.getTongTien());
            stmt.setBigDecimal(4, obj.getDaThanhToan());
            stmt.setBigDecimal(5, obj.getConLai());
            stmt.setString(6, obj.getPhuongThucThanhToan());
            stmt.setString(7, obj.getTrangThai());
            stmt.setString(8, obj.getGhiChu());
            stmt.setInt(9, obj.getMaNV());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean sua(HoaDon obj) {
    	String sql = "UPDATE HoaDon SET MaDatTour = ?, NgayThanhToan = ?, TongTien = ?, DaThanhToan = ?, ConLai = ?, PhuongThucThanhToan = ?, TrangThai = ?, GhiChu = ?, MaNV = ? WHERE MaHoaDon = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, obj.getMaDatTour());
            stmt.setTimestamp(2, obj.getNgayThanhToan() != null ? new java.sql.Timestamp(obj.getNgayThanhToan().getTime()) : null);
            stmt.setBigDecimal(3, obj.getTongTien());
            stmt.setBigDecimal(4, obj.getDaThanhToan());
            stmt.setBigDecimal(5, obj.getConLai());
            stmt.setString(6, obj.getPhuongThucThanhToan());
            stmt.setString(7, obj.getTrangThai());
            stmt.setString(8, obj.getGhiChu());
            stmt.setInt(9, obj.getMaNV());
            stmt.setInt(10, obj.getMaHoaDon());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean xoa(int id) {
    	String sql = "DELETE FROM HoaDon WHERE MaHoaDon = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public HoaDon timTheoMa(int id) {
    	String sql = "SELECT * FROM HoaDon WHERE MaHoaDon = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToHoaDon(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<HoaDon> layDanhSach() {
    	List<HoaDon> danhSach = new ArrayList<>();
        String sql = "SELECT * FROM HoaDon";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                danhSach.add(mapResultSetToHoaDon(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSach;
    }
    
    private HoaDon mapResultSetToHoaDon(ResultSet rs) throws SQLException {
        return new HoaDon(
        		rs.getInt("MaHoaDon"),
        		rs.getInt("MaDatTour"),
		        rs.getTimestamp("NgayThanhToan"),
		        rs.getBigDecimal("TongTien"),
                        rs.getBigDecimal("DaThanhToan"),
                        rs.getBigDecimal("ConLai"),
		        rs.getString("PhuongThucThanhToan"),
		        rs.getString("TrangThai"),
		        rs.getString("GhiChu"),
		        rs.getInt("MaNV")
        );
    }
    
}
