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
public class DatTour {
     private int maDatTour;
    private int maKH;
    private int maTour;
    private Date ngayDat;
    private int soLuongNguoi;
    private BigDecimal tongTien;
    private String trangThai;
    private String ghiChu;
    private String yeuCauDacBiet;
    private int maNV;
    public DatTour() {}
    public DatTour(int maDatTour, int maKH, int maTour, Date ngayDat, int soLuongNguoi, BigDecimal tongTien, String trangThai, String ghiChu, String yeuCauDacBiet, int maNV) {
        this.maDatTour = maDatTour;
        this.maKH = maKH;
        this.maTour = maTour;
        this.ngayDat = ngayDat;
        this.soLuongNguoi = soLuongNguoi;
        this.tongTien = tongTien;
        this.trangThai = trangThai;
        this.ghiChu = ghiChu;
        this.yeuCauDacBiet = yeuCauDacBiet;
        this.maNV = maNV;
    }
    public int getMaDatTour() {
        return maDatTour;
    }
    public void setMaDatTour(int maDatTour) {
        this.maDatTour = maDatTour;
    }
    public int getMaKH() {
        return maKH;
    }
    public void setMaKH(int maKH) {
        this.maKH = maKH;
    }
    public int getMaTour() {
        return maTour;
    }
    public void setMaTour(int maTour) {
        this.maTour = maTour;
    }
    public Date getNgayDat() {
        return ngayDat;
    }
    public void setNgayDat(Date ngayDat) {
        this.ngayDat = ngayDat;
    }
    public int getSoLuongNguoi() {
        return soLuongNguoi;
    }
    public void setSoLuongNguoi(int soLuongNguoi) {
        this.soLuongNguoi = soLuongNguoi;
    }
    public BigDecimal getTongTien() {
        return tongTien;
    }
    public void setTongTien(BigDecimal tongTien) {
        this.tongTien = tongTien;
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
    public String getYeuCauDacBiet() {
        return yeuCauDacBiet;
    }
    public void setYeuCauDacBiet(String yeuCauDacBiet) {
        this.yeuCauDacBiet = yeuCauDacBiet;
    }
    public int getMaNV() {
        return maNV;
    }
    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }
}
