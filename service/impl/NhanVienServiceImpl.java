package com.tourmanagement.service.impl;
import com.tourmanagement.dao.impl.NhanVienDAOImpl;
import com.tourmanagement.dao.interfaces.INhanVienDAO;
import com.tourmanagement.dto.NhanVienDTO;
import com.tourmanagement.entity.NhanVien;
import com.tourmanagement.exception.BusinessLogicException;
import com.tourmanagement.service.interfaces.INhanVienService;
import java.util.List;
import java.util.regex.Pattern;


public class NhanVienServiceImpl implements INhanVienService {

    private final INhanVienDAO nhanVienDAO;
    private final NhanVienDTO.NhanVienMapper nhanVienMapper;

    public NhanVienServiceImpl() {
        this.nhanVienDAO = new NhanVienDAOImpl();
        this.nhanVienMapper = new NhanVienDTO.NhanVienMapper();
    }

    private void validateNhanVien(NhanVien nhanVien) throws BusinessLogicException {
        if (nhanVien.getHoTen() == null || nhanVien.getHoTen().trim().isEmpty()) {
            throw new BusinessLogicException("Họ tên không được để trống.");
        }

        if (nhanVien.getCmnd() == null ||
            !Pattern.matches("^(\\d{9}|\\d{12})$", nhanVien.getCmnd())) {
            throw new BusinessLogicException("CMND/CCCD phải là dãy 9 hoặc 12 chữ số.");
        }

        if (nhanVien.getSoDienThoai() == null ||
            !Pattern.matches("^0\\d{9,10}$", nhanVien.getSoDienThoai())) {
            throw new BusinessLogicException("Số điện thoại không hợp lệ. Phải bắt đầu bằng 0 và có 10-11 chữ số.");
        }

        if (nhanVien.getEmail() != null && !nhanVien.getEmail().isEmpty() &&
            !Pattern.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$", nhanVien.getEmail())) {
            throw new BusinessLogicException("Định dạng email không hợp lệ.");
        }

        if (nhanVien.getNgaySinh() != null &&
            nhanVien.getNgaySinh().after(new java.util.Date())) {
            throw new BusinessLogicException("Ngày sinh không được là ngày trong tương lai.");
        }

        if (nhanVien.getGioiTinh() != null &&
            !nhanVien.getGioiTinh().matches("Nam|Nữ|Khác")) {
            throw new BusinessLogicException("Giới tính không hợp lệ. Phải là Nam, Nữ hoặc Khác.");
        }

        if (nhanVien.getChucVu() == null || nhanVien.getChucVu().trim().isEmpty()) {
            throw new BusinessLogicException("Chức vụ không được để trống.");
        }
    }

    @Override
    public NhanVien timTheoCMND(String cmnd) {
        if (cmnd == null || !Pattern.matches("^(\\d{9}|\\d{12})$", cmnd)) {
            throw new IllegalArgumentException("CMND/CCCD không hợp lệ.");
        }
        return nhanVienDAO.timNhanVienTheoCMND(cmnd);
    }

    @Override
    public List<NhanVien> timTheoTen(String hoTen) {
        if (hoTen == null || hoTen.trim().isEmpty()) {
            throw new IllegalArgumentException("Tên không được để trống.");
        }
        return nhanVienDAO.timNhanVienTheoTen(hoTen);
    }

    @Override
    public List<NhanVien> layDanhSachTheoChucVu(String chucVu) {
        if (chucVu == null || chucVu.trim().isEmpty()) {
            throw new IllegalArgumentException("Chức vụ không được để trống.");
        }
        return nhanVienDAO.layDanhSachNhanVienTheoChucVu(chucVu);
    }

    @Override
    public List<NhanVien> layDanhSachHuongDanVien() {
        return nhanVienDAO.layDanhSachHuongDanVien();
    }

    @Override
    public List<NhanVien> layDanhSachTheoTour(int maTour) {
        if (maTour <= 0) {
            throw new IllegalArgumentException("Mã tour không hợp lệ.");
        }
        return nhanVienDAO.layDanhSachNhanVienTheoTour(maTour);
    }

    public boolean kiemTraCMNDTonTai(String cmnd) {
        if (cmnd == null || !Pattern.matches("^(\\d{9}|\\d{12})$", cmnd)) {
            throw new IllegalArgumentException("CMND/CCCD không hợp lệ.");
        }
        NhanVien nhanVien = nhanVienDAO.timNhanVienTheoCMND(cmnd);
        return nhanVien != null;
    }

    @Override
    public boolean them(NhanVien entity) throws BusinessLogicException {
        if (entity == null) {
            throw new BusinessLogicException("Thông tin nhân viên không được null.");
        }

        validateNhanVien(entity);

        if (kiemTraCMNDTonTai(entity.getCmnd())) {
            throw new BusinessLogicException("CMND đã tồn tại trong hệ thống.");
        }

        return nhanVienDAO.them(entity);
    }

    @Override
    public boolean sua(NhanVien entity) throws BusinessLogicException {
        if (entity == null) {
            throw new BusinessLogicException("Thông tin nhân viên không được null.");
        }

        NhanVien existingNhanVien = nhanVienDAO.timTheoMa(entity.getMaNV());
        if (existingNhanVien == null) {
            throw new BusinessLogicException("Nhân viên không tồn tại.");
        }

        validateNhanVien(entity);

        NhanVien nhanVienCungCMND = nhanVienDAO.timNhanVienTheoCMND(entity.getCmnd());
        if (nhanVienCungCMND != null && nhanVienCungCMND.getMaNV() != entity.getMaNV()) {
            throw new BusinessLogicException("CMND đã được sử dụng bởi nhân viên khác.");
        }

        return nhanVienDAO.sua(entity);
    }

    @Override
    public boolean xoa(int id) throws BusinessLogicException {
        if (id <= 0) {
            throw new IllegalArgumentException("Mã nhân viên không hợp lệ.");
        }

        NhanVien existingNhanVien = nhanVienDAO.timTheoMa(id);
        if (existingNhanVien == null) {
            throw new BusinessLogicException("Nhân viên không tồn tại.");
        }

        return nhanVienDAO.xoa(id);
    }

    @Override
    public NhanVien timTheoMa(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("Mã nhân viên không hợp lệ.");
        }

        return nhanVienDAO.timTheoMa(id);
    }

    @Override
    public List<NhanVien> layDanhSach() {
        return nhanVienDAO.layDanhSach();
    }

}