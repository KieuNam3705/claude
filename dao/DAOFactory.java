/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tourmanagement.dao;
import com.tourmanagement.dao.impl.TourPhuongTienDAOImpl;
import com.tourmanagement.dao.impl.ChiTietThanhToanDAOImpl;
import com.tourmanagement.dao.impl.TourDAOImpl;
import com.tourmanagement.dao.impl.TourChoODAOImpl;
import com.tourmanagement.dao.impl.TourDiaDiemDAOImpl;
import com.tourmanagement.dao.impl.TourNhanVienDAOImpl;
import com.tourmanagement.dao.impl.DatTourDAOImpl;
import com.tourmanagement.dao.impl.ChoODAOImpl;
import com.tourmanagement.dao.impl.HoaDonDAOImpl;
import com.tourmanagement.dao.impl.PhuongTienDAOImpl;
import com.tourmanagement.dao.impl.DiaDiemDAOImpl;
import com.tourmanagement.dao.impl.NhanVienDAOImpl;
import com.tourmanagement.dao.impl.*;
import com.tourmanagement.dao.interfaces.*;

/**
 *
 * @author phanh
 */

public class DAOFactory {
    private static DAOFactory instance;

    private final IKhachHangDAO khachHangDAO;
    private final ITourDAO tourDAO;
    private final INhanVienDAO nhanVienDAO;
    private final IDiaDiemDAO diaDiemDAO;
    private final IPhuongTienDAO phuongTienDAO;
    private final IChoODAO choODAO;
    private final IDatTourDAO datTourDAO;
    private final IHoaDonDAO hoaDonDAO;
    private final ITourDiaDiemDAO tourDiaDiemDAO;
    private final ITourPhuongTienDAO tourPhuongTienDAO;
    private final ITourChoODAO tourChoODAO;
    private final ITourNhanVienDAO tourNhanVienDAO;
    private final IChiTietThanhToanDAO chiTietThanhToanDAO;

    // Private constructor để ngăn chặn tạo instance từ bên ngoài
    private DAOFactory() {
        khachHangDAO = new KhachHangDAOImpl();
        tourDAO = new TourDAOImpl();
        nhanVienDAO = new NhanVienDAOImpl();
        diaDiemDAO = new DiaDiemDAOImpl();
        phuongTienDAO = new PhuongTienDAOImpl();
        choODAO = new ChoODAOImpl();
        datTourDAO = new DatTourDAOImpl();
        hoaDonDAO = new HoaDonDAOImpl();
        tourDiaDiemDAO = new TourDiaDiemDAOImpl();
        tourPhuongTienDAO = new TourPhuongTienDAOImpl();
        tourChoODAO = new TourChoODAOImpl();
        tourNhanVienDAO = new TourNhanVienDAOImpl();
        chiTietThanhToanDAO = new ChiTietThanhToanDAOImpl();
    }
    // Đảm bảo chỉ có một instance duy nhất của DAOFactory
    public static DAOFactory getInstance() {
        if (instance == null) {
            synchronized (DAOFactory.class) {  // Đảm bảo thread-safety
                if (instance == null) {
                    instance = new DAOFactory();
                }
            }
        }
        return instance;
    }

    // Các phương thức để lấy instance của DAO cụ thể
    public IKhachHangDAO getKhachHangDAO() {
        return khachHangDAO;
    }

    public ITourDAO getTourDAO() {
        return tourDAO;
    }

    public INhanVienDAO getNhanVienDAO() {
        return nhanVienDAO;
    }

    public IDiaDiemDAO getDiaDiemDAO() {
        return diaDiemDAO;
    }

    public IPhuongTienDAO getPhuongTienDAO() {
        return phuongTienDAO;
    }

    public IChoODAO getChoODAO() {
        return choODAO;
    }

    public IDatTourDAO getDatTourDAO() {
        return datTourDAO;
    }

    public IHoaDonDAO getHoaDonDAO() {
        return hoaDonDAO;
    }

    public ITourDiaDiemDAO getTourDiaDiemDAO() {
        return tourDiaDiemDAO;
    }

    public ITourPhuongTienDAO getTourPhuongTienDAO() {
        return tourPhuongTienDAO;
    }

    public ITourChoODAO getTourChoODAO() {
        return tourChoODAO;
    }

    public ITourNhanVienDAO getTourNhanVienDAO() {
        return tourNhanVienDAO;
    }

    public IChiTietThanhToanDAO getChiTietThanhToanDAO() {
        return chiTietThanhToanDAO;
    }
}
