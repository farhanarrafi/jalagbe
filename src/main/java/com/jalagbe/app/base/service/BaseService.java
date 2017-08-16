package com.jalagbe.app.base.service;

import java.io.Serializable;
import java.util.List;

/**
 * Created by fsocity on 2/20/17.
 */
public interface BaseService<T, PK extends Serializable> {

    boolean save(T object) throws Exception;

    boolean delete(T object) throws Exception;

    boolean update(T object) throws Exception;

    List<T> getAll() throws Exception;

    T get(PK id) throws Exception;

    List<T> getDataBy(String columnName, String input) throws Exception;
}
