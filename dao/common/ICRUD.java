/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tourmanagement.dao.interfaces.common;

/**
 *
 * @author phanh
 * @param <T>
 */
public interface ICRUD<T> {
    boolean them(T obj);
    boolean sua(T obj);
    boolean xoa(int id);
}
