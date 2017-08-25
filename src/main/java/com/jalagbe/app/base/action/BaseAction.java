package com.jalagbe.app.base.action;

import com.jalagbe.app.model.JalagbeResponse;

import java.util.Map;

/**
 * Created by rahma on 8/15/2017.
 */
public interface BaseAction<T> {

    Map<String, ?> execute();

    JalagbeResponse execute(T model);

}
