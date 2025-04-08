package com.tourmanagement.dao.impl;

import com.tourmanagement.dao.interfaces.ITourDAO;
import com.tourmanagement.entity.Tour;
import java.math.BigDecimal;
import com.tourmanagement.util.DBConnection;
import java.util.Date;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author phanh
 */
public class TourDAOImpl implements ITourDAO {

    @Override
    public List<Tour> timTourTheoTen(String tenTour) {
        String sql = "SELECT * FROM Tour WHERE TenTour LIKE ?";
        List<Tour> danhSachTour = new ArrayList<>();
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, "%" + tenTour + "%");
            
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    danhSachTour.add(mapResultSetToTour(rs));
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(TourDAOImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return danhSachTour;
    }

    @Override
    public List<Tour> layDanhSachTourTheoTrangThai(String trangThai) {
        String sql = "SELECT * FROM Tour WHERE TrangThai = ?";
        List<Tour> danhSachTour = new ArrayList<>();
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, trangThai);
            
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    danhSachTour.add(mapResultSetToTour(rs));
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(TourDAOImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return danhSachTour;
    }

    @Override
    public List<Tour> layDanhSachTourTheoNgay(Date ngayBatDau, Date ngayKetThuc) {
        String sql = "SELECT * FROM Tour WHERE NgayBatDau >= ? AND NgayKetThuc <= ?";
        List<Tour> danhSachTour = new ArrayList<>();
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDate(1, new java.sql.Date(ngayBatDau.getTime()));
            stmt.setDate(2, new java.sql.Date(ngayKetThuc.getTime()));
            
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    danhSachTour.add(mapResultSetToTour(rs));
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(TourDAOImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return danhSachTour;
    }

    @Override
    public List<Tour> layDanhSachTourTheoLoai(String loaiTour) {
        String sql = "SELECT * FROM Tour WHERE LoaiTour = ?";
        List<Tour> danhSachTour = new ArrayList<>();
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, loaiTour);
            
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    danhSachTour.add(mapResultSetToTour(rs));
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(TourDAOImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return danhSachTour;
    }

    @Override
    public boolean capNhatTrangThaiTour(int maTour, String trangThaiMoi) {
        String sql = "UPDATE Tour SET TrangThai = ? WHERE MaTour = ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, trangThaiMoi);
            stmt.setInt(2, maTour);
            
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            Logger.getLogger(TourDAOImpl.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }

    /**
     * Thêm một tour mới vào database
     * @param tour thông tin tour cần thêm
     * @return true nếu thêm thành công, false nếu thất bại
     */
    @Override
    public boolean them(Tour tour) {
        String sql = "INSERT INTO Tour (TenTour, MoTa, NgayBatDau, NgayKetThuc, SoNgay, SoLuongKhachToiDa, GiaTour, LoaiTour, TrangThai) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, tour.getTenTour());  
            stmt.setString(2, tour.getMoTa());  
            stmt.setDate(3, new java.sql.Date(tour.getNgayBatDau().getTime()));  
            stmt.setDate(4, new java.sql.Date(tour.getNgayKetThuc().getTime()));  
            stmt.setInt(5, tour.getSoNgay());  
            stmt.setInt(6, tour.getSoLuongKhachToiDa());  
            stmt.setBigDecimal(7, tour.getGiaTour()); 
            stmt.setString(8, tour.getLoaiTour()); 
            stmt.setString(9, tour.getTrangThai()); 
            return stmt.executeUpdate() > 0;
                
        } catch (SQLException e) {
           Logger.getLogger(TourDAOImpl.class.getName()).log(Level.SEVERE, null, e);
           return false;
        }
    }

    @Override
    public boolean sua(Tour obj) {
        String sql = "UPDATE Tour SET TenTour=?, MoTa=?, NgayBatDau=?, NgayKetThuc=?, SoNgay=?, SoLuongKhachToiDa=?, GiaTour=?, LoaiTour=?, TrangThai=? WHERE MaTour=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, obj.getTenTour());
            stmt.setString(2, obj.getMoTa());
            stmt.setDate(3, new java.sql.Date(obj.getNgayBatDau().getTime()));
            stmt.setDate(4, new java.sql.Date(obj.getNgayKetThuc().getTime()));
            stmt.setInt(5, obj.getSoNgay());
            stmt.setInt(6, obj.getSoLuongKhachToiDa());
            stmt.setBigDecimal(7, obj.getGiaTour());
            stmt.setString(8, obj.getLoaiTour());
            stmt.setString(9, obj.getTrangThai());
            stmt.setInt(10, obj.getMaTour());
            
            return stmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(TourDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }            
    }

    @Override
    public boolean xoa(int maTour) {
        String sql = "DELETE FROM Tour WHERE MaTour=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, maTour);
            return stmt.executeUpdate() > 0;
            
        } catch (SQLException e) {
            Logger.getLogger(TourDAOImpl.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }

    @Override
    public Tour timTheoMa(int id) {
        String sql = "SELECT * FROM Tour WHERE MaTour = ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToTour(rs);
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(TourDAOImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return null;
    }

    @Override
    public List<Tour> layDanhSach() {
        String sql = "SELECT * FROM Tour";
        List<Tour> danhSachTour = new ArrayList<>();
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                danhSachTour.add(mapResultSetToTour(rs));
            }
        } catch (SQLException e) {
            Logger.getLogger(TourDAOImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return danhSachTour;
    }
    
    private Tour mapResultSetToTour(ResultSet rs) throws SQLException {
        return new Tour(
            rs.getInt("MaTour"),
            rs.getString("TenTour"),
            rs.getString("MoTa"),
            rs.getDate("NgayBatDau"),
            rs.getDate("NgayKetThuc"),
            rs.getInt("SoNgay"),
            rs.getInt("SoLuongKhachToiDa"),
            rs.getBigDecimal("GiaTour"),
            rs.getString("LoaiTour"),
            rs.getString("TrangThai")
        );
    }
}