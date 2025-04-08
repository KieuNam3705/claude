/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tourmanagement.dao.interfaces.common;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author phanh
 */
public interface ITimKiem<T> {
    T timTheoMa(int id);
    List<T> layDanhSach();
}