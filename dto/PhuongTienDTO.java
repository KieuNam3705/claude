package com.tourmanagement.dto;

import com.tourmanagement.entity.PhuongTien;

public class PhuongTienDTO {
    private int maPhuongTien;
    private String loaiPhuongTien;
    private String tenPhuongTien;
    private String bienSo;
    private int soChoNgoi;
    private String congTy;
    private double giaThue;
    private String trangThai;

    
    public PhuongTienDTO() {
    }

    
    public PhuongTienDTO(int maPhuongTien, String loaiPhuongTien, String tenPhuongTien, 
                         String bienSo, int soChoNgoi, String congTy, 
                         double giaThue, String trangThai) {
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

    public String getLoaiPhuongTien() {
        return loaiPhuongTien;
    }

    public String getTenPhuongTien() {
        return tenPhuongTien;
    }

    public String getBienSo() {
        return bienSo;
    }

    public int getSoChoNgoi() {
        return soChoNgoi;
    }

    public String getCongTy() {
        return congTy;
    }

    public double getGiaThue() {
        return giaThue;
    }

    public String getTrangThai() {
        return trangThai;
    }

    // Setter methods
    public void setMaPhuongTien(int maPhuongTien) {
        this.maPhuongTien = maPhuongTien;
    }

    public void setLoaiPhuongTien(String loaiPhuongTien) {
        this.loaiPhuongTien = loaiPhuongTien;
    }

    public void setTenPhuongTien(String tenPhuongTien) {
        this.tenPhuongTien = tenPhuongTien;
    }

    public void setBienSo(String bienSo) {
        this.bienSo = bienSo;
    }

    public void setSoChoNgoi(int soChoNgoi) {
        this.soChoNgoi = soChoNgoi;
    }

    public void setCongTy(String congTy) {
        this.congTy = congTy;
    }

    public void setGiaThue(double giaThue) {
        this.giaThue = giaThue;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

  
    @Override
    public String toString() {
        return "PhuongTienDTO{" +
                "maPhuongTien=" + maPhuongTien +
                ", loaiPhuongTien='" + loaiPhuongTien + '\'' +
                ", tenPhuongTien='" + tenPhuongTien + '\'' +
                ", bienSo='" + bienSo + '\'' +
                ", soChoNgoi=" + soChoNgoi +
                ", congTy='" + congTy + '\'' +
                ", giaThue=" + giaThue +
                ", trangThai='" + trangThai + '\'' +
                '}';
    }

public static class PhuongTienMapper {
    public  PhuongTienDTO toDTO(PhuongTien phuongTien) {
        if (phuongTien == null) {
            return null;
        }
        
        PhuongTienDTO dto = new PhuongTienDTO();
        dto.setMaPhuongTien(phuongTien.getMaPhuongTien());
        dto.setLoaiPhuongTien(phuongTien.getLoaiPhuongTien());
        dto.setTenPhuongTien(phuongTien.getTenPhuongTien());
        dto.setBienSo(phuongTien.getBienSo());
        dto.setSoChoNgoi(phuongTien.getSoChoNgoi());
        dto.setCongTy(phuongTien.getCongTy());
        dto.setGiaThue(phuongTien.getGiaThue());
        dto.setTrangThai(phuongTien.getTrangThai());
        
        return dto;
    }

    
    public PhuongTien toEntity(PhuongTienDTO dto) {
        if (dto == null) {
                return null;
            }
   
        PhuongTien phuongTien = new PhuongTien();
        phuongTien.setMaPhuongTien(dto.maPhuongTien);
        phuongTien.setLoaiPhuongTien(dto.loaiPhuongTien);
        phuongTien.setTenPhuongTien(dto.tenPhuongTien);
        phuongTien.setBienSo(dto.bienSo);
        phuongTien.setSoChoNgoi(dto.soChoNgoi);
        phuongTien.setCongTy(dto.congTy);
        phuongTien.setGiaThue(dto.giaThue);
        phuongTien.setTrangThai(dto.trangThai);
        
        return phuongTien;
    }
     }
}