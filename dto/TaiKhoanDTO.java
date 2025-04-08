/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tourmanagement.dto;
import com.tourmanagement.entity.TaiKhoan;
/**
 *
 * @author phanh
 */
public class TaiKhoanDTO {
    private int maTK;
    private String tenDN;
    private String matKhau;
    private String loaiTaiKhoan;
    private String trangThai;
    private Integer maKH;
    private Integer maNV;
    private String ngayTao;
    private String lanDangNhapCuoi;
    public TaiKhoanDTO(){
        
    }
    public TaiKhoanDTO(int maTK, String tenDN, String matKhau, String loaiTaiKhoan, String trangThai, Integer maKH, Integer maNV, String ngayTao, String lanDangNhapCuoi) {
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
    @Override
     public String toString() {
        return "TaiKhoanDTO {" + 
               "maTK=" + maTK + 
               ", tenDN='" + tenDN + '\'' + 
               ", matKhau='" + matKhau + '\'' + 
               ", loaiTaiKhoan='" + loaiTaiKhoan + '\'' + 
               ", trangThai='" + trangThai + '\'' + 
               ", maKH=" + maKH + 
               ", maNV=" + maNV + 
               ", ngayTao='" + ngayTao + '\'' + 
               ", lanDangNhapCuoi='" + lanDangNhapCuoi + '\'' + 
               '}';
    }
     //Phương thức chuyển từ Entity sang DTO,
        public static TaiKhoanDTO fromEntity(TaiKhoan taiKhoan) {
        if (taiKhoan == null) {
            return null;
        }
        
        TaiKhoanDTO dto = new TaiKhoanDTO();
        dto.setMaTaiKhoan(taiKhoan.getMaTaiKhoan());
        dto.setTenDangNhap(taiKhoan.getTenDangNhap());
        dto.setMatKhau(taiKhoan.getMatKhau());
        dto.setLoaiTaiKhoan(taiKhoan.getLoaiTaiKhoan());
        dto.setTrangThai(taiKhoan.getTrangThai());
        dto.setMaKH(taiKhoan.getMaKH());
        dto.setMaNV(taiKhoan.getMaNV());
        dto.setNgayTao(taiKhoan.getNgayTao());
        dto.setLanDangNhapCuoi(taiKhoan.getLanDangNhapCuoi());
        
        return dto;
    }
        //Phương thức chuyển từ DTO sang Entity
    public TaiKhoan toEntity() {
        TaiKhoan taiKhoan = new TaiKhoan();
        taiKhoan.setMaTaiKhoan(this.getMaTaiKhoan());
        taiKhoan.setTenDangNhap(this.getTenDangNhap());
        taiKhoan.setMatKhau(this.getMatKhau());
        taiKhoan.setLoaiTaiKhoan(this.getLoaiTaiKhoan());
        taiKhoan.setTrangThai(this.getTrangThai());
        taiKhoan.setMaKH(this.getMaKH());
        taiKhoan.setMaNV(this.getMaNV());
        taiKhoan.setNgayTao(this.getNgayTao());
        taiKhoan.setLanDangNhapCuoi(this.getLanDangNhapCuoi());
        
        return taiKhoan;
    }
}
