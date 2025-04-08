package com.tourmanagement.dao.impl;

import com.tourmanagement.dao.interfaces.ITourChoODAO;
import com.tourmanagement.entity.TourChoO;
import com.tourmanagement.util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TourChoODAOImpl implements ITourChoODAO {

    @Override
    public TourChoO timTourChoO(int maTour, int maChoO) {
        String sql = "SELECT * FROM TourChoO WHERE MaTour = ? AND MaChoO = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, maTour);
            stmt.setInt(2, maChoO);
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
    public List<TourChoO> layDanhSachChoOTheoTour(int maTour) {
        List<TourChoO> danhSach = new ArrayList<>();
        String sql = "SELECT * FROM TourChoO WHERE MaTour = ?";
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

    @Override
    public boolean xoaTatCaChoOTheoTour(int maTour) {
        String sql = "DELETE FROM TourChoO WHERE MaTour = ?";
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
    public boolean them(TourChoO obj) {
        String sql = "INSERT INTO TourChoO (MaTour, MaChoO, NgayNhanPhong, NgayTraPhong, SoPhong, LoaiPhong, GhiChu) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            setParameters(stmt, obj);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean sua(TourChoO obj) {
        String sql = "UPDATE TourChoO SET NgayNhanPhong = ?, NgayTraPhong = ?, SoPhong = ?, LoaiPhong = ?, GhiChu = ? WHERE MaTour = ? AND MaChoO = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            // Chuyển đổi String thành Date nếu có giá trị
            Date ngayNhanPhong = null;
            if (obj.getNgayNhanPhong() != null && !obj.getNgayNhanPhong().isEmpty()) {
                try {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    java.util.Date parsed = sdf.parse(obj.getNgayNhanPhong());
                    ngayNhanPhong = new Date(parsed.getTime());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
            
            Date ngayTraPhong = null;
            if (obj.getNgayTraPhong() != null && !obj.getNgayTraPhong().isEmpty()) {
                try {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    java.util.Date parsed = sdf.parse(obj.getNgayTraPhong());
                    ngayTraPhong = new Date(parsed.getTime());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
            
            stmt.setDate(1, ngayNhanPhong);
            stmt.setDate(2, ngayTraPhong);
            stmt.setInt(3, obj.getSoPhong());
            stmt.setString(4, obj.getLoaiPhong());
            stmt.setString(5, obj.getGhiChu() != null ? obj.getGhiChu() : "");
            stmt.setInt(6, obj.getMaTour());
            stmt.setInt(7, obj.getMaChoO());
            
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean xoa(int id) {
        throw new UnsupportedOperationException("Không hỗ trợ xóa theo ID.");
    }

    @Override
    public TourChoO timTheoMa(int id) {
        throw new UnsupportedOperationException("Không hỗ trợ tìm theo ID.");
    }

    @Override
    public List<TourChoO> layDanhSach() {
        List<TourChoO> danhSach = new ArrayList<>();
        String sql = "SELECT * FROM TourChoO";
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

    private void setParameters(PreparedStatement stmt, TourChoO obj) throws SQLException {
        stmt.setInt(1, obj.getMaTour());
        stmt.setInt(2, obj.getMaChoO());
        
        // Chuyển đổi String thành Date nếu có giá trị
        Date ngayNhanPhong = null;
        if (obj.getNgayNhanPhong() != null && !obj.getNgayNhanPhong().isEmpty()) {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                java.util.Date parsed = sdf.parse(obj.getNgayNhanPhong());
                ngayNhanPhong = new Date(parsed.getTime());
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        
        Date ngayTraPhong = null;
        if (obj.getNgayTraPhong() != null && !obj.getNgayTraPhong().isEmpty()) {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                java.util.Date parsed = sdf.parse(obj.getNgayTraPhong());
                ngayTraPhong = new Date(parsed.getTime());
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        
        stmt.setDate(3, ngayNhanPhong);
        stmt.setDate(4, ngayTraPhong);
        stmt.setInt(5, obj.getSoPhong());
        stmt.setString(6, obj.getLoaiPhong());
        stmt.setString(7, obj.getGhiChu() != null ? obj.getGhiChu() : "");
    }

    private TourChoO mapper(ResultSet rs) throws SQLException {
        TourChoO tourChoO = new TourChoO();
        tourChoO.setMaTour(rs.getInt("MaTour"));
        tourChoO.setMaChoO(rs.getInt("MaChoO"));
        
        // Chuyển đổi Date thành String
        Date ngayNhanPhong = rs.getDate("NgayNhanPhong");
        if (ngayNhanPhong != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            tourChoO.setNgayNhanPhong(sdf.format(ngayNhanPhong));
        }
        
        Date ngayTraPhong = rs.getDate("NgayTraPhong");
        if (ngayTraPhong != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            tourChoO.setNgayTraPhong(sdf.format(ngayTraPhong));
        }
        
        tourChoO.setSoPhong(rs.getInt("SoPhong"));
        tourChoO.setLoaiPhong(rs.getString("LoaiPhong"));
        
        // Lấy trường GhiChu nếu có trong ResultSet
        try {
            String ghiChu = rs.getString("GhiChu");
            if (ghiChu != null) {
                tourChoO.setGhiChu(ghiChu);
            }
        } catch (SQLException e) {
            // Trường GhiChu có thể không tồn tại trong ResultSet
            // Không cần xử lý ngoại lệ này
        }
        
        return tourChoO;
    }
}