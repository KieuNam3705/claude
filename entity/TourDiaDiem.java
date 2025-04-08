/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tourmanagement.entity;

/**
 *
 * @author phanh
 */
public class TourDiaDiem {
    private int maTour;
    private int maDiaDiem;
    private int thuTu;
    private int thoiGianLuuTru;
    public TourDiaDiem() {
    }
    public TourDiaDiem(int maTour, int maDiaDiem, int thuTu, int thoiGianLuuTru) {
        this.maTour = maTour;
        this.maDiaDiem = maDiaDiem;
        this.thuTu = thuTu;
        this.thoiGianLuuTru = thoiGianLuuTru;
    }
    public int getMaTour() {
        return maTour;
    }
    public void setMaTour(int maTour) {
        this.maTour = maTour;
    }
    public int getMaDiaDiem() {
        return maDiaDiem;
    }
    public void setMaDiaDiem(int maDiaDiem) {
        this.maDiaDiem = maDiaDiem;
    }
    public int getThuTu() {
        return thuTu;
    }
    public void setThuTu(int thuTu) {
        this.thuTu = thuTu;
    }
    public int getThoiGianLuuTru() {
        return thoiGianLuuTru;
    }
    public void setThoiGianLuuTru(int thoiGianLuuTru) {
        this.thoiGianLuuTru = thoiGianLuuTru;
    }
}
