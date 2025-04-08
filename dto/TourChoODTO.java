package com.tourmanagement.dto;

import com.tourmanagement.entity.TourChoO;

public class TourChoODTO {
    private int maTour;
    private int maChoO;
    private String ngayNhanPhong;
    private String ngayTraPhong;
    private int soPhong;
    private String ghiChu;
    private String loaiPhong;

   
    public TourChoODTO() {
    }

   
    public TourChoODTO(int maTour, int maChoO, String ngayNhanPhong, 
                       String ngayTraPhong, int soPhong, String ghiChu, 
                       String loaiPhong) {
        this.maTour = maTour;
        this.maChoO = maChoO;
        this.ngayNhanPhong = ngayNhanPhong;
        this.ngayTraPhong = ngayTraPhong;
        this.soPhong = soPhong;
        this.ghiChu = ghiChu;
        this.loaiPhong = loaiPhong;
    }

  
    public int getMaTour() {
        return maTour;
    }

    public int getMaChoO() {
        return maChoO;
    }

    public String getNgayNhanPhong() {
        return ngayNhanPhong;
    }

    public String getNgayTraPhong() {
        return ngayTraPhong;
    }

    public int getSoPhong() {
        return soPhong;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public String getLoaiPhong() {
        return loaiPhong;
    }

  
    public void setMaTour(int maTour) {
        this.maTour = maTour;
    }

    public void setMaChoO(int maChoO) {
        this.maChoO = maChoO;
    }

    public void setNgayNhanPhong(String ngayNhanPhong) {
        this.ngayNhanPhong = ngayNhanPhong;
    }

    public void setNgayTraPhong(String ngayTraPhong) {
        this.ngayTraPhong = ngayTraPhong;
    }

    public void setSoPhong(int soPhong) {
        this.soPhong = soPhong;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public void setLoaiPhong(String loaiPhong) {
        this.loaiPhong = loaiPhong;
    }

    
    @Override
    public String toString() {
        return "TourChoODTO{" +
                "maTour=" + maTour +
                ", maChoO=" + maChoO +
                ", ngayNhanPhong='" + ngayNhanPhong + '\'' +
                ", ngayTraPhong='" + ngayTraPhong + '\'' +
                ", soPhong=" + soPhong +
                ", ghiChu='" + ghiChu + '\'' +
                ", loaiPhong='" + loaiPhong + '\'' +
                '}';
    }

  
    public static TourChoODTO fromEntity(TourChoO tourChoO) {
        if (tourChoO == null) {
            return null;
        }
        
        TourChoODTO dto = new TourChoODTO();
        dto.setMaTour(tourChoO.getMaTour());
        dto.setMaChoO(tourChoO.getMaChoO());
        dto.setNgayNhanPhong(tourChoO.getNgayNhanPhong());
        dto.setNgayTraPhong(tourChoO.getNgayTraPhong());
        dto.setSoPhong(tourChoO.getSoPhong());
        dto.setGhiChu(tourChoO.getGhiChu());
        dto.setLoaiPhong(tourChoO.getLoaiPhong());
        
        return dto;
    }

   
    public TourChoO toEntity() {
        TourChoO tourChoO = new TourChoO();
        tourChoO.setMaTour(this.maTour);
        tourChoO.setMaChoO(this.maChoO);
        tourChoO.setNgayNhanPhong(this.ngayNhanPhong);
        tourChoO.setNgayTraPhong(this.ngayTraPhong);
        tourChoO.setSoPhong(this.soPhong);
        tourChoO.setGhiChu(this.ghiChu);
        tourChoO.setLoaiPhong(this.loaiPhong);
        
        return tourChoO;
    }
}