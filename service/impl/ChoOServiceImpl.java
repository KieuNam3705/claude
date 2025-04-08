package com.tourmanagement.service.impl;

import com.tourmanagement.dao.interfaces.IChoODAO;
import com.tourmanagement.dao.impl.ChoODAOImpl;
import com.tourmanagement.dto.ChoODTO;
import com.tourmanagement.entity.ChoO;
import com.tourmanagement.exception.BusinessLogicException;
import com.tourmanagement.service.interfaces.IChoOService;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChoOServiceImpl implements IChoOService {
    private final IChoODAO choODAO;
    private final ChoODTO.ChoOMapper choOMapper;

    // Constructor với dependency injection
    public ChoOServiceImpl(IChoODAO choODAO) {
        this.choODAO = choODAO;
        this.choOMapper = new ChoODTO.ChoOMapper(); // Khởi tạo mapper
    }
    
    // Constructor mặc định
    public ChoOServiceImpl() {
        this.choODAO = new ChoODAOImpl();
        this.choOMapper = new ChoODTO.ChoOMapper(); // Khởi tạo mapper
    }
    
    /**
     * Kiểm tra tính hợp lệ của thông tin chỗ ở
     * @param choO đối tượng chỗ ở cần kiểm tra
     * @throws BusinessLogicException nếu dữ liệu không hợp lệ
     */
    private void validateChoO(ChoO choO) throws BusinessLogicException {
        // Kiểm tra tên chỗ ở
        if (choO.getTenChoO() == null || choO.getTenChoO().trim().isEmpty()) {
            throw new BusinessLogicException("Tên chỗ ở không được để trống.");
        }
        
        // Kiểm tra loại chỗ ở
        if (choO.getLoaiChoO() == null || choO.getLoaiChoO().trim().isEmpty()) {
            throw new BusinessLogicException("Loại chỗ ở không được để trống.");
        }
        
        // Kiểm tra địa chỉ
        if (choO.getDiaChi() == null || choO.getDiaChi().trim().isEmpty()) {
            throw new BusinessLogicException("Địa chỉ không được để trống.");
        }
        
        // Kiểm tra thành phố
        if (choO.getThanhPho() == null || choO.getThanhPho().trim().isEmpty()) {
            throw new BusinessLogicException("Thành phố không được để trống.");
        }
        
        // Kiểm tra quốc gia
        if (choO.getQuocGia() == null || choO.getQuocGia().trim().isEmpty()) {
            throw new BusinessLogicException("Quốc gia không được để trống.");
        }
        
        // Kiểm tra số điện thoại (nếu có)
        if (choO.getSoDienThoai() != null && !choO.getSoDienThoai().isEmpty() && 
            !choO.getSoDienThoai().matches("^0\\d{9,10}$")) {
            throw new BusinessLogicException("Số điện thoại không hợp lệ. Phải bắt đầu bằng 0 và có 10-11 chữ số.");
        }
        
        // Kiểm tra email (nếu có)
        if (choO.getEmail() != null && !choO.getEmail().isEmpty() && 
            !choO.getEmail().matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            throw new BusinessLogicException("Định dạng email không hợp lệ.");
        }
        
        // Kiểm tra số sao
        if (choO.getSoSao() < 1 || choO.getSoSao() > 5) {
            throw new BusinessLogicException("Số sao phải nằm trong khoảng từ 1 đến 5.");
        }
        
        // Kiểm tra giá thuê
        if (choO.getGiaThue() == null || choO.getGiaThue().compareTo(BigDecimal.ZERO) <= 0) {
            throw new BusinessLogicException("Giá thuê phải lớn hơn 0.");
        }
    }
    
    /**
     * Lấy chi tiết Chỗ Ở và trả về dưới dạng Map chứa ChoODTO.
     * @param maChoO Mã chỗ ở cần lấy chi tiết.
     * @return Map chứa thông tin chi tiết Chỗ Ở dưới dạng DTO nếu tìm thấy (key="choO"), 
     *         ngược lại trả về null.
     * @throws IllegalArgumentException nếu mã chỗ ở không hợp lệ.
     */
    public Map<String, Object> layChiTiet(int maChoO) {
        // Kiểm tra mã chỗ ở
        if (maChoO <= 0) {
            throw new IllegalArgumentException("Mã chỗ ở không hợp lệ.");
        }

        ChoO choO = choODAO.timTheoMa(maChoO);
        if (choO == null) {
            return null; // hoặc trả về Map rỗng tùy theo yêu cầu
        }

        // Chuyển đổi sang DTO và đưa vào Map
        Map<String, Object> chiTiet = new HashMap<>();
        ChoODTO choODTO = choOMapper.toDTO(choO); // Sử dụng mapper
        chiTiet.put("choO", choODTO); // Đặt DTO vào Map

        return chiTiet;
    }

    @Override
    public List<ChoO> timTheoTen(String tenChoO) {
        if (tenChoO == null || tenChoO.trim().isEmpty()) {
            throw new IllegalArgumentException("Tên chỗ ở không được để trống");
        }
        return choODAO.timChoOTheoTen(tenChoO);
    }

    @Override
    public List<ChoO> layDanhSachTheoLoai(String loaiChoO) {
        if (loaiChoO == null || loaiChoO.trim().isEmpty()) {
            throw new IllegalArgumentException("Loại chỗ ở không được để trống");
        }
        return choODAO.layDanhSachChoOTheoLoai(loaiChoO);
    }

    @Override
    public List<ChoO> layDanhSachTheoThanhPho(String thanhPho) {
        if (thanhPho == null || thanhPho.trim().isEmpty()) {
            throw new IllegalArgumentException("Thành phố không được để trống");
        }
        return choODAO.layDanhSachChoOTheoThanhPho(thanhPho);
    }

    @Override
    public List<ChoO> layDanhSachTheoSoSao(int soSao) {
        if (soSao < 1 || soSao > 5) {
            throw new IllegalArgumentException("Số sao phải nằm trong khoảng 1-5");
        }
        return choODAO.layDanhSachChoOTheoSoSao(soSao);
    }

    @Override
    public List<ChoO> layDanhSachTheoTour(int maTour) {
        if (maTour <= 0) {
            throw new IllegalArgumentException("Mã tour không hợp lệ");
        }
        return choODAO.layDanhSachChoOTheoTour(maTour);
    }

    @Override
    public boolean them(ChoO choO) {
        try {
            // Kiểm tra dữ liệu đầu vào
            if (choO == null) {
                throw new BusinessLogicException("Thông tin chỗ ở không được null.");
            }
            
            // Validate dữ liệu Entity
            validateChoO(choO);
            
            return choODAO.them(choO);
        } catch (BusinessLogicException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    @Override
    public boolean sua(ChoO choO) {
        try {
            // Kiểm tra dữ liệu đầu vào
            if (choO == null) {
                throw new BusinessLogicException("Thông tin chỗ ở không được null.");
            }
            
            // Kiểm tra mã chỗ ở
            if (choO.getMaChoO() <= 0) {
                throw new BusinessLogicException("Mã chỗ ở không hợp lệ.");
            }
            
            // Kiểm tra chỗ ở có tồn tại không
            ChoO existingChoO = choODAO.timTheoMa(choO.getMaChoO());
            if (existingChoO == null) {
                throw new BusinessLogicException("Chỗ ở không tồn tại.");
            }
            
            // Validate dữ liệu Entity
            validateChoO(choO);
            
            return choODAO.sua(choO);
        } catch (BusinessLogicException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    @Override
    public boolean xoa(int id) {
        try {
            // Kiểm tra mã chỗ ở
            if (id <= 0) {
                throw new BusinessLogicException("Mã chỗ ở không hợp lệ.");
            }
            
            // Kiểm tra chỗ ở có tồn tại không
            ChoO existingChoO = choODAO.timTheoMa(id);
            if (existingChoO == null) {
                throw new BusinessLogicException("Chỗ ở không tồn tại.");
            }
            
            // TODO: Kiểm tra xem chỗ ở đã được sử dụng trong tour nào chưa trước khi xóa
            
            return choODAO.xoa(id);
        } catch (BusinessLogicException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    @Override
    public ChoO timTheoMa(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("Mã chỗ ở không hợp lệ");
        }
        return choODAO.timTheoMa(id);
    }

    @Override
    public List<ChoO> layDanhSach() {
        return choODAO.layDanhSach();
    }
}