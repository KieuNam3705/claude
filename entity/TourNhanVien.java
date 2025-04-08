/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tourmanagement.entity;

/**
 *
 * @author phanh
 */
public class TourNhanVien {
    private int maTour;
    private int maNV;
    private String vaiTro;
    public TourNhanVien() {
    }
    public TourNhanVien(int maTour, int maNV, String vaiTro) {
        this.maTour = maTour;
        this.maNV = maNV;
        this.vaiTro = vaiTro;
    }
    public int getMaTour() {
        return maTour;
    }
    public void setMaTour(int maTour) {
        this.maTour = maTour;
    }
    public int getMaNV() {
        return maNV;
    }
    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }
    public String getVaiTro() {
        return vaiTro;
    }
    public void setVaiTro(String vaiTro) {
        this.vaiTro = vaiTro;
    }
}
