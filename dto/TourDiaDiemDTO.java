package com.tourmanagement.dto;

import com.tourmanagement.entity.TourDiaDiem;

public class TourDiaDiemDTO {
    private int maTour;
    private int maDiaDiem;
    private int thuTu;
    private int thoiGianLuuTru;

    public TourDiaDiemDTO() {
    }

    public TourDiaDiemDTO(int maTour, int maDiaDiem, int thuTu, int thoiGianLuuTru) {
        this.maTour = maTour;
        this.maDiaDiem = maDiaDiem;
        this.thuTu = thuTu;
        this.thoiGianLuuTru = thoiGianLuuTru;
    }

    public int getMaTour() {
        return maTour;
    }

    public int getMaDiaDiem() {
        return maDiaDiem;
    }

    public int getThuTu() {
        return thuTu;
    }

    public int getThoiGianLuuTru() {
        return thoiGianLuuTru;
    }

    public void setMaTour(int maTour) {
        this.maTour = maTour;
    }

    public void setMaDiaDiem(int maDiaDiem) {
        this.maDiaDiem = maDiaDiem;
    }

    public void setThuTu(int thuTu) {
        this.thuTu = thuTu;
    }

    public void setThoiGianLuuTru(int thoiGianLuuTru) {
        this.thoiGianLuuTru = thoiGianLuuTru;
    }

    @Override
    public String toString() {
        return "TourDiaDiemDTO{" +
                "maTour=" + maTour +
                ", maDiaDiem=" + maDiaDiem +
                ", thuTu=" + thuTu +
                ", thoiGianLuuTru=" + thoiGianLuuTru +
                '}';
    }

    public static TourDiaDiemDTO fromEntity(TourDiaDiem tourDiaDiem) {
        if (tourDiaDiem == null) {
            return null;
        }
        
        TourDiaDiemDTO dto = new TourDiaDiemDTO();
        dto.setMaTour(tourDiaDiem.getMaTour());
        dto.setMaDiaDiem(tourDiaDiem.getMaDiaDiem());
        dto.setThuTu(tourDiaDiem.getThuTu());
        dto.setThoiGianLuuTru(tourDiaDiem.getThoiGianLuuTru());
        
        return dto;
    }

    public TourDiaDiem toEntity() {
        TourDiaDiem tourDiaDiem = new TourDiaDiem();
        tourDiaDiem.setMaTour(this.maTour);
        tourDiaDiem.setMaDiaDiem(this.maDiaDiem);
        tourDiaDiem.setThuTu(this.thuTu);
        tourDiaDiem.setThoiGianLuuTru(this.thoiGianLuuTru);
        
        return tourDiaDiem;
    }
}