/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tourmanagement.dao.impl;

import com.tourmanagement.dao.interfaces.ITaiKhoanDAO;
import com.tourmanagement.entity.TaiKhoan;
import com.tourmanagement.util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class TaiKhoanDAOImpl implements ITaiKhoanDAO {

    @Override
    public TaiKhoan timTheoMa(int maTaiKhoan) {
        String sql = "SELECT * FROM TaiKhoan WHERE MaTaiKhoan = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, maTaiKhoan);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return mapper(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public TaiKhoan timTheoTenDangNhap(String tenDangNhap) {
        String sql = "SELECT * FROM TaiKhoan WHERE TenDangNhap = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, tenDangNhap);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return mapper(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public TaiKhoan timTheoMaKH(int maKH) {
        String sql = "SELECT * FROM TaiKhoan WHERE MaKH = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, maKH);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return mapper(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public TaiKhoan timTheoTenDangNhap(int maNV) {
        String sql = "SELECT * FROM TaiKhoan WHERE MaNV = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, maNV);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return mapper(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public TaiKhoan capNhatMatKhau(int maTK, String newPassword) {
        String sql = "UPDATE TaiKhoan SET MatKhau = ? WHERE MaTaiKhoan = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, newPassword);
            stmt.setInt(2, maTK);
            int result = stmt.executeUpdate();
            if (result > 0) {
                return timTheoMa(maTK);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public TaiKhoan capNhatTrangThaiTaiKhoan(int maTK, String trangThai) {
        String sql = "UPDATE TaiKhoan SET TrangThai = ? WHERE MaTaiKhoan = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, trangThai);
            stmt.setInt(2, maTK);
            int result = stmt.executeUpdate();
            if (result > 0) {
                return timTheoMa(maTK);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public TaiKhoan kiemTraTenDN(String tenDN) {
        return timTheoTenDangNhap(tenDN);
    }

    @Override
    public boolean them(Object obj) {
        if (!(obj instanceof TaiKhoan)) {
            return false;
        }
        TaiKhoan taiKhoan = (TaiKhoan) obj;
        String sql = "INSERT INTO TaiKhoan (TenDangNhap, MatKhau, LoaiTaiKhoan, TrangThai, MaKH, MaNV, NgayTao, LanDangNhapCuoi) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, taiKhoan.getTenDangNhap());
            stmt.setString(2, taiKhoan.getMatKhau());
            stmt.setString(3, taiKhoan.getLoaiTaiKhoan());
            stmt.setString(4, taiKhoan.getTrangThai());
            
            if (taiKhoan.getMaKH() != null) {
                stmt.setInt(5, taiKhoan.getMaKH());
            } else {
                stmt.setNull(5, java.sql.Types.INTEGER);
            }
            
            if (taiKhoan.getMaNV() != null) {
                stmt.setInt(6, taiKhoan.getMaNV());
            } else {
                stmt.setNull(6, java.sql.Types.INTEGER);
            }
            
            // Handle date strings or use current timestamp
            Timestamp currentTime = new Timestamp(System.currentTimeMillis());
            stmt.setTimestamp(7, currentTime); // NgayTao
            stmt.setTimestamp(8, null); // LanDangNhapCuoi
            
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean sua(Object obj) {
        if (!(obj instanceof TaiKhoan)) {
            return false;
        }
        TaiKhoan taiKhoan = (TaiKhoan) obj;
        String sql = "UPDATE TaiKhoan SET TenDangNhap = ?, MatKhau = ?, LoaiTaiKhoan = ?, TrangThai = ?, MaKH = ?, MaNV = ? WHERE MaTaiKhoan = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, taiKhoan.getTenDangNhap());
            stmt.setString(2, taiKhoan.getMatKhau());
            stmt.setString(3, taiKhoan.getLoaiTaiKhoan());
            stmt.setString(4, taiKhoan.getTrangThai());
            
            if (taiKhoan.getMaKH() != null) {
                stmt.setInt(5, taiKhoan.getMaKH());
            } else {
                stmt.setNull(5, java.sql.Types.INTEGER);
            }
            
            if (taiKhoan.getMaNV() != null) {
                stmt.setInt(6, taiKhoan.getMaNV());
            } else {
                stmt.setNull(6, java.sql.Types.INTEGER);
            }
            
            stmt.setInt(7, taiKhoan.getMaTaiKhoan());
            
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean xoa(int id) {
        String sql = "DELETE FROM TaiKhoan WHERE MaTaiKhoan = ?";
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
    public List layDanhSach() {
        List<TaiKhoan> danhSach = new ArrayList<>();
        String sql = "SELECT * FROM TaiKhoan";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                danhSach.add(mapper(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSach;
    }


    private TaiKhoan mapper(ResultSet rs) throws SQLException {
        TaiKhoan taiKhoan = new TaiKhoan();
        taiKhoan.setMaTaiKhoan(rs.getInt("MaTaiKhoan"));
        taiKhoan.setTenDangNhap(rs.getString("TenDangNhap"));
        taiKhoan.setMatKhau(rs.getString("MatKhau"));
        taiKhoan.setLoaiTaiKhoan(rs.getString("LoaiTaiKhoan"));
        taiKhoan.setTrangThai(rs.getString("TrangThai"));
        
        int maKH = rs.getInt("MaKH");
        if (!rs.wasNull()) {
            taiKhoan.setMaKH(maKH);
        }
        
        int maNV = rs.getInt("MaNV");
        if (!rs.wasNull()) {
            taiKhoan.setMaNV(maNV);
        }
        
        Timestamp ngayTao = rs.getTimestamp("NgayTao");
        if (ngayTao != null) {
            taiKhoan.setNgayTao(ngayTao.toString());
        }
        
        Timestamp lanDangNhapCuoi = rs.getTimestamp("LanDangNhapCuoi");
        if (lanDangNhapCuoi != null) {
            taiKhoan.setLanDangNhapCuoi(lanDangNhapCuoi.toString());
        }
        
        return taiKhoan;
    }
}