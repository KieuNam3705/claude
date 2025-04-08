/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tourmanagement.dao.impl;

import com.tourmanagement.dao.interfaces.IChiTietThanhToanDAO;
import com.tourmanagement.entity.ChiTietThanhToan;
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
public class ChiTietThanhToanDAOImpl implements IChiTietThanhToanDAO {

    @Override
    public List<ChiTietThanhToan> layDanhSachThanhToanTheoHoaDon(int maHoaDon) {
    	List<ChiTietThanhToan> danhSach = new ArrayList<>();
        String sql = "SELECT * FROM ChiTietThanhToan WHERE MaHoaDon = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, maHoaDon);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    danhSach.add(mapResultSetToChiTietThanhToan(rs));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSach;
    }

    @Override
    public double tinhTongTienDaThanhToan(int maHoaDon) {
    	double tongTien = 0;
        String sql = "SELECT SUM(SoTien) as TongTien FROM ChiTietThanhToan WHERE MaHoaDon = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, maHoaDon);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    tongTien = rs.getDouble("TongTien");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tongTien;
    }

    @Override
    public boolean them(ChiTietThanhToan obj) {
    	String sql = "INSERT INTO ChiTietThanhToan (MaHoaDon, NgayThanhToan, SoTien, PhuongThucThanhToan, GhiChu, MaNV) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, obj.getMaHoaDon());
            stmt.setTimestamp(2, obj.getNgayThanhToan() != null ? new Timestamp(obj.getNgayThanhToan().getTime()) : null);
            stmt.setBigDecimal(3, obj.getSoTien());
            stmt.setString(4, obj.getPhuongThucThanhToan());
            stmt.setString(5, obj.getGhiChu());
            stmt.setInt(6, obj.getMaNV());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean sua(ChiTietThanhToan obj) {
    	String sql = "UPDATE ChiTietThanhToan SET MaHoaDon = ?, NgayThanhToan = ?, SoTien = ?, PhuongThucThanhToan = ?, GhiChu = ?, MaNV = ? WHERE MaThanhToan = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, obj.getMaHoaDon());
            stmt.setTimestamp(2, obj.getNgayThanhToan() != null ? new Timestamp(obj.getNgayThanhToan().getTime()) : null);
            stmt.setBigDecimal(3, obj.getSoTien());
            stmt.setString(4, obj.getPhuongThucThanhToan());
            stmt.setString(5, obj.getGhiChu());
            stmt.setInt(6, obj.getMaNV());
            stmt.setInt(7, obj.getMaThanhToan());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean xoa(int id) {
    	String sql = "DELETE FROM ChiTietThanhToan WHERE MaThanhToan = ?";
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
    public ChiTietThanhToan timTheoMa(int id) {
    	String sql = "SELECT * FROM ChiTietThanhToan WHERE MaThanhToan = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToChiTietThanhToan(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<ChiTietThanhToan> layDanhSach() {
        List<ChiTietThanhToan> danhSach = new ArrayList<>();
        String sql = "SELECT * FROM HoaDon";
        try (Connection conn = DBConnection.getConnection();
             java.sql.Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                danhSach.add(mapResultSetToChiTietThanhToan(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSach;
    }
    
    private ChiTietThanhToan mapResultSetToChiTietThanhToan(ResultSet rs) throws SQLException {
        return new ChiTietThanhToan(
        		rs.getInt("MaThanhToan"),
        		rs.getInt("MaHoaDon"),
        		rs.getTimestamp("NgayThanhToan"),
        		rs.getBigDecimal("SoTien"),
        		rs.getString("PhuongThucThanhToan"),
	        	rs.getString("GhiChu"),
	        	rs.getInt("MaNV")
        );
    }
}
