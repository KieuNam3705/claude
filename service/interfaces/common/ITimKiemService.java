/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tourmanagement.service.interfaces.common;

import com.tourmanagement.dao.interfaces.common.ITimKiem;
import java.util.List;

/**
 *
 * @author phanh
 */
public interface ITimKiemService<T> extends ITimKiem<T> {
    @Override
    T timTheoMa(int id);

    @Override
    List<T> layDanhSach();
}
