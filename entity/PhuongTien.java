/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tourmanagement.entity;

/**
 *
 * @author phanh
 */
public class PhuongTien {
       private int maPhuongTien;
    private String loaiPhuongTien;
    private String tenPhuongTien;
    private String bienSo;
    private int soChoNgoi;
    private String congTy;
    private double giaThue;
    private String trangThai;
    public PhuongTien() {
    }
    public PhuongTien(int maPhuongTien, String loaiPhuongTien, String tenPhuongTien, String bienSo, int soChoNgoi, String congTy, double giaThue, String trangThai) {
        this.maPhuongTien = maPhuongTien;
        this.loaiPhuongTien = loaiPhuongTien;
        this.tenPhuongTien = tenPhuongTien;
        this.bienSo = bienSo;
        this.soChoNgoi = soChoNgoi;
        this.congTy = congTy;
        this.giaThue = giaThue;
        this.trangThai = trangThai;
    }
    public int getMaPhuongTien() {
        return maPhuongTien;
    }
    public void setMaPhuongTien(int maPhuongTien) {
        this.maPhuongTien = maPhuongTien;
    }
    public String getLoaiPhuongTien() {
        return loaiPhuongTien;
    }
    public void setLoaiPhuongTien(String loaiPhuongTien) {
        this.loaiPhuongTien = loaiPhuongTien;
    }
    public String getTenPhuongTien() {
        return tenPhuongTien;
    }
    public void setTenPhuongTien(String tenPhuongTien) {
        this.tenPhuongTien = tenPhuongTien;
    }
    public String getBienSo() {
        return bienSo;
    }
    public void setBienSo(String bienSo) {
        this.bienSo = bienSo;
    }
    public int getSoChoNgoi() {
        return soChoNgoi;
    }
    public void setSoChoNgoi(int soChoNgoi) {
        this.soChoNgoi = soChoNgoi;
    }
    public String getCongTy() {
        return congTy;
    }
    public void setCongTy(String congTy) {
        this.congTy = congTy;
    }
    public double getGiaThue() {
        return giaThue;
    }
    public void setGiaThue(double giaThue) {
        this.giaThue = giaThue;
    }
    public String getTrangThai() {
        return trangThai;
    }
    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
}
