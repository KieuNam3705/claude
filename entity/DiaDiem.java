/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tourmanagement.entity;

/**
 *
 * @author phanh
 */
public class DiaDiem {
     private int maDiaDiem;
    private String tenDiaDiem;
    private String moTa;
    private String diaChi;
    private String thanhPho;
    private String quocGia;
    private String dacDiem;
    public DiaDiem() {
    }
    public DiaDiem(int maDiaDiem, String tenDiaDiem, String moTa, String diaChi, String thanhPho, String quocGia, String dacDiem) {
        this.maDiaDiem = maDiaDiem;
        this.tenDiaDiem = tenDiaDiem;
        this.moTa = moTa;
        this.diaChi = diaChi;
        this.thanhPho = thanhPho;
        this.quocGia = quocGia;
        this.dacDiem = dacDiem;
    }
    public int getMaDiaDiem() {
        return maDiaDiem;
    }
    public void setMaDiaDiem(int maDiaDiem) {
        this.maDiaDiem = maDiaDiem;
    }
    public String getTenDiaDiem() {
        return tenDiaDiem;
    }
    public void setTenDiaDiem(String tenDiaDiem) {
        this.tenDiaDiem = tenDiaDiem;
    }
    public String getMoTa() {
        return moTa;
    }
    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
    public String getDiaChi() {
        return diaChi;
    }
    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
    public String getThanhPho() {
        return thanhPho;
    }
    public void setThanhPho(String thanhPho) {
        this.thanhPho = thanhPho;
    }
    public String getQuocGia() {
        return quocGia;
    }
    public void setQuocGia(String quocGia) {
        this.quocGia = quocGia;
    }
    public String getDacDiem() {
        return dacDiem;
    }
    public void setDacDiem(String dacDiem) {
        this.dacDiem = dacDiem;
    }
}
