package com.tourmanagement.dto;

import com.tourmanagement.entity.DatTour;
import java.math.BigDecimal;
import java.util.Date;

public class DatTourDTO {
    private int maDatTour;
    private int maKH;
    private int maTour;
    private Date ngayDat;
    private int soLuongNguoi;
    private BigDecimal tongTien;
    private String trangThai;
    private String ghiChu;
    private String yeuCauDacBiet;
    private int maNV;

    public DatTourDTO() {}

    public DatTourDTO(int maDatTour, int maKH, int maTour, Date ngayDat, int soLuongNguoi, 
                      BigDecimal tongTien, String trangThai, String ghiChu, 
                      String yeuCauDacBiet, int maNV) {
        this.maDatTour = maDatTour;
        this.maKH = maKH;
        this.maTour = maTour;
        this.ngayDat = ngayDat;
        this.soLuongNguoi = soLuongNguoi;
        this.tongTien = tongTien;
        this.trangThai = trangThai;
        this.ghiChu = ghiChu;
        this.yeuCauDacBiet = yeuCauDacBiet;
        this.maNV = maNV;
    }

 
    public int getMaDatTour() {
        return maDatTour;
    }

    public void setMaDatTour(int maDatTour) {
        this.maDatTour = maDatTour;
    }

    public int getMaKH() {
        return maKH;
    }

    public void setMaKH(int maKH) {
        this.maKH = maKH;
    }

    public int getMaTour() {
        return maTour;
    }

    public void setMaTour(int maTour) {
        this.maTour = maTour;
    }

    public Date getNgayDat() {
        return ngayDat;
    }

    public void setNgayDat(Date ngayDat) {
        this.ngayDat = ngayDat;
    }

    public int getSoLuongNguoi() {
        return soLuongNguoi;
    }

    public void setSoLuongNguoi(int soLuongNguoi) {
        this.soLuongNguoi = soLuongNguoi;
    }

    public BigDecimal getTongTien() {
        return tongTien;
    }

    public void setTongTien(BigDecimal tongTien) {
        this.tongTien = tongTien;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getYeuCauDacBiet() {
        return yeuCauDacBiet;
    }

    public void setYeuCauDacBiet(String yeuCauDacBiet) {
        this.yeuCauDacBiet = yeuCauDacBiet;
    }

    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

 public static class DatTourMapper {
    public  DatTourDTO toDTO(DatTour datTour) {
        if (datTour == null) {
            return null;
        }
        
        DatTourDTO dto = new DatTourDTO();
        dto.setMaDatTour(datTour.getMaDatTour());
        dto.setMaKH(datTour.getMaKH());
        dto.setMaTour(datTour.getMaTour());
        dto.setNgayDat(datTour.getNgayDat());
        dto.setSoLuongNguoi(datTour.getSoLuongNguoi());
        dto.setTongTien(datTour.getTongTien());
        dto.setTrangThai(datTour.getTrangThai());
        dto.setGhiChu(datTour.getGhiChu());
        dto.setYeuCauDacBiet(datTour.getYeuCauDacBiet());
        dto.setMaNV(datTour.getMaNV());
        
        return dto;
    }

       public DatTour toEntity(DatTourDTO dto) {
        DatTour entity = new DatTour();
        entity.setMaDatTour(dto.getMaDatTour());
        entity.setMaKH(dto.getMaKH());
        entity.setMaTour(dto.getMaTour());
        entity.setNgayDat(dto.getNgayDat());
        entity.setSoLuongNguoi(dto.getSoLuongNguoi());
        entity.setTongTien(dto.getTongTien());
        entity.setTrangThai(dto.getTrangThai());
        entity.setGhiChu(dto.getGhiChu());
        entity.setYeuCauDacBiet(dto.getYeuCauDacBiet());
        entity.setMaNV(dto.getMaNV());
        
        return entity;
    }
}
  
    @Override
    public String toString() {
        return "DatTourDTO{" +
               "maDatTour=" + maDatTour +
               ", maKH=" + maKH +
               ", maTour=" + maTour +
               ", ngayDat=" + ngayDat +
               ", soLuongNguoi=" + soLuongNguoi +
               ", tongTien=" + tongTien +
               ", trangThai='" + trangThai + '\'' +
               ", ghiChu='" + ghiChu + '\'' +
               ", yeuCauDacBiet='" + yeuCauDacBiet + '\'' +
               ", maNV=" + maNV +
               '}';
    }
}