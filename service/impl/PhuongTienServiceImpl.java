package com.tourmanagement.service.impl;

import com.tourmanagement.dao.impl.PhuongTienDAOImpl;
import com.tourmanagement.dao.interfaces.IPhuongTienDAO;
import com.tourmanagement.dto.PhuongTienDTO;
import com.tourmanagement.entity.PhuongTien;
import com.tourmanagement.exception.BusinessLogicException;
import com.tourmanagement.service.interfaces.IPhuongTienService;
import java.util.List;
import java.util.regex.Pattern;


public class PhuongTienServiceImpl implements IPhuongTienService {

    private IPhuongTienDAO phuongTienDAO;
    private final PhuongTienDTO.PhuongTienMapper phuongTienMapper;

    public PhuongTienServiceImpl() {
        this.phuongTienDAO = new PhuongTienDAOImpl();
        this.phuongTienMapper = new PhuongTienDTO.PhuongTienMapper();
    }

    private void validatePhuongTien(PhuongTien phuongTien) throws BusinessLogicException {
        if (phuongTien.getTenPhuongTien() == null || phuongTien.getTenPhuongTien().trim().isEmpty()) {
            throw new BusinessLogicException("Tên phương tiện không được để trống.");
        }

        if (phuongTien.getLoaiPhuongTien() == null || phuongTien.getLoaiPhuongTien().trim().isEmpty()) {
            throw new BusinessLogicException("Loại phương tiện không được để trống.");
        }

        if (phuongTien.getTrangThai() == null || phuongTien.getTrangThai().trim().isEmpty()) {
            throw new BusinessLogicException("Trạng thái không được để trống.");
        } else if (!phuongTien.getTrangThai().matches("Sẵn sàng|Đang sử dụng|Bảo trì|Ngưng hoạt động")) {
            throw new BusinessLogicException("Trạng thái không hợp lệ. Trạng thái phải là: Sẵn sàng, Đang sử dụng, Bảo trì hoặc Ngưng hoạt động.");
        }

        if (phuongTien.getBienSo() != null && !phuongTien.getBienSo().isEmpty() &&
            !Pattern.matches("^[0-9A-Z]{2,12}$", phuongTien.getBienSo())) {
            throw new BusinessLogicException("Biển số không hợp lệ.");
        }

        if (phuongTien.getSoChoNgoi() <= 0) {
            throw new BusinessLogicException("Sức chứa phải lớn hơn 0.");
        }
    }

    @Override
    public List<PhuongTien> timTheoTen(String tenPhuongTien) {
        if (tenPhuongTien == null || tenPhuongTien.trim().isEmpty()) {
            throw new IllegalArgumentException("Tên phương tiện không được để trống.");
        }
        return phuongTienDAO.timPhuongTienTheoTen(tenPhuongTien);
    }

    @Override
    public List<PhuongTien> layDanhSachTheoLoai(String loaiPhuongTien) {
        if (loaiPhuongTien == null || loaiPhuongTien.trim().isEmpty()) {
            throw new IllegalArgumentException("Loại phương tiện không được để trống.");
        }
        return phuongTienDAO.layDanhSachPhuongTienTheoLoai(loaiPhuongTien);
    }

    @Override
    public List<PhuongTien> layDanhSachTheoTrangThai(String trangThai) {
        if (trangThai == null || trangThai.trim().isEmpty()) {
            throw new IllegalArgumentException("Trạng thái không được để trống.");
        } else if (!trangThai.matches("Sẵn sàng|Đang sử dụng|Bảo trì|Ngưng hoạt động")) {
            throw new IllegalArgumentException("Trạng thái không hợp lệ. Trạng thái phải là: Sẵn sàng, Đang sử dụng, Bảo trì hoặc Ngưng hoạt động.");
        }
        return phuongTienDAO.layDanhSachPhuongTienTheoTrangThai(trangThai);
    }

    @Override
    public List<PhuongTien> layDanhSachTheoTour(int maTour) {
        if (maTour <= 0) {
            throw new IllegalArgumentException("Mã tour không hợp lệ.");
        }
        return phuongTienDAO.layDanhSachPhuongTienTheoTour(maTour);
    }

    @Override
    public boolean capNhatTrangThai(int maPhuongTien, String trangThaiMoi) {
        if (maPhuongTien <= 0) {
            throw new IllegalArgumentException("Mã phương tiện không hợp lệ.");
        }

        if (trangThaiMoi == null || trangThaiMoi.trim().isEmpty()) {
            throw new IllegalArgumentException("Trạng thái mới không được để trống.");
        } else if (!trangThaiMoi.matches("Sẵn sàng|Đang sử dụng|Bảo trì|Ngưng hoạt động")) {
            throw new IllegalArgumentException("Trạng thái không hợp lệ. Trạng thái phải là: Sẵn sàng, Đang sử dụng, Bảo trì hoặc Ngưng hoạt động.");
        }

        PhuongTien existingPhuongTien = phuongTienDAO.timTheoMa(maPhuongTien);
        if (existingPhuongTien == null) {
            throw new IllegalArgumentException("Phương tiện không tồn tại.");
        }

        existingPhuongTien.setTrangThai(trangThaiMoi);
        try {
            return phuongTienDAO.sua(existingPhuongTien);
        } catch (Exception e) {
            throw new BusinessLogicException("Lỗi khi cập nhật trạng thái phương tiện: " + e.getMessage());
        }
    }

    @Override
    public boolean them(PhuongTien entity) throws BusinessLogicException {
        if (entity == null) {
            throw new BusinessLogicException("Thông tin phương tiện không được null.");
        }

        validatePhuongTien(entity);

        return phuongTienDAO.them(entity);
    }

    @Override
    public boolean sua(PhuongTien entity) throws BusinessLogicException {
        if (entity == null) {
            throw new BusinessLogicException("Thông tin phương tiện không được null.");
        }
         if (entity.getMaPhuongTien() <= 0) {
             throw new BusinessLogicException("Mã phương tiện không hợp lệ để sửa.");
         }


        PhuongTien existingPhuongTien = phuongTienDAO.timTheoMa(entity.getMaPhuongTien());
        if (existingPhuongTien == null) {
            throw new BusinessLogicException("Phương tiện không tồn tại.");
        }

        validatePhuongTien(entity);


        return phuongTienDAO.sua(entity);
    }

    @Override
    public boolean xoa(int id) throws BusinessLogicException {
        if (id <= 0) {
            throw new IllegalArgumentException("Mã phương tiện không hợp lệ.");
        }

        PhuongTien existingPhuongTien = phuongTienDAO.timTheoMa(id);
        if (existingPhuongTien == null) {
            throw new BusinessLogicException("Phương tiện không tồn tại.");
        }

        if ("Đang sử dụng".equals(existingPhuongTien.getTrangThai())) {
            throw new BusinessLogicException("Không thể xóa phương tiện đang được sử dụng.");
        }

        return phuongTienDAO.xoa(id);
    }

    @Override
    public PhuongTien timTheoMa(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("Mã phương tiện không hợp lệ.");
        }

        return phuongTienDAO.timTheoMa(id);
    }

    @Override
    public List<PhuongTien> layDanhSach() {
        return phuongTienDAO.layDanhSach();
    }
}