/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tourmanagement.entity;
import java.util.Date;
/**
 *
 * @author phanh
 */
public class TourPhuongTien {
    private int maTour;
    private int maPhuongTien;
    private Date ngayBatDau;
    private Date ngayKetThuc;
    public TourPhuongTien() {
    }
    public TourPhuongTien(int maTour, int maPhuongTien, Date ngayBatDau, Date ngayKetThuc) {
        this.maTour = maTour;
        this.maPhuongTien = maPhuongTien;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
    }
    public int getMaTour() {
        return maTour;
    }
    public void setMaTour(int maTour) {
        this.maTour = maTour;
    }
    public int getMaPhuongTien() {
        return maPhuongTien;
    }
    public void setMaPhuongTien(int maPhuongTien) {
        this.maPhuongTien = maPhuongTien;
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
}
