/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tourmanagement.service.interfaces.common;
import com.tourmanagement.dao.interfaces.common.ICRUD;
import com.tourmanagement.exception.BusinessLogicException;
/**
 *
 * @author phanh
 * @param <T>
 */
public interface ICRUDService<T> extends ICRUD<T> {

    /**
     *
     * @param entity
     * @return
     * @throws com.tourmanagement.exception.BusinessLogicException
     * @throws BusinessLogicException
     */
    @Override
    boolean them(T entity) throws BusinessLogicException;

    @Override
    boolean sua(T entity) throws BusinessLogicException;

    @Override
    boolean xoa(int id) throws BusinessLogicException;
}

