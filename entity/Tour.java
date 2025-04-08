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
public class Tour {
    private int maTour;
    private String tenTour;
    private String moTa;
    private Date ngayBatDau;
    private Date ngayKetThuc;
    private int soNgay;
    private int soLuongKhachToiDa;
    private BigDecimal giaTour;
    private String loaiTour;
    private String trangThai;
    public Tour() {}
    public Tour(int maTour,String tenTour,String moTa,Date ngayBatDau,Date ngayKetThuc,int soNgay,int soLuongKhachToiDa,BigDecimal giaTour,String loaiTour,String trangThai){
        this.maTour=maTour;
        this.tenTour=tenTour;
        this.moTa=moTa;
        this.ngayBatDau=ngayBatDau;
        this.ngayKetThuc=ngayKetThuc;
        this.soNgay=soNgay;
        this.soLuongKhachToiDa=soLuongKhachToiDa;
        this.giaTour=giaTour;
        this.loaiTour=loaiTour;
        this.trangThai=trangThai;
    }
      public int getMaTour() {
        return maTour;
    }
    public void setMaTour(int maTour) {
        this.maTour = maTour;
    }
    public String getTenTour() {
        return tenTour;
    }
    public void setTenTour(String tenTour) {
        this.tenTour = tenTour;
    }
    public String getMoTa() {
        return moTa;
    }
    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
    public Date getNgayBatDau() {
        return ngayBatDau;
    }
    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }
    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }
    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }
    public int getSoNgay() {
        return soNgay;
    }
    public void setSoNgay(int soNgay) {
        this.soNgay = soNgay;
    }
    public int getSoLuongKhachToiDa() {
        return soLuongKhachToiDa;
    }
    public void setSoLuongKhachToiDa(int soLuongKhachToiDa) {
        this.soLuongKhachToiDa = soLuongKhachToiDa;
    }
    public BigDecimal getGiaTour() {
        return giaTour;
    }
    public void setGiaTour(BigDecimal giaTour) {
        this.giaTour = giaTour;
    }
    public String getLoaiTour() {
        return loaiTour;
    }
    public void setLoaiTour(String loaiTour) {
        this.loaiTour = loaiTour;
    }
    public String getTrangThai() {
        return trangThai;
    }
    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
}
