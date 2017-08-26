package com.jalagbe.app.base.action;

import com.jalagbe.app.model.JalagbeResponse;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by rahma on 8/15/2017.
 */
public interface BaseAction<T> {

    boolean executeUpdate(T model);

    boolean executeInsert(T model);

    boolean executeDelete(long id);

    Map<String, ?> execute();
}
