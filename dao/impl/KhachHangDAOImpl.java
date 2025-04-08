package com.tourmanagement.dao.impl;

import com.tourmanagement.dao.interfaces.IKhachHangDAO;
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
 * Lớp thực thi các phương thức truy xuất dữ liệu cho bảng KhachHang
 * @author phanh
 */
public class KhachHangDAOImpl implements IKhachHangDAO {
    
    /**
     * Thêm một khách hàng mới vào database
     * @param khachHang thông tin khách hàng cần thêm
     * @return true nếu thêm thành công, false nếu thất bại
     */
    @Override
    public boolean them(KhachHang khachHang) {
        String sql = "INSERT INTO KhachHang (HoTen, CMND, SoDienThoai, Email, DiaChi, NgaySinh, GioiTinh, QuocTich) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, khachHang.getHoTen());
            stmt.setString(2, khachHang.getCmnd());
            stmt.setString(3, khachHang.getSoDienThoai());
            stmt.setString(4, khachHang.getEmail());
            stmt.setString(5, khachHang.getDiaChi());
            stmt.setDate(6, khachHang.getNgaySinh() != null ? new java.sql.Date(khachHang.getNgaySinh().getTime()) : null);
            stmt.setString(7, khachHang.getGioiTinh());
            stmt.setString(8, khachHang.getQuocTich());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    /**
     * Xóa một khách hàng dựa trên mã khách hàng
     * @param maKH mã khách hàng cần xóa
     * @return true nếu xóa thành công, false nếu thất bại
     */
    @Override
    public boolean xoa(int maKH) {
        String sql = "DELETE FROM KhachHang WHERE MaKH = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, maKH);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Tìm khách hàng theo mã khách hàng
     * @param maKH mã khách hàng cần tìm
     * @return đối tượng KhachHang nếu tìm thấy, null nếu không tìm thấy
     */
    @Override
    public KhachHang timTheoMa(int maKH) {
        String sql = "SELECT * FROM KhachHang WHERE MaKH = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, maKH);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToKhachHang(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    /**
     * Tìm khách hàng theo số CMND/CCCD
     * @param cmnd số CMND/CCCD cần tìm
     * @return đối tượng KhachHang nếu tìm thấy, null nếu không tìm thấy
     */
    @Override
    public KhachHang timKhachHangTheoCMND(String cmnd) {
        String sql = "SELECT * FROM KhachHang WHERE CMND = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cmnd);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToKhachHang(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Tìm danh sách khách hàng theo tên (tìm kiếm gần đúng)
     * @param hoTen tên khách hàng cần tìm
     * @return danh sách khách hàng tìm thấy
     */
    @Override
    public List<KhachHang> timKhachHangTheoTen(String hoTen) {
        List<KhachHang> danhSach = new ArrayList<>();
        String sql = "SELECT * FROM KhachHang WHERE HoTen LIKE ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, "%" + hoTen + "%");
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    danhSach.add(mapResultSetToKhachHang(rs));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSach;
    }

    /**
     * Tìm danh sách khách hàng theo số điện thoại
     * @param soDienThoai số điện thoại cần tìm
     * @return danh sách khách hàng tìm thấy
     */
    @Override
    public List<KhachHang> timKhachHangTheoSDT(String soDienThoai) {
        List<KhachHang> danhSach = new ArrayList<>();
        String sql = "SELECT * FROM KhachHang WHERE SoDienThoai = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, soDienThoai);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    danhSach.add(mapResultSetToKhachHang(rs));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSach;
    }

    /**
     * Lấy danh sách khách hàng theo tour
     * @param maTour mã tour cần lấy danh sách khách hàng
     * @return danh sách khách hàng tham gia tour
     */
    @Override
    public List<KhachHang> layDanhSachKhachHangTheoTour(int maTour) {
        List<KhachHang> danhSach = new ArrayList<>();
        String sql = "SELECT k.* FROM KhachHang k "
                   + "JOIN DatTour dt ON k.MaKH = dt.MaKH "
                   + "WHERE dt.MaTour = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, maTour);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    danhSach.add(mapResultSetToKhachHang(rs));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSach;
    }

    /**
     * Cập nhật thông tin khách hàng
     * @param obj đối tượng khách hàng cần cập nhật
     * @return true nếu cập nhật thành công, false nếu thất bại
     */
    @Override
    public boolean sua(KhachHang obj) {
        String sql = "UPDATE KhachHang SET HoTen = ?, CMND = ?, SoDienThoai = ?, Email = ?, "
                   + "DiaChi = ?, NgaySinh = ?, GioiTinh = ?, QuocTich = ? WHERE MaKH = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, obj.getHoTen());
            stmt.setString(2, obj.getCmnd());
            stmt.setString(3, obj.getSoDienThoai());
            stmt.setString(4, obj.getEmail());
            stmt.setString(5, obj.getDiaChi());
            stmt.setDate(6, obj.getNgaySinh() != null ? new java.sql.Date(obj.getNgaySinh().getTime()) : null);
            stmt.setString(7, obj.getGioiTinh());
            stmt.setString(8, obj.getQuocTich());
            stmt.setInt(9, obj.getMaKH());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Lấy toàn bộ danh sách khách hàng
     * @return danh sách tất cả khách hàng
     */
    @Override
    public List<KhachHang> layDanhSach() {
        List<KhachHang> danhSach = new ArrayList<>();
        String sql = "SELECT * FROM KhachHang";
        try (Connection conn = DBConnection.getConnection();
             java.sql.Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                danhSach.add(mapResultSetToKhachHang(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSach;
    }
    
    /**
     * Chuyển đổi dữ liệu từ ResultSet sang đối tượng KhachHang
     * @param rs ResultSet chứa dữ liệu
     * @return đối tượng KhachHang được tạo từ dữ liệu
     * @throws SQLException nếu có lỗi truy xuất dữ liệu
     */
    private KhachHang mapResultSetToKhachHang(ResultSet rs) throws SQLException {
        return new KhachHang(
                rs.getInt("MaKH"),
                rs.getString("HoTen"),
                rs.getString("CMND"),
                rs.getString("SoDienThoai"),
                rs.getString("Email"),
                rs.getString("DiaChi"),
                rs.getDate("NgaySinh"),
                rs.getString("GioiTinh"),
                rs.getString("QuocTich")
        );
    }
   
}