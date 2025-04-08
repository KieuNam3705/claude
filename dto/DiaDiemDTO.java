package com.tourmanagement.dto;

import com.tourmanagement.entity.DiaDiem;

public class DiaDiemDTO {
    private int maDiaDiem;
    private String tenDiaDiem;
    private String moTa;
    private String diaChi;
    private String thanhPho;
    private String quocGia;
    private String dacDiem;

   
    public DiaDiemDTO() {
    }

    public DiaDiemDTO(int maDiaDiem, String tenDiaDiem, String moTa, String diaChi, 
                      String thanhPho, String quocGia, String dacDiem) {
        this.maDiaDiem = maDiaDiem;
        this.tenDiaDiem = tenDiaDiem;
        this.moTa = moTa;
        this.diaChi = diaChi;
        this.thanhPho = thanhPho;
        this.quocGia = quocGia;
        this.dacDiem = dacDiem;
    }

   
    public int getMaDiaDiem() {
        return maDiaDiem;
    }

    public void setMaDiaDiem(int maDiaDiem) {
        this.maDiaDiem = maDiaDiem;
    }

    public String getTenDiaDiem() {
        return tenDiaDiem;
    }

    public void setTenDiaDiem(String tenDiaDiem) {
        this.tenDiaDiem = tenDiaDiem;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
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

    public String getDacDiem() {
        return dacDiem;
    }

    public void setDacDiem(String dacDiem) {
        this.dacDiem = dacDiem;
    }

 
     @Override
    public String toString() {
        return "DiaDiemDTO{" +
                "maDiaDiem=" + maDiaDiem +
                ", tenDiaDiem='" + tenDiaDiem + '\'' +
                ", moTa='" + moTa + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", thanhPho='" + thanhPho + '\'' +
                ", quocGia='" + quocGia + '\'' +
                ", dacDiem='" + dacDiem + '\'' +
                '}';
    }
    
    
    public static class DiaDiemMapper {
     public DiaDiemDTO toDTO(DiaDiem diaDiem) {
        if (diaDiem == null) {
            return null;
        }
        
        DiaDiemDTO dto = new DiaDiemDTO();
        dto.setMaDiaDiem(diaDiem.getMaDiaDiem());
        dto.setTenDiaDiem(diaDiem.getTenDiaDiem());
        dto.setMoTa(diaDiem.getMoTa());
        dto.setDiaChi(diaDiem.getDiaChi());
        dto.setThanhPho(diaDiem.getThanhPho());
        dto.setQuocGia(diaDiem.getQuocGia());
        dto.setDacDiem(diaDiem.getDacDiem());
        
        return dto;
    }

    public DiaDiem toEntity(DiaDiemDTO dto) {
        DiaDiem diaDiem = new DiaDiem();
        diaDiem.setMaDiaDiem(dto.maDiaDiem);
        diaDiem.setTenDiaDiem(dto.tenDiaDiem);
        diaDiem.setMoTa(dto.moTa);
        diaDiem.setDiaChi(dto.diaChi);
        diaDiem.setThanhPho(dto.thanhPho);
        diaDiem.setQuocGia(dto.quocGia);
        diaDiem.setDacDiem(dto.dacDiem);
        
        return diaDiem;
    }
    }
}