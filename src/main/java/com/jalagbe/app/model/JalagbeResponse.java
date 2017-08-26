package com.jalagbe.app.model;

import com.fasterxml.jackson.annotation.JsonView;

public class JalagbeResponse {
    @JsonView(Views.Public.class)
    String body;

    @JsonView(Views.Public.class)
    int status;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
