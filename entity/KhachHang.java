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
public class KhachHang {
    private int maKH;
    private String hoTen;
    private String cmnd;
    private String soDienThoai;
    private String email;
    private String diaChi;
    private Date ngaySinh;
    private String gioiTinh;
    private String quocTich;
    private Date ngayDangKy;
    // Constructors
    public KhachHang ()
    {
        
    }
    public KhachHang (int maKH, String hoTen, String cmnd, String soDienThoai, String email, String diaChi, Date ngaySinh, String gioiTinh, String quocTich)
    {
        this.maKH=maKH;
        this.hoTen=hoTen;
        this.cmnd=cmnd;
        this.soDienThoai=soDienThoai;
        this.email=email;
        this.diaChi=diaChi;
        this.ngaySinh=ngaySinh;
        this.gioiTinh=gioiTinh;
        this.quocTich=quocTich;
        this.ngayDangKy=ngayDangKy;
    }

  
    //Getter setter
    public int getMaKH()
    {
        return maKH;
    }
    public void setMaKH(int maKH)
    {
        this.maKH=maKH;
    }
    public String getHoTen()
    {
        return hoTen;
    }
    public void setHoTen(String hoTen)
    {
        this.hoTen=hoTen;
    }
    public String getCmnd() {
        return cmnd;
    }
    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
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
    public String getDiaChi() {
        return diaChi;
    }
    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
    public Date getNgaySinh() {
        return ngaySinh;
    }
    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }
    public String getGioiTinh() {
        return gioiTinh;
    }
    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }
    public String getQuocTich() {
        return quocTich;
    }
    public void setQuocTich(String quocTich) {
        this.quocTich = quocTich;
    }
    public Date getNgayDangKy() {
        return ngayDangKy;
    }
    public void setNgayDangKy(Date ngayDangKy) {
        this.ngayDangKy = ngayDangKy;
    }
    @Override
    public String toString() {
        return "KhachHang{" + "maKH=" + maKH + ", hoTen=" + hoTen + ", cmnd=" + cmnd + 
               ", soDienThoai=" + soDienThoai + ", email=" + email + ", diaChi=" + diaChi + 
               ", ngaySinh=" + ngaySinh + ", gioiTinh=" + gioiTinh + 
               ", quocTich=" + quocTich + ", ngayDangKy=" + ngayDangKy + '}';
    }

}
