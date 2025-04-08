package com.tourmanagement.service.impl;

import com.tourmanagement.dao.impl.KhachHangDAOImpl;
import com.tourmanagement.dao.interfaces.IKhachHangDAO;
import com.tourmanagement.dto.KhachHangDTO;
import com.tourmanagement.entity.KhachHang;
import com.tourmanagement.exception.BusinessLogicException;
import com.tourmanagement.service.interfaces.IKhachHangService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Triển khai các phương thức dịch vụ liên quan đến Khách Hàng
 * Bao gồm các phương thức kiểm tra và xác thực dữ liệu đầu vào
 */
public class KhachHangServiceImpl implements IKhachHangService {
  
    private final IKhachHangDAO khachHangDAO;
    private final KhachHangDTO.KhachHangMapper khachHangMapper;

    public KhachHangServiceImpl() {
        this.khachHangDAO = new KhachHangDAOImpl();
        this.khachHangMapper = new KhachHangDTO.KhachHangMapper(); // Khởi tạo mapper
    }

    /**
     * Kiểm tra tính hợp lệ của thông tin khách hàng
     * @param khachHang đối tượng khách hàng cần kiểm tra
     * @throws BusinessLogicException nếu dữ liệu không hợp lệ
     */
    private void validateKhachHang(KhachHang khachHang) throws BusinessLogicException {
        // Kiểm tra họ tên
        if (khachHang.getHoTen() == null || khachHang.getHoTen().trim().isEmpty()) {
            throw new BusinessLogicException("Họ tên không được để trống.");
        }
        
        // Kiểm tra CMND/CCCD (9 hoặc 12 chữ số)
        if (khachHang.getCmnd() == null || 
            !Pattern.matches("^(\\d{9}|\\d{12})$", khachHang.getCmnd())) {
            throw new BusinessLogicException("CMND/CCCD phải là dãy 9 hoặc 12 chữ số.");
        }
        
        // Kiểm tra số điện thoại (10-11 chữ số, bắt đầu bằng 0)
        if (khachHang.getSoDienThoai() == null || 
            !Pattern.matches("^0\\d{9,10}$", khachHang.getSoDienThoai())) {
            throw new BusinessLogicException("Số điện thoại không hợp lệ. Phải bắt đầu bằng 0 và có 10-11 chữ số.");
        }
        
        // Kiểm tra email (nếu có)
        if (khachHang.getEmail() != null && !khachHang.getEmail().isEmpty() && 
            !Pattern.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$", khachHang.getEmail())) {
            throw new BusinessLogicException("Định dạng email không hợp lệ.");
        }
        
        // Kiểm tra ngày sinh (không được là ngày trong tương lai)
        if (khachHang.getNgaySinh() != null && 
            khachHang.getNgaySinh().after(new java.util.Date())) {
            throw new BusinessLogicException("Ngày sinh không được là ngày trong tương lai.");
        }
        
        // Kiểm tra giới tính
        if (khachHang.getGioiTinh() != null && 
            !khachHang.getGioiTinh().matches("Nam|Nữ|Khác")) {
            throw new BusinessLogicException("Giới tính không hợp lệ. Phải là Nam, Nữ hoặc Khác.");
        }
    }

    /**
     * Lấy chi tiết Khách Hàng và trả về dưới dạng Map chứa KhachHangDTO.
     * @param maKH Mã khách hàng cần lấy chi tiết.
     * @return Map chứa thông tin chi tiết Khách Hàng dưới dạng DTO nếu tìm thấy (key="khachHang"), 
     *         ngược lại trả về null.
     * @throws IllegalArgumentException nếu mã khách hàng không hợp lệ.
     */
    public Map<String, Object> layChiTiet(int maKH) {
        // Kiểm tra mã khách hàng
        if (maKH <= 0) {
            throw new IllegalArgumentException("Mã khách hàng không hợp lệ.");
        }

        KhachHang khachHang = khachHangDAO.timTheoMa(maKH);
        if (khachHang == null) {
            return null; // hoặc trả về Map rỗng tùy theo yêu cầu
        }

        // Chuyển đổi sang DTO và đưa vào Map
        Map<String, Object> chiTiet = new HashMap<>();
        KhachHangDTO khachHangDTO = khachHangMapper.toDTO(khachHang); // Sử dụng mapper
        chiTiet.put("khachHang", khachHangDTO); // Đặt DTO vào Map

        return chiTiet;
    }

    @Override
    public KhachHang timTheoCMND(String cmnd) {
        // Kiểm tra CMND/CCCD
        if (cmnd == null || !Pattern.matches("^(\\d{9}|\\d{12})$", cmnd)) {
            throw new IllegalArgumentException("CMND/CCCD không hợp lệ.");
        }
        return khachHangDAO.timKhachHangTheoCMND(cmnd);
    }

    @Override
    public List<KhachHang> timTheoTen(String hoTen) {
        // Kiểm tra tên
        if (hoTen == null || hoTen.trim().isEmpty()) {
            throw new IllegalArgumentException("Tên không được để trống.");
        }
        return khachHangDAO.timKhachHangTheoTen(hoTen);
    }

    @Override
    public List<KhachHang> timTheoSDT(String soDienThoai) {
        // Kiểm tra số điện thoại
        if (soDienThoai == null || !Pattern.matches("^0\\d{9,10}$", soDienThoai)) {
            throw new IllegalArgumentException("Số điện thoại không hợp lệ.");
        }
        return khachHangDAO.timKhachHangTheoSDT(soDienThoai);
    }

    @Override
    public List<KhachHang> layDanhSachTheoTour(int maTour) {
        // Kiểm tra mã tour
        if (maTour <= 0) {
            throw new IllegalArgumentException("Mã tour không hợp lệ.");
        }
        return khachHangDAO.layDanhSachKhachHangTheoTour(maTour);
    }

    @Override
    public boolean kiemTraCMNDTonTai(String cmnd) {
        // Kiểm tra CMND/CCCD
        if (cmnd == null || !Pattern.matches("^(\\d{9}|\\d{12})$", cmnd)) {
            throw new IllegalArgumentException("CMND/CCCD không hợp lệ.");
        }
        KhachHang khachHang = khachHangDAO.timKhachHangTheoCMND(cmnd);
        return khachHang != null;
    }

    @Override
    public boolean them(KhachHang entity) throws BusinessLogicException {
        // Kiểm tra dữ liệu đầu vào
        if (entity == null) {
            throw new BusinessLogicException("Thông tin khách hàng không được null.");
        }
        
        // Validate dữ liệu
        validateKhachHang(entity);
        
        // Kiểm tra CMND đã tồn tại
        if (kiemTraCMNDTonTai(entity.getCmnd())) {
            throw new BusinessLogicException("CMND đã tồn tại trong hệ thống.");
        }
        
        return khachHangDAO.them(entity);
    }

    @Override
    public boolean sua(KhachHang entity) throws BusinessLogicException {
        // Kiểm tra dữ liệu đầu vào
        if (entity == null) {
            throw new BusinessLogicException("Thông tin khách hàng không được null.");
        }
        
        // Kiểm tra khách hàng có tồn tại không
        KhachHang existingKhachHang = khachHangDAO.timTheoMa(entity.getMaKH());
        if (existingKhachHang == null) {
            throw new BusinessLogicException("Khách hàng không tồn tại.");
        }
        
        // Validate dữ liệu
        validateKhachHang(entity);
        
        // Kiểm tra CMND đã tồn tại ở khách hàng khác
        KhachHang khachHangCungCMND = khachHangDAO.timKhachHangTheoCMND(entity.getCmnd());
        if (khachHangCungCMND != null && khachHangCungCMND.getMaKH() != entity.getMaKH()) {
            throw new BusinessLogicException("CMND đã được sử dụng bởi khách hàng khác.");
        }
        
        return khachHangDAO.sua(entity);
    }

    @Override
    public boolean xoa(int id) throws BusinessLogicException {
        // Kiểm tra mã khách hàng
        if (id <= 0) {
            throw new IllegalArgumentException("Mã khách hàng không hợp lệ.");
        }
        
        // Kiểm tra khách hàng có tồn tại không
        KhachHang existingKhachHang = khachHangDAO.timTheoMa(id);
        if (existingKhachHang == null) {
            throw new BusinessLogicException("Khách hàng không tồn tại.");
        }
        
        return khachHangDAO.xoa(id);
    }

    @Override
    public KhachHang timTheoMa(int id) {
        // Kiểm tra mã khách hàng
        if (id <= 0) {
            throw new IllegalArgumentException("Mã khách hàng không hợp lệ.");
        }
        
        return khachHangDAO.timTheoMa(id);
    }

    @Override
    public List<KhachHang> layDanhSach() {
        return khachHangDAO.layDanhSach();
    }
}