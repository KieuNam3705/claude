package com.tourmanagement.service.impl;

import com.tourmanagement.dao.impl.DatTourDAOImpl;
import com.tourmanagement.dao.interfaces.IDatTourDAO;
import com.tourmanagement.dto.DatTourDTO;
import com.tourmanagement.entity.DatTour;
import com.tourmanagement.dao.interfaces.ITourDAO;
import com.tourmanagement.dao.impl.TourDAOImpl;
import com.tourmanagement.entity.Tour;
import com.tourmanagement.exception.BusinessLogicException;
import com.tourmanagement.service.interfaces.IDatTourService;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class DatTourServiceImpl implements IDatTourService {

    private final IDatTourDAO datTourDAO;
    private final DatTourDTO.DatTourMapper datTourMapper;
    private final ITourDAO tourDAO;

    private static final Set<String> VALID_STATUSES = new HashSet<>(Arrays.asList(
        "Chờ xác nhận", "Đã xác nhận", "Đã hủy", "Hoàn thành", "Đang diễn ra"
    ));

    private static final Set<String> ACTIVE_BOOKING_STATUSES = new HashSet<>(Arrays.asList(
        "Đã xác nhận", "Đang diễn ra"
    ));


    public DatTourServiceImpl() {
        this.datTourDAO = new DatTourDAOImpl();
        this.datTourMapper = new DatTourDTO.DatTourMapper();
        this.tourDAO = new TourDAOImpl();
    }

    private void validateDatTour(DatTour datTour, boolean isUpdate) throws BusinessLogicException {
        if (datTour == null) {
            throw new BusinessLogicException("Thông tin đặt tour không được null.");
        }
         if (isUpdate && datTour.getMaDatTour() <= 0) {
             throw new BusinessLogicException("Mã đặt tour không hợp lệ để sửa.");
         }
        if (datTour.getMaKH() <= 0) {
            throw new BusinessLogicException("Mã khách hàng không hợp lệ.");
        }
        if (datTour.getMaTour() <= 0) {
            throw new BusinessLogicException("Mã tour không hợp lệ.");
        }
        if (datTour.getNgayDat() == null) {
            throw new BusinessLogicException("Ngày đặt không được để trống.");
        }
        if (datTour.getSoLuongNguoi() <= 0) {
            throw new BusinessLogicException("Số lượng người phải lớn hơn 0.");
        }
        if (datTour.getTongTien() == null || datTour.getTongTien().doubleValue() < 0) {
            throw new BusinessLogicException("Tổng tiền không hợp lệ (phải >= 0).");
        }
        if (datTour.getTrangThai() == null || datTour.getTrangThai().trim().isEmpty()) {
            throw new BusinessLogicException("Trạng thái không được để trống.");
        } else if (!VALID_STATUSES.contains(datTour.getTrangThai())) {
             throw new BusinessLogicException("Trạng thái không hợp lệ: '" + datTour.getTrangThai() +
                                             "'. Các trạng thái hợp lệ là: " + String.join(", ", VALID_STATUSES));
        }
        if (datTour.getMaNV() <= 0) {
             throw new BusinessLogicException("Mã nhân viên xử lý không hợp lệ.");
        }

        Tour tour = tourDAO.timTheoMa(datTour.getMaTour());
        if (tour == null) {
            throw new BusinessLogicException("Tour với mã " + datTour.getMaTour() + " không tồn tại.");
        }

        if (ACTIVE_BOOKING_STATUSES.contains(datTour.getTrangThai())) {
             // Cần phương thức: int tinhTongSoNguoiDaDatChoTour(int maTour, int maDatTourExclude) trong IDatTourDAO
             int currentBookedCount = datTourDAO.tinhTongSoNguoiDaDatChoTour(datTour.getMaTour(), isUpdate ? datTour.getMaDatTour() : 0);

             if (currentBookedCount + datTour.getSoLuongNguoi() > tour.getSoLuongKhachToiDa()) {
                 int availableSlots = tour.getSoLuongKhachToiDa() - currentBookedCount;
                 if (availableSlots < 0) availableSlots = 0;
                 throw new BusinessLogicException("Số lượng người (" + datTour.getSoLuongNguoi() +
                                                 ") vượt quá số chỗ còn lại (" + availableSlots +
                                                 ") của tour (Tối đa: " + tour.getSoLuongKhachToiDa() + ").");
             }
        }

    }


    @Override
    public List<DatTour> layDanhSachTheoKhachHang(int maKH) {
         if (maKH <= 0) {
            throw new IllegalArgumentException("Mã khách hàng không hợp lệ.");
        }
        return datTourDAO.layDanhSachDatTourTheoKhachHang(maKH);
    }

    @Override
    public List<DatTour> layDanhSachTheoTour(int maTour) {
         if (maTour <= 0) {
            throw new IllegalArgumentException("Mã tour không hợp lệ.");
        }
        return datTourDAO.layDanhSachDatTourTheoTour(maTour);
    }

    @Override
    public List<DatTour> layDanhSachTheoTrangThai(String trangThai) {
         if (trangThai == null || trangThai.trim().isEmpty()) {
            throw new IllegalArgumentException("Trạng thái không được để trống khi tìm kiếm.");
        } else if (!VALID_STATUSES.contains(trangThai)) {
             throw new IllegalArgumentException("Trạng thái tìm kiếm không hợp lệ: '" + trangThai + "'.");
        }
        return datTourDAO.layDanhSachDatTourTheoTrangThai(trangThai);
    }

    @Override
    public List<DatTour> layDanhSachTheoNhanVien(int maNV) {
         if (maNV <= 0) {
            throw new IllegalArgumentException("Mã nhân viên không hợp lệ.");
        }
        return datTourDAO.layDanhSachDatTourTheoNhanVien(maNV);
    }

    @Override
    public boolean capNhatTrangThai(int maDatTour, String trangThaiMoi) {
         if (maDatTour <= 0) {
            throw new IllegalArgumentException("Mã đặt tour không hợp lệ.");
        }
        if (trangThaiMoi == null || trangThaiMoi.trim().isEmpty()) {
            throw new IllegalArgumentException("Trạng thái mới không được để trống.");
        } else if (!VALID_STATUSES.contains(trangThaiMoi)) {
             throw new IllegalArgumentException("Trạng thái mới không hợp lệ: '" + trangThaiMoi + "'.");
        }

        DatTour existingDatTour = datTourDAO.timTheoMa(maDatTour);
        if (existingDatTour == null) {
            throw new BusinessLogicException("Đặt tour với mã " + maDatTour + " không tồn tại.");
        }

        if (!ACTIVE_BOOKING_STATUSES.contains(existingDatTour.getTrangThai()) && ACTIVE_BOOKING_STATUSES.contains(trangThaiMoi)) {
             Tour tour = tourDAO.timTheoMa(existingDatTour.getMaTour());
             if (tour == null) {
                 throw new BusinessLogicException("Tour liên quan với mã " + existingDatTour.getMaTour() + " không tồn tại.");
             }
              // Cần phương thức: int tinhTongSoNguoiDaDatChoTour(int maTour, int maDatTourExclude) trong IDatTourDAO
             int currentBookedCount = datTourDAO.tinhTongSoNguoiDaDatChoTour(existingDatTour.getMaTour(), maDatTour);
             if (currentBookedCount + existingDatTour.getSoLuongNguoi() > tour.getSoLuongKhachToiDa()) {
                  int availableSlots = tour.getSoLuongKhachToiDa() - currentBookedCount;
                  if (availableSlots < 0) availableSlots = 0;
                 throw new BusinessLogicException("Không thể cập nhật trạng thái thành '" + trangThaiMoi +
                                                  "' vì sẽ vượt quá số chỗ còn lại (" + availableSlots + ") của tour.");
             }
        }


        try {
             return datTourDAO.capNhatTrangThaiDatTour(maDatTour, trangThaiMoi);
         } catch (Exception e) {
             throw new BusinessLogicException("Lỗi khi cập nhật trạng thái đặt tour: " + e.getMessage());
         }
    }

    @Override
    public boolean them(DatTour entity) throws BusinessLogicException {
        validateDatTour(entity, false);

        entity.setMaDatTour(0);
        return datTourDAO.them(entity);
    }

    @Override
    public boolean sua(DatTour entity) throws BusinessLogicException {
         DatTour existingDatTour = datTourDAO.timTheoMa(entity.getMaDatTour());
         if (existingDatTour == null) {
             throw new BusinessLogicException("Đặt tour với mã " + entity.getMaDatTour() + " không tồn tại.");
         }

         validateDatTour(entity, true);

        return datTourDAO.sua(entity);
    }

    @Override
    public boolean xoa(int id) throws BusinessLogicException {
         if (id <= 0) {
            throw new IllegalArgumentException("Mã đặt tour không hợp lệ.");
        }
        DatTour existingDatTour = datTourDAO.timTheoMa(id);
        if (existingDatTour == null) {
            throw new BusinessLogicException("Đặt tour không tồn tại để xóa.");
        }

        if (ACTIVE_BOOKING_STATUSES.contains(existingDatTour.getTrangThai())) {
             throw new BusinessLogicException("Không thể xóa đặt tour đang ở trạng thái '" + existingDatTour.getTrangThai() + "'.");
         }

        return datTourDAO.xoa(id);
    }

    @Override
    public DatTour timTheoMa(int id) {
         if (id <= 0) {
            throw new IllegalArgumentException("Mã đặt tour không hợp lệ.");
        }
        return datTourDAO.timTheoMa(id);
    }

    @Override
    public List<DatTour> layDanhSach() {
        return datTourDAO.layDanhSach();
    }

}