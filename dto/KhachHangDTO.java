package com.tourmanagement.dto;

import com.tourmanagement.entity.KhachHang;
import java.util.Date;

// DTO Class
public class KhachHangDTO {
    private int maKH;
    private String hoTen;
    private String cmnd;
    private String soDienThoai;
    private String email;
    private String diaChi;
    private Date ngaySinh;
    private String gioiTinh;
    private String quocTich;
    private Date ngayDangKy;

    // Default constructor
    public KhachHangDTO() {
    }

    // Full constructor
    public KhachHangDTO(int maKH, String hoTen, String cmnd, String soDienThoai, 
                        String email, String diaChi, Date ngaySinh, 
                        String gioiTinh, String quocTich, Date ngayDangKy) {
        this.maKH = maKH;
        this.hoTen = hoTen;
        this.cmnd = cmnd;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.diaChi = diaChi;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.quocTich = quocTich;
        this.ngayDangKy = ngayDangKy;
    }

    // Getters and Setters
    public int getMaKH() {
        return maKH;
    }

    public void setMaKH(int maKH) {
        this.maKH = maKH;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getQuocTich() {
        return quocTich;
    }

    public void setQuocTich(String quocTich) {
        this.quocTich = quocTich;
    }

    public Date getNgayDangKy() {
        return ngayDangKy;
    }

    public void setNgayDangKy(Date ngayDangKy) {
        this.ngayDangKy = ngayDangKy;
    }

    @Override
    public String toString() {
        return "KhachHangDTO{" +
                "maKH=" + maKH +
                ", hoTen='" + hoTen + '\'' +
                ", cmnd='" + cmnd + '\'' +
                ", soDienThoai='" + soDienThoai + '\'' +
                ", email='" + email + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", ngaySinh=" + ngaySinh +
                ", gioiTinh='" + gioiTinh + '\'' +
                ", quocTich='" + quocTich + '\'' +
                ", ngayDangKy=" + ngayDangKy +
                '}';
    }

    // Mapper Inner Class
    public static class KhachHangMapper {
        
        // Phương thức chuyển từ Entity sang DTO
        public KhachHangDTO toDTO(KhachHang khachHang) {
            if (khachHang == null) {
                return null;
            }
            
            KhachHangDTO dto = new KhachHangDTO();
            dto.setMaKH(khachHang.getMaKH());
            dto.setHoTen(khachHang.getHoTen());
            dto.setCmnd(khachHang.getCmnd());
            dto.setSoDienThoai(khachHang.getSoDienThoai());
            dto.setEmail(khachHang.getEmail());
            dto.setDiaChi(khachHang.getDiaChi());
            dto.setNgaySinh(khachHang.getNgaySinh());
            dto.setGioiTinh(khachHang.getGioiTinh());
            dto.setQuocTich(khachHang.getQuocTich());
            dto.setNgayDangKy(khachHang.getNgayDangKy());
            
            return dto;
        }
        
        // Phương thức chuyển từ DTO sang Entity
        public KhachHang toEntity(KhachHangDTO dto) {
            if (dto == null) {
                return null;
            }
            
            KhachHang khachHang = new KhachHang();
            khachHang.setMaKH(dto.getMaKH());
            khachHang.setHoTen(dto.getHoTen());
            khachHang.setCmnd(dto.getCmnd());
            khachHang.setSoDienThoai(dto.getSoDienThoai());
            khachHang.setEmail(dto.getEmail());
            khachHang.setDiaChi(dto.getDiaChi());
            khachHang.setNgaySinh(dto.getNgaySinh());
            khachHang.setGioiTinh(dto.getGioiTinh());
            khachHang.setQuocTich(dto.getQuocTich());
            khachHang.setNgayDangKy(dto.getNgayDangKy());
            
            return khachHang;
        }
    }
}