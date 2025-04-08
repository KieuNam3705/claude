/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tourmanagement.dao.impl;

import com.tourmanagement.dao.interfaces.IChoODAO;
import com.tourmanagement.entity.ChoO;
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
public class ChoODAOImpl implements IChoODAO {

    @Override
    public List<ChoO> timChoOTheoTen(String tenChoO) {
        List<ChoO> danhSach = new ArrayList<>();
        String sql = "SELECT * FROM ChoO WHERE TenChoO LIKE ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, "%" + tenChoO + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                danhSach.add(mapper(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSach;
    }

    @Override
    public List<ChoO> layDanhSachChoOTheoLoai(String loaiChoO) {
        List<ChoO> danhSach = new ArrayList<>();
        String sql = "SELECT * FROM ChoO WHERE LoaiChoO = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, loaiChoO);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                danhSach.add(mapper(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSach;
    }

    @Override
    public List<ChoO> layDanhSachChoOTheoThanhPho(String thanhPho) {
        List<ChoO> danhSach = new ArrayList<>();
        String sql = "SELECT * FROM ChoO WHERE ThanhPho = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, thanhPho);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                danhSach.add(mapper(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSach;
    }

    @Override
    public List<ChoO> layDanhSachChoOTheoSoSao(int soSao) {
        List<ChoO> danhSach = new ArrayList<>();
        String sql = "SELECT * FROM ChoO WHERE SoSao = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, soSao);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                danhSach.add(mapper(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSach;
    }

    @Override
    public boolean them(ChoO obj) {
        String sql = "INSERT INTO ChoO (TenChoO, LoaiChoO, DiaChi, ThanhPho, QuocGia, SoDienThoai, Email, Website, SoSao, GiaThue) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            setParameters(stmt, obj);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean sua(ChoO obj) {
        String sql = "UPDATE ChoO SET TenChoO = ?, LoaiChoO = ?, DiaChi = ?, ThanhPho = ?, QuocGia = ?, SoDienThoai = ?, Email = ?, Website = ?, SoSao = ?, GiaThue = ? WHERE MaChoO = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            setParameters(stmt, obj);
            stmt.setInt(11, obj.getMaChoO());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean xoa(int id) {
        String sql = "DELETE FROM ChoO WHERE MaChoO = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }




        @Override
    public ChoO timTheoMa(int id) {
        String sql = "SELECT * FROM ChoO WHERE MaChoO = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
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
    public List<ChoO> layDanhSach() {
        List<ChoO> danhSach = new ArrayList<>();
        String sql = "SELECT * FROM ChoO";
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

    private ChoO mapper(ResultSet rs) throws SQLException {
        return new ChoO(
            rs.getInt("MaChoO"),
            rs.getString("TenChoO"),
            rs.getString("LoaiChoO"),
            rs.getString("DiaChi"),
            rs.getString("ThanhPho"),
            rs.getString("QuocGia"),
            rs.getString("SoDienThoai"),
            rs.getString("Email"),
            rs.getString("Website"),
            rs.getInt("SoSao"),
            rs.getBigDecimal("GiaThue")
        );
    }
    private void setParameters(PreparedStatement stmt, ChoO obj) throws SQLException {
        stmt.setString(1, obj.getTenChoO());
        stmt.setString(2, obj.getLoaiChoO());
        stmt.setString(3, obj.getDiaChi());
        stmt.setString(4, obj.getThanhPho());
        stmt.setString(5, obj.getQuocGia());
        stmt.setString(6, obj.getSoDienThoai());
        stmt.setString(7, obj.getEmail());
        stmt.setString(8, obj.getWebsite());
        stmt.setInt(9, obj.getSoSao());
        stmt.setBigDecimal(10, obj.getGiaThue());
    }

    @Override
public List<ChoO> layDanhSachChoOTheoTour(int maTour) {
    List<ChoO> danhSach = new ArrayList<>();
    String sql = "SELECT c.* FROM ChoO c " +
                 "JOIN TourChoO tc ON c.MaChoO = tc.MaChoO " +
                 "WHERE tc.MaTour = ?";
    try (Connection conn = DBConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, maTour);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            danhSach.add(mapper(rs));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return danhSach;
}
}

    

