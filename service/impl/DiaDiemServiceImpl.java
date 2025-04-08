package com.tourmanagement.service.impl;

import com.tourmanagement.dao.impl.DiaDiemDAOImpl;
import com.tourmanagement.dao.interfaces.IDiaDiemDAO;
import com.tourmanagement.dto.DiaDiemDTO;
import com.tourmanagement.entity.DiaDiem;
import com.tourmanagement.exception.BusinessLogicException;
import com.tourmanagement.service.interfaces.IDiaDiemService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Triển khai các phương thức dịch vụ liên quan đến DiaDiem
 * Bao gồm các phương thức kiểm tra và xác thực dữ liệu đầu vào
 * @author phanh
 */
public class DiaDiemServiceImpl implements IDiaDiemService {

    private final IDiaDiemDAO diaDiemDAO;
    private final DiaDiemDTO.DiaDiemMapper diaDiemMapper; // Assuming DiaDiemMapper is an inner class in DiaDiemDTO

    public DiaDiemServiceImpl() {
        this.diaDiemDAO = new DiaDiemDAOImpl();
        this.diaDiemMapper = new DiaDiemDTO.DiaDiemMapper(); // Initialize the mapper
    }
    
    /**
     * Kiểm tra tính hợp lệ của thông tin địa điểm
     * @param diaDiem đối tượng địa điểm cần kiểm tra
     * @throws BusinessLogicException nếu dữ liệu không hợp lệ
     */
    private void validateDiaDiem(DiaDiem diaDiem) throws BusinessLogicException {
        // Kiểm tra tên địa điểm
        if (diaDiem.getTenDiaDiem() == null || diaDiem.getTenDiaDiem().trim().isEmpty()) {
            throw new BusinessLogicException("Tên địa điểm không được để trống.");
        }

        // Kiểm tra mô tả
        if (diaDiem.getMoTa() == null || diaDiem.getMoTa().trim().isEmpty()) {
            throw new BusinessLogicException("Mô tả địa điểm không được để trống.");
        }

        // Kiểm tra địa chỉ
        if (diaDiem.getDiaChi() == null || diaDiem.getDiaChi().trim().isEmpty()) {
            throw new BusinessLogicException("Địa chỉ không được để trống.");
        }

        // Kiểm tra thành phố
        if (diaDiem.getThanhPho() == null || diaDiem.getThanhPho().trim().isEmpty()) {
            throw new BusinessLogicException("Thành phố không được để trống.");
        }

        // Kiểm tra quốc gia
        if (diaDiem.getQuocGia() == null || diaDiem.getQuocGia().trim().isEmpty()) {
            throw new BusinessLogicException("Quốc gia không được để trống.");
        }
    }

    @Override
    public List<DiaDiem> timTheoTen(String tenDiaDiem) {
        // Kiểm tra tên địa điểm
        if (tenDiaDiem == null || tenDiaDiem.trim().isEmpty()) {
            throw new IllegalArgumentException("Tên địa điểm không được để trống.");
        }
        return diaDiemDAO.timDiaDiemTheoTen(tenDiaDiem);
    }

    @Override
    public List<DiaDiem> layDanhSachTheoThanhPho(String thanhPho) {
        // Kiểm tra thành phố
        if (thanhPho == null || thanhPho.trim().isEmpty()) {
            throw new IllegalArgumentException("Tên thành phố không được để trống.");
        }
        return diaDiemDAO.layDanhSachDiaDiemTheoThanhPho(thanhPho);
    }

    @Override
    public List<DiaDiem> layDanhSachTheoQuocGia(String quocGia) {
        // Kiểm tra quốc gia
        if (quocGia == null || quocGia.trim().isEmpty()) {
            throw new IllegalArgumentException("Tên quốc gia không được để trống.");
        }
        return diaDiemDAO.layDanhSachDiaDiemTheoQuocGia(quocGia);
    }

    @Override
    public List<DiaDiem> layDanhSachTheoTour(int maTour) {
        // Kiểm tra mã tour
        if (maTour <= 0) {
            throw new IllegalArgumentException("Mã tour không hợp lệ.");
        }
        return diaDiemDAO.layDanhSachDiaDiemTheoTour(maTour);
    }
    
    /**
     * Lấy chi tiết Địa Điểm và trả về dưới dạng Map chứa DiaDiemDTO.
     * @param maDiaDiem Mã địa điểm cần lấy chi tiết.
     * @return Map chứa thông tin chi tiết Địa Điểm dưới dạng DTO nếu tìm thấy (key="diaDiem"), ngược lại trả về null.
     * @throws IllegalArgumentException nếu mã địa điểm không hợp lệ.
     */
    public Map<String, Object> layChiTiet(int maDiaDiem) {
        // Kiểm tra mã địa điểm
        if (maDiaDiem <= 0) {
            throw new IllegalArgumentException("Mã địa điểm không hợp lệ.");
        }

        DiaDiem diaDiem = diaDiemDAO.timTheoMa(maDiaDiem);
        if (diaDiem == null) {
            return null;
        }

        // Chuyển đổi sang DTO và đưa vào Map
        Map<String, Object> chiTiet = new HashMap<>();
        DiaDiemDTO diaDiemDTO = diaDiemMapper.toDTO(diaDiem); // Use the mapper to convert
        chiTiet.put("diaDiem", diaDiemDTO);

        return chiTiet;
    }

    @Override
    public boolean them(DiaDiem entity) throws BusinessLogicException {
        // Kiểm tra dữ liệu đầu vào
        if (entity == null) {
            throw new BusinessLogicException("Thông tin địa điểm không được null.");
        }

        // Validate dữ liệu Entity
        validateDiaDiem(entity);

        return diaDiemDAO.them(entity);
    }

    @Override
    public boolean sua(DiaDiem entity) throws BusinessLogicException {
        // Kiểm tra dữ liệu đầu vào
        if (entity == null) {
            throw new BusinessLogicException("Thông tin địa điểm không được null.");
        }

        // Kiểm tra mã địa điểm
        if (entity.getMaDiaDiem() <= 0) {
            throw new BusinessLogicException("Mã địa điểm không hợp lệ.");
        }

        // Kiểm tra địa điểm có tồn tại không
        DiaDiem existingDiaDiem = diaDiemDAO.timTheoMa(entity.getMaDiaDiem());
        if (existingDiaDiem == null) {
            throw new BusinessLogicException("Địa điểm không tồn tại.");
        }

        // Validate dữ liệu Entity
        validateDiaDiem(entity);

        return diaDiemDAO.sua(entity);
    }

    @Override
    public boolean xoa(int id) throws BusinessLogicException {
        // Kiểm tra mã địa điểm
        if (id <= 0) {
            throw new BusinessLogicException("Mã địa điểm không hợp lệ.");
        }

        // Kiểm tra địa điểm có tồn tại không
        DiaDiem existingDiaDiem = diaDiemDAO.timTheoMa(id);
        if (existingDiaDiem == null) {
            throw new BusinessLogicException("Địa điểm không tồn tại.");
        }

        // TODO: Kiểm tra xem địa điểm có đang được sử dụng trong lịch trình tour nào không trước khi xóa

        return diaDiemDAO.xoa(id);
    }

    @Override
    public DiaDiem timTheoMa(int id) {
        // Kiểm tra mã địa điểm
        if (id <= 0) {
            throw new IllegalArgumentException("Mã địa điểm không hợp lệ.");
        }
        return diaDiemDAO.timTheoMa(id);
    }

    @Override
    public List<DiaDiem> layDanhSach() {
        return diaDiemDAO.layDanhSach();
    }
    
    /**
     * Chuyển đổi danh sách entities thành danh sách DTOs
     * @param entities danh sách entities cần chuyển đổi
     * @return danh sách DTOs tương ứng
     */
    public List<DiaDiemDTO> chuyenSangDanhSachDTO(List<DiaDiem> entities) {
        List<DiaDiemDTO> dtos = new ArrayList<>();
        for (DiaDiem entity : entities) {
            dtos.add(diaDiemMapper.toDTO(entity));
        }
        return dtos;
    }
}