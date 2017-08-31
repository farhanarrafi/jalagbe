package com.jalagbe.app.base.dao;

import java.io.Serializable;
import java.util.List;

public interface JalagbeDao<T, PK extends Serializable> {

    boolean insert(T object) throws Exception;

    T get(PK id) throws Exception;

    List<T> getAll() throws Exception;

    boolean updateTableData(T object) throws Exception;

    boolean deleteTableData(T object) throws Exception;

    List<T> getDataByColumnName(String columnName, String input) throws Exception;

}
