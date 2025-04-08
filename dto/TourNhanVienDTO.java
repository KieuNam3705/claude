package com.tourmanagement.dto;

import com.tourmanagement.entity.TourNhanVien;

public class TourNhanVienDTO {
    private int maTour;
    private int maNV;
    private String vaiTro;

    public TourNhanVienDTO() {
    }

    public TourNhanVienDTO(int maTour, int maNV, String vaiTro) {
        this.maTour = maTour;
        this.maNV = maNV;
        this.vaiTro = vaiTro;
    }

    public int getMaTour() {
        return maTour;
    }

    public int getMaNV() {
        return maNV;
    }

    public String getVaiTro() {
        return vaiTro;
    }

    public void setMaTour(int maTour) {
        this.maTour = maTour;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public void setVaiTro(String vaiTro) {
        this.vaiTro = vaiTro;
    }

    @Override
    public String toString() {
        return "TourNhanVienDTO{" +
                "maTour=" + maTour +
                ", maNV=" + maNV +
                ", vaiTro='" + vaiTro + '\'' +
                '}';
    }

    public static TourNhanVienDTO fromEntity(TourNhanVien tourNhanVien) {
        if (tourNhanVien == null) {
            return null;
        }
        
        TourNhanVienDTO dto = new TourNhanVienDTO();
        dto.setMaTour(tourNhanVien.getMaTour());
        dto.setMaNV(tourNhanVien.getMaNV());
        dto.setVaiTro(tourNhanVien.getVaiTro());
        
        return dto;
    }

    public TourNhanVien toEntity() {
        TourNhanVien tourNhanVien = new TourNhanVien();
        tourNhanVien.setMaTour(this.maTour);
        tourNhanVien.setMaNV(this.maNV);
        tourNhanVien.setVaiTro(this.vaiTro);
        
        return tourNhanVien;
    }
}