/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tourmanagement.entity;
import java.math.BigDecimal;
/**
 *
 * @author phanh
 */
public class ChoO {
    private int maChoO;
    private String tenChoO;
    private String loaiChoO;
    private String diaChi;
    private String thanhPho;
    private String quocGia;
    private String soDienThoai;
    private String email;
    private String website;
    private int soSao;
    private BigDecimal giaThue;
    public ChoO() {}
    public ChoO(int maChoO, String tenChoO, String loaiChoO, String diaChi, String thanhPho, String quocGia, String soDienThoai, String email, String website, int soSao, BigDecimal giaThue) {
        this.maChoO = maChoO;
        this.tenChoO = tenChoO;
        this.loaiChoO = loaiChoO;
        this.diaChi = diaChi;
        this.thanhPho = thanhPho;
        this.quocGia = quocGia;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.website = website;
        this.soSao = soSao;
        this.giaThue = giaThue;
    }
    public int getMaChoO() {
        return maChoO;
    }
    public void setMaChoO(int maChoO) {
        this.maChoO = maChoO;
    }
    public String getTenChoO() {
        return tenChoO;
    }
    public void setTenChoO(String tenChoO) {
        this.tenChoO = tenChoO;
    }
    public String getLoaiChoO() {
        return loaiChoO;
    }
    public void setLoaiChoO(String loaiChoO) {
        this.loaiChoO = loaiChoO;
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
    public String getSoDienThoai() {
        return soDienThoai;
    }
    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getWebsite() {
        return website;
    }
    public void setWebsite(String website) {
        this.website = website;
    }
    public int getSoSao() {
        return soSao;
    }
    public void setSoSao(int soSao) {
        this.soSao = soSao;
    }
    public BigDecimal getGiaThue() {
        return giaThue;
    }
    public void setGiaThue(BigDecimal giaThue) {
        this.giaThue = giaThue;
    }
}
