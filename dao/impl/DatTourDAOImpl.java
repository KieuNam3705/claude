/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tourmanagement.dao.impl;

import com.tourmanagement.dao.interfaces.IDatTourDAO;
import com.tourmanagement.entity.DatTour;
import com.tourmanagement.util.DBConnection;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author phanh
 */
public class DatTourDAOImpl implements IDatTourDAO {

     
    @Override
    public List<DatTour> layDanhSachDatTourTheoKhachHang(int maKH) {
        List<DatTour> danhSach = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM DatTour WHERE MaKH = ? ORDER BY NgayDat DESC";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, maKH);
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        danhSach.add(extractDatTourFromResultSet(rs));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSach;
    }

    @Override
    public List<DatTour> layDanhSachDatTourTheoTour(int maTour) {
        List<DatTour> danhSach = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM DatTour WHERE MaTour = ? ORDER BY NgayDat DESC";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, maTour);
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        danhSach.add(extractDatTourFromResultSet(rs));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSach;
    }

    @Override
    public List<DatTour> layDanhSachDatTourTheoTrangThai(String trangThai) {
        List<DatTour> danhSach = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM DatTour WHERE TrangThai = ? ORDER BY NgayDat DESC";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, trangThai);
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        danhSach.add(extractDatTourFromResultSet(rs));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSach;
    }

    @Override
    public List<DatTour> layDanhSachDatTourTheoNhanVien(int maNV) {
        List<DatTour> danhSach = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM DatTour WHERE MaNV = ? ORDER BY NgayDat DESC";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, maNV);
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        danhSach.add(extractDatTourFromResultSet(rs));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSach;
    }

    @Override
    public boolean capNhatTrangThaiDatTour(int maDatTour, String trangThaiMoi) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "UPDATE DatTour SET TrangThai = ? WHERE MaDatTour = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, trangThaiMoi);
                stmt.setInt(2, maDatTour);
                int rowsAffected = stmt.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean them(DatTour obj) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO DatTour (MaKH, MaTour, NgayDat, SoLuongNguoi, TongTien, TrangThai, GhiChu, YeuCauDacBiet, MaNV) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                stmt.setInt(1, obj.getMaKH());
                stmt.setInt(2, obj.getMaTour());
                stmt.setTimestamp(3, new Timestamp(obj.getNgayDat().getTime()));
                stmt.setInt(4, obj.getSoLuongNguoi());
                stmt.setBigDecimal(5, obj.getTongTien());
                stmt.setString(6, obj.getTrangThai());
                stmt.setString(7, obj.getGhiChu());
                stmt.setString(8, obj.getYeuCauDacBiet());
                stmt.setInt(9, obj.getMaNV());
                
                int rowsAffected = stmt.executeUpdate();
                
                if (rowsAffected > 0) {
                    try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                        if (generatedKeys.next()) {
                            obj.setMaDatTour(generatedKeys.getInt(1));
                            return true;
                        }
                    }
                }
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean sua(DatTour obj) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "UPDATE DatTour SET MaKH = ?, MaTour = ?, NgayDat = ?, SoLuongNguoi = ?, TongTien = ?, TrangThai = ?, GhiChu = ?, YeuCauDacBiet = ?, MaNV = ? WHERE MaDatTour = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, obj.getMaKH());
                stmt.setInt(2, obj.getMaTour());
                stmt.setTimestamp(3, new Timestamp(obj.getNgayDat().getTime()));
                stmt.setInt(4, obj.getSoLuongNguoi());
                stmt.setBigDecimal(5, obj.getTongTien());
                stmt.setString(6, obj.getTrangThai());
                stmt.setString(7, obj.getGhiChu());
                stmt.setString(8, obj.getYeuCauDacBiet());
                stmt.setInt(9, obj.getMaNV());
                stmt.setInt(10, obj.getMaDatTour());
                
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
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "DELETE FROM DatTour WHERE MaDatTour = ?";
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

    @Override
    public DatTour timTheoMa(int id) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM DatTour WHERE MaDatTour = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, id);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        return extractDatTourFromResultSet(rs);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<DatTour> layDanhSach() {
        List<DatTour> danhSach = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM DatTour ORDER BY NgayDat DESC";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        danhSach.add(extractDatTourFromResultSet(rs));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSach;
    }
    
    // Helper method to extract DatTour object from ResultSet
    private DatTour extractDatTourFromResultSet(ResultSet rs) throws SQLException {
        DatTour datTour = new DatTour();
        datTour.setMaDatTour(rs.getInt("MaDatTour"));
        datTour.setMaKH(rs.getInt("MaKH"));
        datTour.setMaTour(rs.getInt("MaTour"));
        datTour.setNgayDat(rs.getTimestamp("NgayDat"));
        datTour.setSoLuongNguoi(rs.getInt("SoLuongNguoi"));
        datTour.setTongTien(rs.getBigDecimal("TongTien"));
        datTour.setTrangThai(rs.getString("TrangThai"));
        datTour.setGhiChu(rs.getString("GhiChu"));
        datTour.setYeuCauDacBiet(rs.getString("YeuCauDacBiet"));
        datTour.setMaNV(rs.getInt("MaNV"));
        return datTour;
    }
    
    // Additional utility methods
    
    /**
     * Lấy danh sách đặt tour theo khoảng thời gian
     * @param tuNgay Ngày bắt đầu
     * @param denNgay Ngày kết thúc
     * @return Danh sách đặt tour
     */
    public List<DatTour> layDanhSachDatTourTheoKhoangThoiGian(java.util.Date tuNgay, java.util.Date denNgay) {
        List<DatTour> danhSach = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM DatTour WHERE NgayDat BETWEEN ? AND ? ORDER BY NgayDat DESC";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setTimestamp(1, new Timestamp(tuNgay.getTime()));
                stmt.setTimestamp(2, new Timestamp(denNgay.getTime()));
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        danhSach.add(extractDatTourFromResultSet(rs));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSach;
    }
    
    /**
     * Lấy tổng doanh thu từ các đặt tour
     * @return Tổng doanh thu
     */
    public BigDecimal tinhTongDoanhThu() {
        BigDecimal tongDoanhThu = BigDecimal.ZERO;
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT SUM(TongTien) AS TongDoanhThu FROM DatTour WHERE TrangThai = 'Đã hoàn thành'";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        tongDoanhThu = rs.getBigDecimal("TongDoanhThu");
                        if (tongDoanhThu == null) {
                            tongDoanhThu = BigDecimal.ZERO;
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tongDoanhThu;
    }
    
    /**
     * Đếm số lượng đặt tour theo trạng thái
     * @param trangThai Trạng thái cần đếm
     * @return Số lượng đặt tour
     */
    public int demSoLuongDatTourTheoTrangThai(String trangThai) {
        int soLuong = 0;
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT COUNT(*) AS SoLuong FROM DatTour WHERE TrangThai = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, trangThai);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        soLuong = rs.getInt("SoLuong");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return soLuong;
    }

    @Override
    public int tinhTongSoNguoiDaDatChoTour(int maTour, int maDatTourExclude) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}