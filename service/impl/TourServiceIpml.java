package com.tourmanagement.service.impl;

import com.tourmanagement.dao.impl.TourDAOImpl;
import com.tourmanagement.dao.interfaces.ITourDAO;
import com.tourmanagement.dto.TourDTO; 
import com.tourmanagement.entity.Tour;
import com.tourmanagement.exception.BusinessLogicException;
import com.tourmanagement.service.interfaces.ITourService;
import java.util.Date;
import java.util.HashMap; 
import java.util.List;
import java.util.Map; 

/**
 * Triển khai các phương thức dịch vụ liên quan đến Tour
 * Bao gồm các phương thức kiểm tra và xác thực dữ liệu đầu vào
 * @author phanh
 */
public class TourServiceIpml implements ITourService {

    private final ITourDAO tourDAO;
    private final TourDTO.TourMapper tourMapper;

    public TourServiceIpml() {
        this.tourDAO = new TourDAOImpl();
        this.tourMapper = new TourDTO.TourMapper(); // Khởi tạo lại Mapper
    }

    /**
     * Kiểm tra tính hợp lệ của thông tin tour
     * @param tour đối tượng tour cần kiểm tra
     * @throws BusinessLogicException nếu dữ liệu không hợp lệ
     */
    private void validateTour(Tour tour) throws BusinessLogicException {
        // Kiểm tra tên tour
        if (tour.getTenTour() == null || tour.getTenTour().trim().isEmpty()) {
            throw new BusinessLogicException("Tên tour không được để trống.");
        }

        // Kiểm tra mô tả
        if (tour.getMoTa() == null || tour.getMoTa().trim().isEmpty()) {
            throw new BusinessLogicException("Mô tả tour không được để trống.");
        }

        // Kiểm tra ngày bắt đầu và kết thúc
        if (tour.getNgayBatDau() == null) {
            throw new BusinessLogicException("Ngày bắt đầu không được để trống.");
        }

        if (tour.getNgayKetThuc() == null) {
            throw new BusinessLogicException("Ngày kết thúc không được để trống.");
        }

        if (tour.getNgayBatDau().after(tour.getNgayKetThuc())) {
            throw new BusinessLogicException("Ngày bắt đầu không thể sau ngày kết thúc.");
        }

        // Kiểm tra số ngày
        if (tour.getSoNgay() <= 0) {
            throw new BusinessLogicException("Số ngày phải lớn hơn 0.");
        }

        // Kiểm tra số lượng khách tối đa
        if (tour.getSoLuongKhachToiDa() <= 0) {
            throw new BusinessLogicException("Số lượng khách tối đa phải lớn hơn 0.");
        }

        // Kiểm tra giá tour
        if (tour.getGiaTour() == null || tour.getGiaTour().doubleValue() <= 0) {
            throw new BusinessLogicException("Giá tour phải lớn hơn 0.");
        }

        // Kiểm tra loại tour
        if (tour.getLoaiTour() == null || tour.getLoaiTour().trim().isEmpty()) {
            throw new BusinessLogicException("Loại tour không được để trống.");
        }

        // Kiểm tra trạng thái
        if (tour.getTrangThai() == null || tour.getTrangThai().trim().isEmpty()) {
            throw new BusinessLogicException("Trạng thái tour không được để trống.");
        }
    }

    @Override
    public List<Tour> timTheoTen(String tenTour) {
        // Kiểm tra tên tour
        if (tenTour == null || tenTour.trim().isEmpty()) {
            throw new IllegalArgumentException("Tên tour không được để trống.");
        }
        return tourDAO.timTourTheoTen(tenTour);
    }

    @Override
    public List<Tour> layDanhSachTheoTrangThai(String trangThai) {
        // Kiểm tra trạng thái
        if (trangThai == null || trangThai.trim().isEmpty()) {
            throw new IllegalArgumentException("Trạng thái không được để trống.");
        }
        return tourDAO.layDanhSachTourTheoTrangThai(trangThai);
    }

    @Override
    public List<Tour> layDanhSachTheoNgay(Date ngayBatDau, Date ngayKetThuc) {
        // Kiểm tra ngày bắt đầu và kết thúc
        if (ngayBatDau == null || ngayKetThuc == null) {
            throw new IllegalArgumentException("Ngày bắt đầu và ngày kết thúc không được để trống.");
        }

        if (ngayBatDau.after(ngayKetThuc)) {
            throw new IllegalArgumentException("Ngày bắt đầu không thể sau ngày kết thúc.");
        }

        return tourDAO.layDanhSachTourTheoNgay(ngayBatDau, ngayKetThuc);
    }

    @Override
    public List<Tour> layDanhSachTheoLoai(String loaiTour) {
        // Kiểm tra loại tour
        if (loaiTour == null || loaiTour.trim().isEmpty()) {
            throw new IllegalArgumentException("Loại tour không được để trống.");
        }
        return tourDAO.layDanhSachTourTheoLoai(loaiTour);
    }

    @Override
    public boolean capNhatTrangThai(int maTour, String trangThaiMoi) {
        // Kiểm tra mã tour
        if (maTour <= 0) {
            throw new IllegalArgumentException("Mã tour không hợp lệ.");
        }

        // Kiểm tra trạng thái mới
        if (trangThaiMoi == null || trangThaiMoi.trim().isEmpty()) {
            throw new IllegalArgumentException("Trạng thái mới không được để trống.");
        }

        // Kiểm tra tour có tồn tại không
        Tour existingTour = tourDAO.timTheoMa(maTour);
        if (existingTour == null) {
            throw new IllegalArgumentException("Tour không tồn tại với mã " + maTour);
        }

        return tourDAO.capNhatTrangThaiTour(maTour, trangThaiMoi);
    }

    /**
     * Lấy chi tiết Tour và trả về dưới dạng Map chứa TourDTO.
     * @param maTour Mã tour cần lấy chi tiết.
     * @return Map chứa thông tin chi tiết Tour dưới dạng DTO nếu tìm thấy (key="tour"), ngược lại trả về null.
     * @throws IllegalArgumentException nếu mã tour không hợp lệ.
     */
    @Override
    public Map<String, Object> layChiTiet(int maTour) { // Giữ kiểu trả về là Map
        // Kiểm tra mã tour
        if (maTour <= 0) {
            throw new IllegalArgumentException("Mã tour không hợp lệ.");
        }

        Tour tour = tourDAO.timTheoMa(maTour);
        if (tour == null) {
            return null; // hoặc trả về Map rỗng tùy theo yêu cầu
        }

        // Chuyển đổi sang DTO và đưa vào Map
        Map<String, Object> chiTiet = new HashMap<>();
        TourDTO tourDTO = tourMapper.toDTO(tour); // Sử dụng mapper
        chiTiet.put("tour", tourDTO); // Đặt DTO vào Map

        return chiTiet;
    }

    @Override
    public boolean them(Tour entity) throws BusinessLogicException {
        // Kiểm tra dữ liệu đầu vào
        if (entity == null) {
            throw new BusinessLogicException("Thông tin tour không được null.");
        }

        // Validate dữ liệu Entity
        validateTour(entity);

        return tourDAO.them(entity);
    }

    @Override
    public boolean sua(Tour entity) throws BusinessLogicException {
        // Kiểm tra dữ liệu đầu vào
        if (entity == null) {
            throw new BusinessLogicException("Thông tin tour không được null.");
        }

        // Kiểm tra mã tour
        if (entity.getMaTour() <= 0) {
            throw new BusinessLogicException("Mã tour không hợp lệ.");
        }

        // Kiểm tra tour có tồn tại không
        Tour existingTour = tourDAO.timTheoMa(entity.getMaTour());
        if (existingTour == null) {
            throw new BusinessLogicException("Tour không tồn tại.");
        }

        // Validate dữ liệu Entity
        validateTour(entity);

        return tourDAO.sua(entity);
    }

    @Override
    public boolean xoa(int id) throws BusinessLogicException {
        // Kiểm tra mã tour
        if (id <= 0) {
            throw new BusinessLogicException("Mã tour không hợp lệ.");
        }

        // Kiểm tra tour có tồn tại không
        Tour existingTour = tourDAO.timTheoMa(id);
        if (existingTour == null) {
            throw new BusinessLogicException("Tour không tồn tại.");
        }

        // TODO: Kiểm tra xem tour đã có khách đăng ký chưa trước khi xóa

        return tourDAO.xoa(id);
    }

    @Override
    public Tour timTheoMa(int id) {
        // Kiểm tra mã tour
        if (id <= 0) {
            throw new IllegalArgumentException("Mã tour không hợp lệ.");
        }
        // Phương thức này trả về Entity, không cần DTO ở đây
        return tourDAO.timTheoMa(id);
    }

    @Override
    public List<Tour> layDanhSach() {
        // Phương thức này trả về List<Entity>, không cần DTO ở đây
        return tourDAO.layDanhSach();
    }
}