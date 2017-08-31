package com.jalagbe.app.base.action;

import com.jalagbe.app.base.service.JalagbeService;

import java.util.Map;

/**
 * Created by rahma on 8/15/2017.
 */
public interface JalagbeAction<T> {

    boolean executeUpdate(T model, JalagbeService jalagbeService) throws Exception;

    boolean executeInsert(T model, JalagbeService jalagbeService) throws Exception;

    boolean executeDelete(long id, JalagbeService jalagbeService) throws Exception;

    Map<String, ?> execute(JalagbeService jalagbeService) throws Exception;
}
