package com.tourmanagement.service.impl;

import com.tourmanagement.dao.impl.TourChoODAOImpl;
import com.tourmanagement.dao.impl.TourDiaDiemDAOImpl;
import com.tourmanagement.dao.impl.TourNhanVienDAOImpl;
import com.tourmanagement.dao.impl.TourPhuongTienDAOImpl;
import com.tourmanagement.entity.TourChoO;
import com.tourmanagement.entity.TourDiaDiem;
import com.tourmanagement.entity.TourNhanVien;
import com.tourmanagement.entity.TourPhuongTien;
import com.tourmanagement.service.interfaces.IQuanLyLichTrinhService;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap; 
import java.util.List;
import java.util.Map;


public class QuanLyLichTrinhServiceImpl implements IQuanLyLichTrinhService {

    // Nên sử dụng Interface DAO: private final ITourDiaDiemDAO tourDiaDiemDAO;
    private final TourDiaDiemDAOImpl tourDiaDiemDAO;
    private final TourPhuongTienDAOImpl tourPhuongTienDAO;
    private final TourChoODAOImpl tourChoODAO;
    private final TourNhanVienDAOImpl tourNhanVienDAO;
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // Format cho TourChoO

    public QuanLyLichTrinhServiceImpl() {
        // Nên khởi tạo qua Interface DAO và Dependency Injection nếu có thể
        this.tourDiaDiemDAO = new TourDiaDiemDAOImpl();
        this.tourPhuongTienDAO = new TourPhuongTienDAOImpl();
        this.tourChoODAO = new TourChoODAOImpl();
        this.tourNhanVienDAO = new TourNhanVienDAOImpl();
    }

    //<editor-fold defaultstate="collapsed" desc="Quản lý Điểm Đến">
    @Override
    public boolean capNhatDiemDen(int maTour, int maDiaDiem, int thuTu, int thoiGianLuuTru) {
        if (maTour <= 0 || maDiaDiem <= 0 || thuTu <= 0 || thoiGianLuuTru < 0) {
            // Có thể ném IllegalArgumentException thay vì trả về false
             System.err.println("Thông tin cập nhật điểm đến không hợp lệ.");
            return false;
        }

        TourDiaDiem existing = tourDiaDiemDAO.timTourDiaDiem(maTour, maDiaDiem);
        TourDiaDiem tourDiaDiem = new TourDiaDiem(maTour, maDiaDiem, thuTu, thoiGianLuuTru);

        try {
            if (existing != null) {
                // Đã tồn tại -> Sửa
                return tourDiaDiemDAO.sua(tourDiaDiem);
            } else {
                // Chưa tồn tại -> Thêm
                return tourDiaDiemDAO.them(tourDiaDiem);
            }
        } catch (Exception e) {
             System.err.println("Lỗi khi cập nhật điểm đến: " + e.getMessage());
            e.printStackTrace(); // Log lỗi
            return false;
        }
    }

    @Override
    public boolean xoaDiemDen(int maTour, int maDiaDiem) {
         if (maTour <= 0 || maDiaDiem <= 0) {
             System.err.println("Mã tour hoặc mã địa điểm không hợp lệ để xóa.");
             return false;
         }
        try {
            // Đảm bảo phương thức xoaTheoMaTourVaMaDiaDiem tồn tại trong TourDiaDiemDAOImpl
            return tourDiaDiemDAO.xoaTheoMaTourVaMaDiaDiem(maTour, maDiaDiem);
        } catch (Exception e) {
            System.err.println("Lỗi khi xóa điểm đến: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Map<String, Object>> layDanhSachDiemDen(int maTour) {
         if (maTour <= 0) {
             System.err.println("Mã tour không hợp lệ để lấy danh sách điểm đến.");
             return new ArrayList<>(); // Trả về danh sách rỗng
         }
        List<Map<String, Object>> resultList = new ArrayList<>();
        try {
            List<TourDiaDiem> diaDiems = tourDiaDiemDAO.layDanhSachDiaDiemTheoTour(maTour);
            for (TourDiaDiem tdd : diaDiems) {
                Map<String, Object> map = new LinkedHashMap<>();
                map.put("maTour", tdd.getMaTour());
                map.put("maDiaDiem", tdd.getMaDiaDiem());
                map.put("thuTu", tdd.getThuTu());
                map.put("thoiGianLuuTru", tdd.getThoiGianLuuTru());
                // Nếu cần lấy tên địa điểm, cần join và thêm DiaDiemDAO
                // map.put("tenDiaDiem", diaDiemDAO.timTheoMa(tdd.getMaDiaDiem()).getTenDiaDiem());
                resultList.add(map);
            }
        } catch (Exception e) {
            System.err.println("Lỗi khi lấy danh sách điểm đến: " + e.getMessage());
            e.printStackTrace();
            // Có thể trả về danh sách rỗng hoặc ném lỗi tùy theo yêu cầu
        }
        return resultList;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Quản lý Phương Tiện">
    @Override
    public boolean capNhatPhuongTien(int maTour, int maPhuongTien, Date ngayBatDau, Date ngayKetThuc) {
        if (maTour <= 0 || maPhuongTien <= 0 || ngayBatDau == null || ngayKetThuc == null || ngayBatDau.after(ngayKetThuc)) {
            System.err.println("Thông tin cập nhật phương tiện không hợp lệ.");
            return false;
        }

        TourPhuongTien existing = tourPhuongTienDAO.timTourPhuongTien(maTour, maPhuongTien);
        TourPhuongTien tourPhuongTien = new TourPhuongTien(maTour, maPhuongTien, ngayBatDau, ngayKetThuc);

        try {
            if (existing != null) {
                return tourPhuongTienDAO.sua(tourPhuongTien);
            } else {
                return tourPhuongTienDAO.them(tourPhuongTien);
            }
        } catch (Exception e) {
             System.err.println("Lỗi khi cập nhật phương tiện: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean xoaPhuongTien(int maTour, int maPhuongTien) {
         if (maTour <= 0 || maPhuongTien <= 0) {
             System.err.println("Mã tour hoặc mã phương tiện không hợp lệ để xóa.");
             return false;
         }
        try {
            // Đảm bảo phương thức xoa(int maTour, int maPhuongTien) tồn tại trong TourPhuongTienDAOImpl
            // Hoặc sử dụng tên phương thức chính xác nếu khác
             return tourPhuongTienDAO.xoa(maTour, maPhuongTien);
        } catch (Exception e) {
             System.err.println("Lỗi khi xóa phương tiện: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Map<String, Object>> layDanhSachPhuongTien(int maTour) {
        if (maTour <= 0) {
             System.err.println("Mã tour không hợp lệ để lấy danh sách phương tiện.");
             return new ArrayList<>();
         }
        List<Map<String, Object>> resultList = new ArrayList<>();
        try {
            List<TourPhuongTien> phuongTiens = tourPhuongTienDAO.layDanhSachPhuongTienTheoTour(maTour);
            for (TourPhuongTien tpt : phuongTiens) {
                Map<String, Object> map = new LinkedHashMap<>();
                map.put("maTour", tpt.getMaTour());
                map.put("maPhuongTien", tpt.getMaPhuongTien());
                map.put("ngayBatDau", tpt.getNgayBatDau());
                map.put("ngayKetThuc", tpt.getNgayKetThuc());
                // Nếu cần lấy tên phương tiện, cần join và thêm PhuongTienDAO
                // map.put("tenPhuongTien", phuongTienDAO.timTheoMa(tpt.getMaPhuongTien()).getTenPhuongTien());
                resultList.add(map);
            }
        } catch (Exception e) {
            System.err.println("Lỗi khi lấy danh sách phương tiện: " + e.getMessage());
            e.printStackTrace();
        }
        return resultList;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Quản lý Chỗ Ở">
    @Override
    public boolean capNhatChoO(int maTour, int maChoO, Date ngayNhan, Date ngayTra, int soPhong, String loaiPhong, String ghiChu) {
         if (maTour <= 0 || maChoO <= 0 || ngayNhan == null || ngayTra == null || ngayNhan.after(ngayTra) || soPhong <= 0 || loaiPhong == null || loaiPhong.trim().isEmpty()) {
             System.err.println("Thông tin cập nhật chỗ ở không hợp lệ.");
             return false;
         }

        TourChoO existing = tourChoODAO.timTourChoO(maTour, maChoO);
        // Chuyển Date sang String "yyyy-MM-dd" cho Entity TourChoO
        String ngayNhanStr = dateFormat.format(ngayNhan);
        String ngayTraStr = dateFormat.format(ngayTra);

        TourChoO tourChoO = new TourChoO(maTour, maChoO, ngayNhanStr, ngayTraStr, soPhong, ghiChu, loaiPhong);

        try {
            if (existing != null) {
                return tourChoODAO.sua(tourChoO);
            } else {
                return tourChoODAO.them(tourChoO);
            }
        } catch (Exception e) {
             System.err.println("Lỗi khi cập nhật chỗ ở: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean xoaChoO(int maTour, int maChoO) {
         if (maTour <= 0 || maChoO <= 0) {
              System.err.println("Mã tour hoặc mã chỗ ở không hợp lệ để xóa.");
             return false;
         }
        try {
            
            return tourChoODAO.xoa(maTour, maChoO);
        } catch (NoSuchMethodError nsme) {
             System.err.println("Lỗi: Phương thức xoa(int maTour, int maChoO) chưa được định nghĩa trong TourChoODAOImpl.");
             nsme.printStackTrace();
             return false;
        } catch (Exception e) {
             System.err.println("Lỗi khi xóa chỗ ở: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Map<String, Object>> layDanhSachChoO(int maTour) {
        if (maTour <= 0) {
             System.err.println("Mã tour không hợp lệ để lấy danh sách chỗ ở.");
             return new ArrayList<>();
         }
        List<Map<String, Object>> resultList = new ArrayList<>();
        try {
            List<TourChoO> choOs = tourChoODAO.layDanhSachChoOTheoTour(maTour);
            for (TourChoO tco : choOs) {
                Map<String, Object> map = new LinkedHashMap<>();
                map.put("maTour", tco.getMaTour());
                map.put("maChoO", tco.getMaChoO());
                map.put("ngayNhanPhong", tco.getNgayNhanPhong()); // Trả về String "yyyy-MM-dd" từ entity
                map.put("ngayTraPhong", tco.getNgayTraPhong()); // Trả về String "yyyy-MM-dd" từ entity
                map.put("soPhong", tco.getSoPhong());
                map.put("loaiPhong", tco.getLoaiPhong());
                map.put("ghiChu", tco.getGhiChu());
                 // Nếu cần lấy tên chỗ ở, cần join và thêm ChoODAO
                 // map.put("tenChoO", choODAO.timTheoMa(tco.getMaChoO()).getTenChoO());
                resultList.add(map);
            }
        } catch (Exception e) {
            System.err.println("Lỗi khi lấy danh sách chỗ ở: " + e.getMessage());
            e.printStackTrace();
        }
        return resultList;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Quản lý Nhân Viên">
    @Override
    public boolean capNhatNhanVien(int maTour, int maNV, String vaiTro) {
         if (maTour <= 0 || maNV <= 0 || vaiTro == null || vaiTro.trim().isEmpty()) {
              System.err.println("Thông tin cập nhật nhân viên không hợp lệ.");
             return false;
         }

        TourNhanVien existing = tourNhanVienDAO.timTourNhanVien(maTour, maNV);
        TourNhanVien tourNhanVien = new TourNhanVien(maTour, maNV, vaiTro);

        try {
            if (existing != null) {
                return tourNhanVienDAO.sua(tourNhanVien);
            } else {
                return tourNhanVienDAO.them(tourNhanVien);
            }
        } catch (Exception e) {
             System.err.println("Lỗi khi cập nhật nhân viên: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean xoaNhanVien(int maTour, int maNV) {
        if (maTour <= 0 || maNV <= 0) {
              System.err.println("Mã tour hoặc mã nhân viên không hợp lệ để xóa.");
             return false;
         }
        try {
   
             return tourNhanVienDAO.xoa(maTour, maNV);
        } catch (NoSuchMethodError nsme) {
             System.err.println("Lỗi: Phương thức xoa(int maTour, int maNV) chưa được định nghĩa trong TourNhanVienDAOImpl.");
             nsme.printStackTrace();
             return false;
         } catch (Exception e) {
             System.err.println("Lỗi khi xóa nhân viên: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Map<String, Object>> layDanhSachNhanVien(int maTour) {
         if (maTour <= 0) {
              System.err.println("Mã tour không hợp lệ để lấy danh sách nhân viên.");
             return new ArrayList<>();
         }
        List<Map<String, Object>> resultList = new ArrayList<>();
        try {
            List<TourNhanVien> nhanViens = tourNhanVienDAO.layDanhSachNhanVienTheoTour(maTour);
            for (TourNhanVien tnv : nhanViens) {
                Map<String, Object> map = new LinkedHashMap<>();
                map.put("maTour", tnv.getMaTour());
                map.put("maNV", tnv.getMaNV());
                map.put("vaiTro", tnv.getVaiTro());
                 // Nếu cần lấy tên nhân viên, cần join và thêm NhanVienDAO
                 // map.put("tenNV", nhanVienDAO.timTheoMa(tnv.getMaNV()).getTenNV());
                resultList.add(map);
            }
        } catch (Exception e) {
            System.err.println("Lỗi khi lấy danh sách nhân viên: " + e.getMessage());
            e.printStackTrace();
        }
        return resultList;
    }
    //</editor-fold>


}