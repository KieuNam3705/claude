/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tourmanagement.entity;

/**
 *
 * @author phanh
 */
public class TourChoO {
    private int maTour;
    private int maChoO;
    private String ngayNhanPhong;
    private String ngayTraPhong;
    private int soPhong;
    private String ghiChu;
    private String loaiPhong;
    public TourChoO() {
    }
    public TourChoO(int maTour, int maChoO, String ngayNhanPhong, String ngayTraPhong, int soPhong, String ghiChu, String loaiPhong) {
        this.maTour = maTour;
        this.maChoO = maChoO;
        this.ngayNhanPhong = ngayNhanPhong;
        this.ngayTraPhong = ngayTraPhong;
        this.soPhong = soPhong;
        this.ghiChu=ghiChu;
        this.loaiPhong = loaiPhong;
    }
    public int getMaTour() {
        return maTour;
    }
    public void setMaTour(int maTour) {
        this.maTour = maTour;
    }
    public int getMaChoO() {
        return maChoO;
    }
    public void setMaChoO(int maChoO) {
        this.maChoO = maChoO;
    }
    public String getNgayNhanPhong() {
        return ngayNhanPhong;
    }
    public void setNgayNhanPhong(String ngayNhanPhong) {
        this.ngayNhanPhong = ngayNhanPhong;
    }
    public String getNgayTraPhong() {
        return ngayTraPhong;
    }
    public void setNgayTraPhong(String ngayTraPhong) {
        this.ngayTraPhong = ngayTraPhong;
    }
    public int getSoPhong() {
        return soPhong;
    }
    public void setSoPhong(int soPhong) {
        this.soPhong = soPhong;
    }
     public String getGhiChu() {
        return ghiChu;
    }
    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
    public String getLoaiPhong() {
        return loaiPhong;
    }
    public void setLoaiPhong(String loaiPhong) {
        this.loaiPhong = loaiPhong;
    }
}
