package com.tourmanagement.dto;

import com.tourmanagement.entity.Tour;
import java.math.BigDecimal;
import java.util.Date;

// DTO Class
public class TourDTO {
    private int maTour;
    private String tenTour;
    private String moTa;
    private Date ngayBatDau;
    private Date ngayKetThuc;
    private int soNgay;
    private int soLuongKhachToiDa;
    private BigDecimal giaTour;
    private String loaiTour;
    private String trangThai;

    // Default constructor
    public TourDTO() {
    }

    // Full constructor
    public TourDTO(int maTour, String tenTour, String moTa, Date ngayBatDau, 
                   Date ngayKetThuc, int soNgay, int soLuongKhachToiDa, 
                   BigDecimal giaTour, String loaiTour, String trangThai) {
        this.maTour = maTour;
        this.tenTour = tenTour;
        this.moTa = moTa;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.soNgay = soNgay;
        this.soLuongKhachToiDa = soLuongKhachToiDa;
        this.giaTour = giaTour;
        this.loaiTour = loaiTour;
        this.trangThai = trangThai;
    }

    // Getters and Setters
    public int getMaTour() {
        return maTour;
    }

    public void setMaTour(int maTour) {
        this.maTour = maTour;
    }

    public String getTenTour() {
        return tenTour;
    }

    public void setTenTour(String tenTour) {
        this.tenTour = tenTour;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public Date getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public int getSoNgay() {
        return soNgay;
    }

    public void setSoNgay(int soNgay) {
        this.soNgay = soNgay;
    }

    public int getSoLuongKhachToiDa() {
        return soLuongKhachToiDa;
    }

    public void setSoLuongKhachToiDa(int soLuongKhachToiDa) {
        this.soLuongKhachToiDa = soLuongKhachToiDa;
    }

    public BigDecimal getGiaTour() {
        return giaTour;
    }

    public void setGiaTour(BigDecimal giaTour) {
        this.giaTour = giaTour;
    }

    public String getLoaiTour() {
        return loaiTour;
    }

    public void setLoaiTour(String loaiTour) {
        this.loaiTour = loaiTour;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "TourDTO{" +
                "maTour=" + maTour +
                ", tenTour='" + tenTour + '\'' +
                ", moTa='" + moTa + '\'' +
                ", ngayBatDau=" + ngayBatDau +
                ", ngayKetThuc=" + ngayKetThuc +
                ", soNgay=" + soNgay +
                ", soLuongKhachToiDa=" + soLuongKhachToiDa +
                ", giaTour=" + giaTour +
                ", loaiTour='" + loaiTour + '\'' +
                ", trangThai='" + trangThai + '\'' +
                '}';
    }

    // Mapper Inner Class
    public static class TourMapper {
        
        // Phương thức chuyển từ Entity sang DTO
        public TourDTO toDTO(Tour tour) {
            if (tour == null) {
                return null;
            }
            
            TourDTO dto = new TourDTO();
            dto.setMaTour(tour.getMaTour());
            dto.setTenTour(tour.getTenTour());
            dto.setMoTa(tour.getMoTa());
            dto.setNgayBatDau(tour.getNgayBatDau());
            dto.setNgayKetThuc(tour.getNgayKetThuc());
            dto.setSoNgay(tour.getSoNgay());
            dto.setSoLuongKhachToiDa(tour.getSoLuongKhachToiDa());
            dto.setGiaTour(tour.getGiaTour());
            dto.setLoaiTour(tour.getLoaiTour());
            dto.setTrangThai(tour.getTrangThai());
            
            return dto;
        }
        
        // Phương thức chuyển từ DTO sang Entity
        public Tour toEntity(TourDTO dto) {
            if (dto == null) {
                return null;
            }
            
            Tour tour = new Tour();
            tour.setMaTour(dto.getMaTour());
            tour.setTenTour(dto.getTenTour());
            tour.setMoTa(dto.getMoTa());
            tour.setNgayBatDau(dto.getNgayBatDau());
            tour.setNgayKetThuc(dto.getNgayKetThuc());
            tour.setSoNgay(dto.getSoNgay());
            tour.setSoLuongKhachToiDa(dto.getSoLuongKhachToiDa());
            tour.setGiaTour(dto.getGiaTour());
            tour.setLoaiTour(dto.getLoaiTour());
            tour.setTrangThai(dto.getTrangThai());
            
            return tour;
        }
    }
}