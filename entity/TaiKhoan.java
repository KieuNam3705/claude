/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tourmanagement.entity;

/**
 *
 * @author phanh
 */
public class TaiKhoan {
    private int maTK;
    private String tenDN;
    private String matKhau;
    private String loaiTaiKhoan;
    private String trangThai;
    private Integer maKH;
    private Integer maNV;
    private String ngayTao;
    private String lanDangNhapCuoi;
    public TaiKhoan() {
    }
    public TaiKhoan(int maTK, String tenDN, String matKhau, String loaiTaiKhoan, String trangThai, Integer maKH, Integer maNV, String ngayTao, String lanDangNhapCuoi) {
        this.maTK = maTK;
        this.tenDN = tenDN;
        this.matKhau = matKhau;
        this.loaiTaiKhoan = loaiTaiKhoan;
        this.trangThai = trangThai;
        this.maKH = maKH;
        this.maNV = maNV;
        this.ngayTao = ngayTao;
        this.lanDangNhapCuoi = lanDangNhapCuoi;
    }
    public int getMaTaiKhoan() {
        return maTK;
    }
    public void setMaTaiKhoan(int maTK) {
        this.maTK = maTK;
    }
    public String getTenDangNhap() {
        return tenDN;
    }
    public void setTenDangNhap(String tenDN) {
        this.tenDN = tenDN;
    }
    public String getMatKhau() {
        return matKhau;
    }
    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }
    public String getLoaiTaiKhoan() {
        return loaiTaiKhoan;
    }
    public void setLoaiTaiKhoan(String loaiTaiKhoan) {
        this.loaiTaiKhoan = loaiTaiKhoan;
    }
    public String getTrangThai() {
        return trangThai;
    }
    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
    public Integer getMaKH() {
        return maKH;
    }
    public void setMaKH(Integer maKH) {
        this.maKH = maKH;
    }
    public Integer getMaNV() {
        return maNV;
    }
    public void setMaNV(Integer maNV) {
        this.maNV = maNV;
    }
    public String getNgayTao() {
        return ngayTao;
    }
    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }
    public String getLanDangNhapCuoi() {
        return lanDangNhapCuoi;
    }
    public void setLanDangNhapCuoi(String lanDangNhapCuoi) {
        this.lanDangNhapCuoi = lanDangNhapCuoi;
    }
}
