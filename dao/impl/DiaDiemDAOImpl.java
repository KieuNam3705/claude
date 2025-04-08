/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tourmanagement.dao.impl;

import com.tourmanagement.dao.interfaces.IDiaDiemDAO;
import com.tourmanagement.entity.DiaDiem;
import com.tourmanagement.util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author phanh
 */
public class DiaDiemDAOImpl implements IDiaDiemDAO {

    @Override
    public List<DiaDiem> timDiaDiemTheoTen(String tenDiaDiem) {
        String sql = "SELECT * FROM DiaDiem WHERE TenDiaDiem LIKE ?";
        List<DiaDiem> danhSachDiaDiem = new ArrayList<>();
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, "%" + tenDiaDiem + "%");
            
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    danhSachDiaDiem.add(mapResultSetToDiaDiem(rs));
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(DiaDiemDAOImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return danhSachDiaDiem;
    }

    @Override
    public List<DiaDiem> layDanhSachDiaDiemTheoThanhPho(String thanhPho) {
        String sql = "SELECT * FROM DiaDiem WHERE ThanhPho = ?";
        List<DiaDiem> danhSachDiaDiem = new ArrayList<>();
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, thanhPho);
            
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    danhSachDiaDiem.add(mapResultSetToDiaDiem(rs));
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(DiaDiemDAOImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return danhSachDiaDiem;
    }

    @Override
    public List<DiaDiem> layDanhSachDiaDiemTheoQuocGia(String quocGia) {
        String sql = "SELECT * FROM DiaDiem WHERE QuocGia = ?";
        List<DiaDiem> danhSachDiaDiem = new ArrayList<>();
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, quocGia);
            
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    danhSachDiaDiem.add(mapResultSetToDiaDiem(rs));
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(DiaDiemDAOImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return danhSachDiaDiem;
    }

    @Override
    public List<DiaDiem> layDanhSachDiaDiemTheoTour(int maTour) {
        String sql = "SELECT d.* FROM DiaDiem d " +
                     "JOIN ChiTietLichTrinh ct ON d.MaDiaDiem = ct.MaDiaDiem " +
                     "JOIN LichTrinh lt ON ct.MaLichTrinh = lt.MaLichTrinh " +
                     "WHERE lt.MaTour = ?";
        List<DiaDiem> danhSachDiaDiem = new ArrayList<>();
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, maTour);
            
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    danhSachDiaDiem.add(mapResultSetToDiaDiem(rs));
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(DiaDiemDAOImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return danhSachDiaDiem;
    }

    @Override
    public boolean them(DiaDiem obj) {
        String sql = "INSERT INTO DiaDiem (TenDiaDiem, MoTa, DiaChi, ThanhPho, QuocGia, DacDiem) VALUES (?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, obj.getTenDiaDiem());
            stmt.setString(2, obj.getMoTa());
            stmt.setString(3, obj.getDiaChi());
            stmt.setString(4, obj.getThanhPho());
            stmt.setString(5, obj.getQuocGia());
            stmt.setString(6, obj.getDacDiem());
            
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            Logger.getLogger(DiaDiemDAOImpl.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }

    @Override
    public boolean sua(DiaDiem obj) {
        String sql = "UPDATE DiaDiem SET TenDiaDiem = ?, MoTa = ?, DiaChi = ?, ThanhPho = ?, QuocGia = ?, DacDiem = ? WHERE MaDiaDiem = ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, obj.getTenDiaDiem());
            stmt.setString(2, obj.getMoTa());
            stmt.setString(3, obj.getDiaChi());
            stmt.setString(4, obj.getThanhPho());
            stmt.setString(5, obj.getQuocGia());
            stmt.setString(6, obj.getDacDiem());
            stmt.setInt(7, obj.getMaDiaDiem());
            
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            Logger.getLogger(DiaDiemDAOImpl.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }

    @Override
    public boolean xoa(int id) {
        String sql = "DELETE FROM DiaDiem WHERE MaDiaDiem = ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            Logger.getLogger(DiaDiemDAOImpl.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }

    @Override
    public DiaDiem timTheoMa(int id) {
        String sql = "SELECT * FROM DiaDiem WHERE MaDiaDiem = ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToDiaDiem(rs);
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(DiaDiemDAOImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return null;
    }

    @Override
    public List<DiaDiem> layDanhSach() {
        String sql = "SELECT * FROM DiaDiem";
        List<DiaDiem> danhSachDiaDiem = new ArrayList<>();
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                danhSachDiaDiem.add(mapResultSetToDiaDiem(rs));
            }
        } catch (SQLException e) {
            Logger.getLogger(DiaDiemDAOImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return danhSachDiaDiem;
    }
    
    /**
     * Phương thức hỗ trợ chuyển đổi từ ResultSet sang đối tượng DiaDiem
     * @param rs ResultSet từ câu lệnh query
     * @return Đối tượng DiaDiem
     * @throws SQLException Nếu có lỗi khi truy cập dữ liệu
     */
    private DiaDiem mapResultSetToDiaDiem(ResultSet rs) throws SQLException {
        return new DiaDiem(
            rs.getInt("MaDiaDiem"),
            rs.getString("TenDiaDiem"),
            rs.getString("MoTa"),
            rs.getString("DiaChi"),
            rs.getString("ThanhPho"),
            rs.getString("QuocGia"),
            rs.getString("DacDiem")
        );
    }
}