package com.tourmanagement.dto;

import com.tourmanagement.entity.ChoO;
import java.math.BigDecimal;

public class ChoODTO {
    private int maChoO;
    private String tenChoO;
    private String loaiChoO;
    private String diaChi;
    private String thanhPho;
    private String quocGia;
    private String soDienThoai;
    private String email;
    private String website;
    private int soSao;
    private BigDecimal giaThue;

    public ChoODTO() {}

    public ChoODTO(int maChoO, String tenChoO, String loaiChoO, String diaChi, String thanhPho, 
                   String quocGia, String soDienThoai, String email, String website, 
                   int soSao, BigDecimal giaThue) {
        this.maChoO = maChoO;
        this.tenChoO = tenChoO;
        this.loaiChoO = loaiChoO;
        this.diaChi = diaChi;
        this.thanhPho = thanhPho;
        this.quocGia = quocGia;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.website = website;
        this.soSao = soSao;
        this.giaThue = giaThue;
    }

    // Getter and Setter methods
    public int getMaChoO() {
        return maChoO;
    }

    public void setMaChoO(int maChoO) {
        this.maChoO = maChoO;
    }

    public String getTenChoO() {
        return tenChoO;
    }

    public void setTenChoO(String tenChoO) {
        this.tenChoO = tenChoO;
    }

    public String getLoaiChoO() {
        return loaiChoO;
    }

    public void setLoaiChoO(String loaiChoO) {
        this.loaiChoO = loaiChoO;
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

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public int getSoSao() {
        return soSao;
    }

    public void setSoSao(int soSao) {
        this.soSao = soSao;
    }

    public BigDecimal getGiaThue() {
        return giaThue;
    }

    public void setGiaThue(BigDecimal giaThue) {
        this.giaThue = giaThue;
    }
    
     @Override
    public String toString() {
        return "ChoODTO{" +
               "maChoO=" + maChoO +
               ", tenChoO='" + tenChoO + '\'' +
               ", loaiChoO='" + loaiChoO + '\'' +
               ", diaChi='" + diaChi + '\'' +
               ", thanhPho='" + thanhPho + '\'' +
               ", quocGia='" + quocGia + '\'' +
               ", soDienThoai='" + soDienThoai + '\'' +
               ", email='" + email + '\'' +
               ", website='" + website + '\'' +
               ", soSao=" + soSao +
               ", giaThue=" + giaThue +
               '}';
    }
    
  public static class ChoOMapper {
    
    public static ChoODTO toDTO(ChoO choO) {
        if (choO == null) {
            return null;
        }
        
        ChoODTO dto = new ChoODTO();
        dto.setMaChoO(choO.getMaChoO());
        dto.setTenChoO(choO.getTenChoO());
        dto.setLoaiChoO(choO.getLoaiChoO());
        dto.setDiaChi(choO.getDiaChi());
        dto.setThanhPho(choO.getThanhPho());
        dto.setQuocGia(choO.getQuocGia());
        dto.setSoDienThoai(choO.getSoDienThoai());
        dto.setEmail(choO.getEmail());
        dto.setWebsite(choO.getWebsite());
        dto.setSoSao(choO.getSoSao());
        dto.setGiaThue(choO.getGiaThue());
        
        return dto;
    }

    public ChoO toEntity(ChoODTO dto) {
        if (dto == null) {
                return null;
            }
        ChoO choO = new ChoO();
        choO.setMaChoO(dto.getMaChoO());
        choO.setTenChoO(dto.getTenChoO());
        choO.setLoaiChoO(dto.getLoaiChoO());
        choO.setDiaChi(dto.getDiaChi());
        choO.setThanhPho(dto.getThanhPho());
        choO.setQuocGia(dto.getQuocGia());
        choO.setSoDienThoai(dto.getSoDienThoai());
        choO.setEmail(dto.getEmail());
        choO.setWebsite(dto.getWebsite());
        choO.setSoSao(dto.getSoSao());
        choO.setGiaThue(dto.getGiaThue());
        
        return choO;
    }

    
  }

   
}