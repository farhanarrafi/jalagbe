package com.jalagbe.app.model;

import com.fasterxml.jackson.annotation.JsonView;

import java.io.Serializable;

/**
 * Created by rahma on 8/22/2017.
 */
public class CategoryResponse implements Serializable {
    @JsonView(Views.Public.class)
    String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
