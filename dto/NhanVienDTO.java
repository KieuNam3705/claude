package com.tourmanagement.dto;

import com.tourmanagement.entity.NhanVien;
import java.math.BigDecimal;
import java.util.Date;

// DTO Class
public class NhanVienDTO {
    private int maNV;
    private String hoTen;
    private String cmnd;
    private String soDienThoai;
    private String email;
    private String diaChi;
    private Date ngaySinh;
    private String gioiTinh;
    private String chucVu;
    private Date ngayVaoLam;
    private BigDecimal luong;

    // Default constructor
    public NhanVienDTO() {
    }

    // Full constructor
    public NhanVienDTO(int maNV, String hoTen, String cmnd, String soDienThoai, 
                       String email, String diaChi, Date ngaySinh, 
                       String gioiTinh, String chucVu, Date ngayVaoLam, BigDecimal luong) {
        this.maNV = maNV;
        this.hoTen = hoTen;
        this.cmnd = cmnd;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.diaChi = diaChi;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.chucVu = chucVu;
        this.ngayVaoLam = ngayVaoLam;
        this.luong = luong;
    }

    // Getters and Setters
    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
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

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public Date getNgayVaoLam() {
        return ngayVaoLam;
    }

    public void setNgayVaoLam(Date ngayVaoLam) {
        this.ngayVaoLam = ngayVaoLam;
    }

    public BigDecimal getLuong() {
        return luong;
    }

    public void setLuong(BigDecimal luong) {
        this.luong = luong;
    }

    @Override
    public String toString() {
        return "NhanVienDTO{" +
                "maNV=" + maNV +
                ", hoTen='" + hoTen + '\'' +
                ", cmnd='" + cmnd + '\'' +
                ", soDienThoai='" + soDienThoai + '\'' +
                ", email='" + email + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", ngaySinh=" + ngaySinh +
                ", gioiTinh='" + gioiTinh + '\'' +
                ", chucVu='" + chucVu + '\'' +
                ", ngayVaoLam=" + ngayVaoLam +
                ", luong=" + luong +
                '}';
    }

    // Mapper Inner Class
    public static class NhanVienMapper {
        
        // Phương thức chuyển từ Entity sang DTO
        public NhanVienDTO toDTO(NhanVien nhanVien) {
            if (nhanVien == null) {
                return null;
            }
            
            NhanVienDTO dto = new NhanVienDTO();
            dto.setMaNV(nhanVien.getMaNV());
            dto.setHoTen(nhanVien.getHoTen());
            dto.setCmnd(nhanVien.getCmnd());
            dto.setSoDienThoai(nhanVien.getSoDienThoai());
            dto.setEmail(nhanVien.getEmail());
            dto.setDiaChi(nhanVien.getDiaChi());
            dto.setNgaySinh(nhanVien.getNgaySinh());
            dto.setGioiTinh(nhanVien.getGioiTinh());
            dto.setChucVu(nhanVien.getChucVu());
            dto.setNgayVaoLam(nhanVien.getNgayVaoLam());
            dto.setLuong(nhanVien.getLuong());
            
            return dto;
        }
        
        // Phương thức chuyển từ DTO sang Entity
        public NhanVien toEntity(NhanVienDTO dto) {
            if (dto == null) {
                return null;
            }
            
            NhanVien nhanVien = new NhanVien();
            nhanVien.setMaNV(dto.getMaNV());
            nhanVien.setHoTen(dto.getHoTen());
            nhanVien.setCmnd(dto.getCmnd());
            nhanVien.setSoDienThoai(dto.getSoDienThoai());
            nhanVien.setEmail(dto.getEmail());
            nhanVien.setDiaChi(dto.getDiaChi());
            nhanVien.setNgaySinh(dto.getNgaySinh());
            nhanVien.setGioiTinh(dto.getGioiTinh());
            nhanVien.setChucVu(dto.getChucVu());
            nhanVien.setNgayVaoLam(dto.getNgayVaoLam());
            nhanVien.setLuong(dto.getLuong());
            
            return nhanVien;
        }
    }
}