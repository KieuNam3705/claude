package com.tourmanagement.dto;

import com.tourmanagement.entity.HoaDon;
import java.math.BigDecimal;
import java.util.Date;

// DTO Class
public class HoaDonDTO {
    private int maHoaDon;
    private int maDatTour;
    private Date ngayThanhToan;
    private BigDecimal tongTien;
    private BigDecimal daThanhToan;
    private BigDecimal conLai;
    private String phuongThucThanhToan;
    private String trangThai;
    private String ghiChu;
    private int maNV;

    // Default constructor
    public HoaDonDTO() {
    }

    // Full constructor
    public HoaDonDTO(int maHoaDon, int maDatTour, Date ngayThanhToan, 
                     BigDecimal tongTien, BigDecimal daThanhToan, 
                     BigDecimal conLai, String phuongThucThanhToan, 
                     String trangThai, String ghiChu, int maNV) {
        this.maHoaDon = maHoaDon;
        this.maDatTour = maDatTour;
        this.ngayThanhToan = ngayThanhToan;
        this.tongTien = tongTien;
        this.daThanhToan = daThanhToan;
        this.conLai = conLai;
        this.phuongThucThanhToan = phuongThucThanhToan;
        this.trangThai = trangThai;
        this.ghiChu = ghiChu;
        this.maNV = maNV;
    }

    // Getters and Setters
    public int getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(int maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public int getMaDatTour() {
        return maDatTour;
    }

    public void setMaDatTour(int maDatTour) {
        this.maDatTour = maDatTour;
    }

    public Date getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(Date ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }

    public BigDecimal getTongTien() {
        return tongTien;
    }

    public void setTongTien(BigDecimal tongTien) {
        this.tongTien = tongTien;
    }

    public BigDecimal getDaThanhToan() {
        return daThanhToan;
    }

    public void setDaThanhToan(BigDecimal daThanhToan) {
        this.daThanhToan = daThanhToan;
    }

    public BigDecimal getConLai() {
        return conLai;
    }

    public void setConLai(BigDecimal conLai) {
        this.conLai = conLai;
    }

    public String getPhuongThucThanhToan() {
        return phuongThucThanhToan;
    }

    public void setPhuongThucThanhToan(String phuongThucThanhToan) {
        this.phuongThucThanhToan = phuongThucThanhToan;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    @Override
    public String toString() {
        return "HoaDonDTO{" +
                "maHoaDon=" + maHoaDon +
                ", maDatTour=" + maDatTour +
                ", ngayThanhToan=" + ngayThanhToan +
                ", tongTien=" + tongTien +
                ", daThanhToan=" + daThanhToan +
                ", conLai=" + conLai +
                ", phuongThucThanhToan='" + phuongThucThanhToan + '\'' +
                ", trangThai='" + trangThai + '\'' +
                ", ghiChu='" + ghiChu + '\'' +
                ", maNV=" + maNV +
                '}';
    }

    // Mapper Inner Class
    public static class HoaDonMapper {
        
        // Phương thức chuyển từ Entity sang DTO
        public HoaDonDTO toDTO(HoaDon hoaDon) {
            if (hoaDon == null) {
                return null;
            }
            
            HoaDonDTO dto = new HoaDonDTO();
            dto.setMaHoaDon(hoaDon.getMaHoaDon());
            dto.setMaDatTour(hoaDon.getMaDatTour());
            dto.setNgayThanhToan(hoaDon.getNgayThanhToan());
            dto.setTongTien(hoaDon.getTongTien());
            dto.setDaThanhToan(hoaDon.getDaThanhToan());
            dto.setConLai(hoaDon.getConLai());
            dto.setPhuongThucThanhToan(hoaDon.getPhuongThucThanhToan());
            dto.setTrangThai(hoaDon.getTrangThai());
            dto.setGhiChu(hoaDon.getGhiChu());
            dto.setMaNV(hoaDon.getMaNV());
            
            return dto;
        }
        
        // Phương thức chuyển từ DTO sang Entity
        public HoaDon toEntity(HoaDonDTO dto) {
            if (dto == null) {
                return null;
            }
            
            HoaDon hoaDon = new HoaDon();
            hoaDon.setMaHoaDon(dto.getMaHoaDon());
            hoaDon.setMaDatTour(dto.getMaDatTour());
            hoaDon.setNgayThanhToan(dto.getNgayThanhToan());
            hoaDon.setTongTien(dto.getTongTien());
            hoaDon.setDaThanhToan(dto.getDaThanhToan());
            hoaDon.setConLai(dto.getConLai());
            hoaDon.setPhuongThucThanhToan(dto.getPhuongThucThanhToan());
            hoaDon.setTrangThai(dto.getTrangThai());
            hoaDon.setGhiChu(dto.getGhiChu());
            hoaDon.setMaNV(dto.getMaNV());
            
            return hoaDon;
        }
    }
}