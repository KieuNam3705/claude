/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tourmanagement.entity;
import java.math.BigDecimal;
import java.util.Date;
/**
 *
 * @author phanh
 */
public class HoaDon {
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
    public HoaDon() {
    }
    public HoaDon(int maHoaDon, int maDatTour, Date ngayThanhToan, BigDecimal tongTien, BigDecimal daThanhToan, BigDecimal conLai, String phuongThucThanhToan, String trangThai, String ghiChu, int maNV) {
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
}
