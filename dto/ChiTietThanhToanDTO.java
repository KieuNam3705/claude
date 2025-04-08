/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tourmanagement.dto;
import com.tourmanagement.entity.ChiTietThanhToan;
import java.math.BigDecimal;
import java.util.Date;
/**
 *
 * @author phanh
 */
public class ChiTietThanhToanDTO {
     private int maThanhToan;
    private int maHoaDon;
    private Date ngayThanhToan;
    private BigDecimal soTien;
    private String phuongThucThanhToan;
    private String ghiChu;
    private int maNV;
    public ChiTietThanhToanDTO () {
    }
    public ChiTietThanhToanDTO (int maThanhToan, int maHoaDon, Date ngayThanhToan, BigDecimal soTien, String phuongThucThanhToan, String ghiChu, int maNV) {
        this.maThanhToan = maThanhToan;
        this.maHoaDon = maHoaDon;
        this.ngayThanhToan = ngayThanhToan;
        this.soTien = soTien;
        this.phuongThucThanhToan = phuongThucThanhToan;
        this.ghiChu = ghiChu;
        this.maNV = maNV;
    }
    public int getMaThanhToan() {
        return maThanhToan;
    }
    public void setMaThanhToan(int maThanhToan) {
        this.maThanhToan = maThanhToan;
    }
    public int getMaHoaDon() {
        return maHoaDon;
    }
    public void setMaHoaDon(int maHoaDon) {
        this.maHoaDon = maHoaDon;
    }
    public Date getNgayThanhToan() {
        return ngayThanhToan;
    }
    public void setNgayThanhToan(Date ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }
    public BigDecimal getSoTien() {
        return soTien;
    }
    public void setSoTien(BigDecimal soTien) {
        this.soTien = soTien;
    }
    public String getPhuongThucThanhToan() {
        return phuongThucThanhToan;
    }
    public void setPhuongThucThanhToan(String phuongThucThanhToan) {
        this.phuongThucThanhToan = phuongThucThanhToan;
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
    // toString nối chuỗi
    @Override
    public String toString() {
        return "ChiTietThanhToanDTO{" +
               "maThanhToan=" + maThanhToan +
               ", maHoaDon=" + maHoaDon +
               ", ngayThanhToan=" + ngayThanhToan +
               ", soTien=" + soTien +
               ", phuongThucThanhToan='" + phuongThucThanhToan + '\'' +
               ", ghiChu='" + ghiChu + '\'' +
               ", maNV=" + maNV +
               '}';
    }
    //Phương thức chuyển từ Entity sang DTO
 
    public static ChiTietThanhToanDTO fromEntity(ChiTietThanhToan chiTietThanhToan) {
        if (chiTietThanhToan == null) {
            return null;
        }
        
        ChiTietThanhToanDTO dto = new ChiTietThanhToanDTO();
        dto.setMaThanhToan(chiTietThanhToan.getMaThanhToan());
        dto.setMaHoaDon(chiTietThanhToan.getMaHoaDon());
        dto.setNgayThanhToan(chiTietThanhToan.getNgayThanhToan());
        dto.setSoTien(chiTietThanhToan.getSoTien());
        dto.setPhuongThucThanhToan(chiTietThanhToan.getPhuongThucThanhToan());
        dto.setGhiChu(chiTietThanhToan.getGhiChu());
        dto.setMaNV(chiTietThanhToan.getMaNV());
        
        return dto;
    }

   //Phương thức chuyển từ DTO sang Entity
    public ChiTietThanhToan toEntity() {
        ChiTietThanhToan entity = new ChiTietThanhToan();
        entity.setMaThanhToan(this.getMaThanhToan());
        entity.setMaHoaDon(this.getMaHoaDon());
        entity.setNgayThanhToan(this.getNgayThanhToan());
        entity.setSoTien(this.getSoTien());
        entity.setPhuongThucThanhToan(this.getPhuongThucThanhToan());
        entity.setGhiChu(this.getGhiChu());
        entity.setMaNV(this.getMaNV());
        
        return entity;
    }

}
